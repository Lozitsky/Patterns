package com.kirilo.patterns.creational.singleton.singletons;

import java.util.Random;

public class StaticBlockInitializedSingleton extends AbstractSingleton {
    private final static StaticBlockInitializedSingleton instance;
    private final static StaticBlockInitializedSingleton initialize;
    private static String value = "default Static Block Singleton"+ new Random().nextInt(100);
    private static Integer sleepValue = 1000;

    static {
        try {
            instance = new StaticBlockInitializedSingleton(value + " without parameters", sleepValue);
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }

    static {
        try {
            initialize = new StaticBlockInitializedSingleton(value, sleepValue);
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton initialize");
        }
    }

    private StaticBlockInitializedSingleton() {
        super();
    }

    private StaticBlockInitializedSingleton(String value, Integer sleepValue) {
        super(value, sleepValue);
    }

    public static StaticBlockInitializedSingleton getInstance() {
        sleepValue = 1000;
        value = "new default Static Block Singleton"+ new Random().nextInt(100);
        return instance;
    }

    public static StaticBlockInitializedSingleton getInstance(String value, Integer sleepValue) {
        StaticBlockInitializedSingleton.value = value;
        StaticBlockInitializedSingleton.sleepValue = sleepValue;
        return initialize;
    }
}
