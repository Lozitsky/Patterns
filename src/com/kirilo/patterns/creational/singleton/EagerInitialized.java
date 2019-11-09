package com.kirilo.patterns.creational.singleton;

import java.util.Random;

public class EagerInitialized extends AbstractSingleton {
    private static String value = "default Eager Singleton"+ new Random().nextInt(100);
    private static Integer sleepValue = 1000;
    private static final EagerInitialized INITIALIZED = new EagerInitialized();
    private static final EagerInitialized INSTANCE = new EagerInitialized(value, sleepValue);

    private EagerInitialized() {
        super();
    }

    private EagerInitialized(String value, Integer sleepValue) {
        super(value, sleepValue);
    }

    // Eager initialization
    public static EagerInitialized getInstance() {
        return INITIALIZED;
    }

    // Eager initialization
    public static EagerInitialized getInstance(String value, Integer sleepValue) {
        EagerInitialized.value = value;
        EagerInitialized.sleepValue = sleepValue;
        return INSTANCE;
    }
}
