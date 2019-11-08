package com.kirilo.patterns.creational.singleton;

public class EagerInitialized extends AbstractSingleton {
    private static final EagerInitialized INITIALIZED = new EagerInitialized();
    private static EagerInitialized instance;

    private EagerInitialized() {
        super();
    }

    private EagerInitialized(String value, Integer sleepValue) {
        super(value, sleepValue);
    }

    public static EagerInitialized getInstance() {
        return INITIALIZED;
    }

    public static EagerInitialized getInstance(String value, Integer sleepValue) {
        if (instance == null) {
            instance = new EagerInitialized(value, sleepValue);
        }
        return instance;
    }
}
