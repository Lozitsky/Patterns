package com.kirilo.patterns.creational.singleton;

import com.kirilo.patterns.creational.singleton.singletons.*;

import java.lang.reflect.InvocationTargetException;

public class ReflectionFactory {
    public Singleton invoke(Class<? extends Singleton> clazz, String name, boolean isWithParameters) {
        Object invoke;
        Singleton instance = null;
        try {
            if (isWithParameters) {
                invoke = clazz.getDeclaredMethod("getInstance", String.class, Integer.class).invoke(null, name + " " + clazz.getSimpleName(), 1000);
            } else {
                invoke = clazz.getDeclaredMethod("getInstance").invoke(null);
            }

            switch (clazz.getSimpleName()) {
                case "EagerInitializedSingleton":
                    instance = (EagerInitializedSingleton) invoke;
                    break;
                case "LazyInitializedSingleton":
                    instance = (LazyInitializedSingleton) invoke;
                    break;
                case "StaticBlockInitializedSingleton":
                    instance = (StaticBlockInitializedSingleton) invoke;
                    break;
                case "ThreadSafeSingleton":
                    instance = (ThreadSafeSingleton) invoke;
                    break;
                case "DoubleCheckedLockingSingleton":
                    instance = (DoubleCheckedLockingSingleton) invoke;
                    break;
                case "BillPughSingleton":
                    instance = (BillPughSingleton) invoke;
                    break;
                case "EnumSingleton":
                    instance = (EnumSingleton) invoke;
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + clazz.getSimpleName());
            }

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return instance;
    }
}
