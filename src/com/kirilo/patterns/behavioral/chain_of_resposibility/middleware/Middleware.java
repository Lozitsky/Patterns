package com.kirilo.patterns.behavioral.chain_of_resposibility.middleware;

public abstract class Middleware {
    private Middleware middleware;

    public Middleware linkWith(Middleware middleware) {
        this.middleware = middleware;
        return middleware;
    }

    public abstract boolean check(String email, String password);

    protected boolean checkNext(String email, String password) {
        return middleware == null || middleware.check(email, password);
    }
}
