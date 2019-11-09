package com.kirilo.patterns.creational.singleton.singletons;

import java.util.Random;

public class DoubleCheckedLockingSingleton extends AbstractSingleton{
    private static DoubleCheckedLockingSingleton instance;
    private static DoubleCheckedLockingSingleton initialize;

    private DoubleCheckedLockingSingleton() {
        super();
    }

    private DoubleCheckedLockingSingleton(String value, Integer sleepValue) {
        super(value, sleepValue);
    }

    public static DoubleCheckedLockingSingleton getInstance() {
        if (initialize == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (initialize == null) {
                    initialize = new DoubleCheckedLockingSingleton("default Double Checked Locking Singleton" + new Random().nextInt(100), 1000);
                }
            }
        }
        return initialize;
    }

    public static DoubleCheckedLockingSingleton getInstance(String value, Integer sleepValue) {
        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton(value, sleepValue);
                }
            }
        }
        return instance;
    }
}
