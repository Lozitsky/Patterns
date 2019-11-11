package com.kirilo.patterns.creational.singleton.singletons;

import java.util.Random;
// https://www.journaldev.com/716/java-enum
public enum EnumSingleton implements Singleton {
    INITIALIZE,
    INSTANCE("default Enum Singleton", 100);

    private String value = "default Enum Singleton" + new Random().nextInt(100);
    private Integer sleepValue = 0;

    EnumSingleton() {
        setValue("new default Enum Singleton" + new Random().nextInt(100));
        setSleepValue(1000);
        try {
            Thread.sleep(getSleepValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    EnumSingleton(String value, Integer sleepValue) {
        setValue(value);
        setSleepValue(sleepValue);
        try {
            Thread.sleep(sleepValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static EnumSingleton getInstance() {
        return INITIALIZE;
    }

    public static EnumSingleton getInstance(String value, Integer sleepValue) {
        EnumSingleton singleton = EnumSingleton.INSTANCE;
        singleton.setValue(value);
        singleton.setSleepValue(sleepValue);
        return INSTANCE;
    }

    @Override
    public String getValue() {
        return value;
    }

    private void setValue(String value) {
        this.value = value;
    }

    private Integer getSleepValue() {
        return sleepValue;
    }

    private void setSleepValue(Integer sleepValue) {
        this.sleepValue = sleepValue;
    }
}
