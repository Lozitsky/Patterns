package com.kirilo.patterns.creational.singleton;

public abstract class AbstractSingleton implements Singleton {
    private String value;

    public AbstractSingleton() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public AbstractSingleton(String value, Integer sleepValue) {
        try {
            Thread.sleep(sleepValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    public static AbstractSingleton getInstance() {
        return null;
    }

    public static AbstractSingleton getInstance(String value, Integer sleepValue) {

        return null;
    }
}
