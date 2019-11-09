package com.kirilo.patterns.creational.singleton.singletons;

import java.util.Random;

public class ThreadSafeSingleton extends AbstractSingleton {
    private static ThreadSafeSingleton instance;
    private static ThreadSafeSingleton initialize;

    private ThreadSafeSingleton(String value, Integer sleepValue) {
        super(value, sleepValue);
    }

    private ThreadSafeSingleton() {
        super();
    }

    public static synchronized ThreadSafeSingleton getInstance() {
        if (initialize == null) {
            initialize = new ThreadSafeSingleton("default Thread Safe Singleton" + new Random().nextInt(100), 1000);
        }
        return initialize;
    }

    public static synchronized ThreadSafeSingleton getInstance(String value, Integer sleepValue) {
        if (instance == null) {
            instance = new ThreadSafeSingleton(value, sleepValue);
        }
        return instance;
    }
}
