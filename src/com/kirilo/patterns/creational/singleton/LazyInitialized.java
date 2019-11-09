package com.kirilo.patterns.creational.singleton;

import java.util.Random;

public class LazyInitialized extends AbstractSingleton {
    private static LazyInitialized instance;
    private static LazyInitialized initialize;

    private LazyInitialized(String value, Integer sleepValue) {
        super(value, sleepValue);
    }

    private LazyInitialized() {
        super();
    }

    public static LazyInitialized getInstance(String value, Integer sleepValue) {
        if (instance == null) {
            instance = new LazyInitialized(value, sleepValue);
        }
        return instance;
    }

    public static LazyInitialized getInstance() {
        if (initialize == null) {
            initialize = new LazyInitialized("default Lazy Singleton" + new Random().nextInt(100), 1000);
        }
        return initialize;
    }
}
