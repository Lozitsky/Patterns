package com.kirilo.patterns.creational.singleton.singletons;

import java.util.Random;

public class EagerInitializedSingleton extends AbstractSingleton {
    private static String value = "default Eager Singleton"+ new Random().nextInt(100);
    private static Integer sleepValue = 1000;
    private static final EagerInitializedSingleton INITIALIZED = new EagerInitializedSingleton(value + " without parameters", sleepValue);
    private static final EagerInitializedSingleton INSTANCE = new EagerInitializedSingleton(value, sleepValue);

    private EagerInitializedSingleton() {
        super();
    }

    private EagerInitializedSingleton(String value, Integer sleepValue) {
        super(value, sleepValue);
    }

    // Eager initialization
    public static EagerInitializedSingleton getInstance() {
        value = "new default Eager Singleton"+ new Random().nextInt(100);
        sleepValue = 1000;
        return INITIALIZED;
    }

    // Eager initialization
    public static EagerInitializedSingleton getInstance(String value, Integer sleepValue) {
        EagerInitializedSingleton.value = value;
        EagerInitializedSingleton.sleepValue = sleepValue;
        return INSTANCE;
    }
}
