package com.kirilo.patterns.behavioral.chain_of_resposibility.middleware;

public class ThrottlingMiddleware extends Middleware {
    private int requestPerMinute;
    private int request;
    private long currentTime;

    public ThrottlingMiddleware(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        currentTime = System.currentTimeMillis();
    }

    @Override
    public boolean check(String email, String password) {
        if (System.currentTimeMillis() > currentTime + 60_000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }
        request++;
        if (request > requestPerMinute) {
            System.out.println("Request limit exceeded! Wait 60 sec...");
//            Thread.currentThread().stop();
            try {
                Thread.sleep(60_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return checkNext(email, password);
    }
}
