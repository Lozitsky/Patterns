package com.kirilo.patterns.behavioral.chain_of_resposibility.server;

import com.kirilo.patterns.behavioral.chain_of_resposibility.middleware.Middleware;

import java.util.HashMap;
import java.util.Map;

public class Server {
    private Middleware middleware;
    private Map<String, String> users = new HashMap<>();
    private Map<String, Role> roleUsers = new HashMap<>();

    public void setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }

    public boolean login(String email, String password) {
        boolean check = middleware.check(email, password);
        if (check) {
            System.out.println("Authorization has been successful!");
        }
        return check;
    }

    public void register(String email, String password) {
        users.put(email, password);
    }

    public void addRole(String email, Role role) {
        roleUsers.put(email, role);
    }

    public boolean hasEmail(String email) {
        return users.containsKey(email);
    }

    public boolean isValidPassword(String email, String password) {
        return users.get(email).equals(password);
    }

    public boolean isValidRole(String email, Role role) {
        return roleUsers.get(email).equals(role);
    }
}
