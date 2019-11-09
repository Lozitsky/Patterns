package com.kirilo.patterns.creational.singleton;

import java.util.Objects;

public abstract class AbstractSingleton implements Singleton {
    private String value;

    AbstractSingleton() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    AbstractSingleton(String value, Integer sleepValue) {
        try {
            Thread.sleep(sleepValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.value = value;
    }

    // https://javarevisited.blogspot.com/2013/03/can-we-overload-and-override-static-method-java.html
    static AbstractSingleton getInstance() {
        return null;
    }

    // https://javarevisited.blogspot.com/2013/03/can-we-overload-and-override-static-method-java.html
    static AbstractSingleton getInstance(String value, Integer sleepValue) {

        return null;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractSingleton)) return false;
        AbstractSingleton that = (AbstractSingleton) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
