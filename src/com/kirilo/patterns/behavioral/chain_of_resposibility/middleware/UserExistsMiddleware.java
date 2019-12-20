package com.kirilo.patterns.behavioral.chain_of_resposibility.middleware;

import com.kirilo.patterns.behavioral.chain_of_resposibility.server.Server;

public class UserExistsMiddleware extends Middleware {
    private Server server;

    public UserExistsMiddleware(Server server) {
        this.server = server;
    }


    @Override
    public boolean check(String email, String password) {
        if (!server.hasEmail(email) || !server.isValidPassword(email, password)) {
            System.out.println("This email is not registered or password is wrong!");
            return false;
        }
        return checkNext(email, password);
    }
}
