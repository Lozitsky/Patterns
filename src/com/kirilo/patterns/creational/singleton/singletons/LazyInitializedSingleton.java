package com.kirilo.patterns.creational.singleton.singletons;

import java.util.Random;

public class LazyInitializedSingleton extends AbstractSingleton {
    private static LazyInitializedSingleton instance;
    private static LazyInitializedSingleton initialize;

    private LazyInitializedSingleton(String value, Integer sleepValue) {
        super(value, sleepValue);
    }

    private LazyInitializedSingleton() {
        super();
    }

    public static LazyInitializedSingleton getInstance(String value, Integer sleepValue) {
        if (instance == null) {
            instance = new LazyInitializedSingleton(value, sleepValue);
        }
        return instance;
    }

    public static LazyInitializedSingleton getInstance() {
        if (initialize == null) {
            initialize = new LazyInitializedSingleton("default Lazy Singleton" + new Random().nextInt(100), 1000);
        }
        return initialize;
    }
}
