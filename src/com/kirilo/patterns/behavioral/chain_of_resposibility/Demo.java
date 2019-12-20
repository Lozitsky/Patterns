package com.kirilo.patterns.behavioral.chain_of_resposibility;

import com.kirilo.patterns.behavioral.chain_of_resposibility.middleware.Middleware;
import com.kirilo.patterns.behavioral.chain_of_resposibility.middleware.RoleCheckMiddleware;
import com.kirilo.patterns.behavioral.chain_of_resposibility.middleware.ThrottlingMiddleware;
import com.kirilo.patterns.behavioral.chain_of_resposibility.middleware.UserExistsMiddleware;
import com.kirilo.patterns.behavioral.chain_of_resposibility.server.Role;
import com.kirilo.patterns.behavioral.chain_of_resposibility.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    private static Server server;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static void init() {
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.addRole("admin@example.com", Role.ADMIN);
        server.register("user@example.com", "user_pass");
        server.addRole("user@example.com", Role.USER);

        Middleware middleware = new ThrottlingMiddleware(2);
                middleware.linkWith(new UserExistsMiddleware(server))
                        .linkWith(new RoleCheckMiddleware(server));
        server.setMiddleware(middleware);
    }

    public static void main(String[] args) {
        init();
        boolean success;
        try {

            do {
                System.out.println("Enter email address: ");
                String email = reader.readLine();
                System.out.println("Enter password: ");
                String pass = reader.readLine();
                success = server.login(email, pass);
            } while (!success);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
