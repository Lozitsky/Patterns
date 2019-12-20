package com.kirilo.patterns.behavioral.chain_of_resposibility.middleware;

import com.kirilo.patterns.behavioral.chain_of_resposibility.server.Role;
import com.kirilo.patterns.behavioral.chain_of_resposibility.server.Server;

public class RoleCheckMiddleware extends Middleware {
    private Server server;

    public RoleCheckMiddleware(Server server) {
        this.server = server;
    }

    @Override
    public boolean check(String email, String password) {
        if (!server.hasEmail(email)) {
            return false;
        }
        if (server.isValidRole(email, Role.ADMIN)) {
            System.out.println("Hello admin!");
        } else if (server.isValidRole(email, Role.USER)) {
            System.out.println("Hello user!");
        } else {
            return false;
        }
        return checkNext(email, password);
    }
}
