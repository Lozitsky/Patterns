package com.kirilo.patterns.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ClientCode {
    public static void main(String[] args) {
        EagerInitialized singleton
                = EagerInitialized.getInstance("Singleton", 1000);
        EagerInitialized anotherSingleton
                = EagerInitialized.getInstance("Singleton", 1000);
        EagerInitialized reflectionSingleton = null;

        TestSingleton(singleton, anotherSingleton, reflectionSingleton);


    }

    private static void TestSingleton(EagerInitialized singleton, EagerInitialized anotherSingleton, AbstractSingleton reflectionSingleton) {
        Constructor<?>[] constructors = EagerInitialized.class.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            constructor.setAccessible(true);
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            String parameters = Arrays.toString(parameterTypes);
            System.out.println("Constructor parameters: " + parameters);
            try {
                if (singleton.getClass().equals(EagerInitialized.class)) {
                    reflectionSingleton = (EagerInitialized) (parameters.equals("[]") ? constructor.newInstance() : constructor.newInstance("Singleton", 1000));
                } else {
                    reflectionSingleton = (AbstractSingleton) (parameters.equals("[]") ? constructor.newInstance() : constructor.newInstance("Singleton", 1000));
                }
//                break;
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        print("singleton: ", singleton);
        print("anotherSingleton: ", anotherSingleton);
        print("\n\nGet Singleton using reflection."
                + "\nreflectionSingleton: ", reflectionSingleton);

        System.out.println("\nMulti threads test.");
        Thread threadOne = new Thread(new ThreadOne("ThreadOne", singleton.getClass()));
        Thread threadTwo = new Thread(new ThreadTwo("ThreadTwo", singleton.getClass()));
        threadOne.start();
        threadTwo.start();
    }

    private static void print(String s, AbstractSingleton instance) {
        String values = instance != null ? (getValues(instance)) : "0";
        System.out.println(s + ": " + values);
    }

    private static String getValues(AbstractSingleton instance) {
        return instance.getValue() + ", " + instance.hashCode();
    }

    static class ThreadTwo extends ThreadSingleton {
        ThreadTwo(String threadName, Class<? extends AbstractSingleton> clazz) {
            super(threadName, clazz);
        }
    }

    static class ThreadOne extends ThreadSingleton {
        ThreadOne(String threadName, Class<? extends AbstractSingleton> clazz) {
            super(threadName, clazz);
        }
    }

    private static abstract class ThreadSingleton implements Runnable {
        private AbstractSingleton instance;
        private String threadName;

        ThreadSingleton(String threadName, Class<? extends AbstractSingleton> clazz) {
            this.threadName = threadName;
            if (clazz.equals(EagerInitialized.class)) {
                instance = EagerInitialized.getInstance("Singleton", 1000);
            } else {
                instance = AbstractSingleton.getInstance("Singleton", 1000);
            }
        }

        @Override
        public void run() {
            print(threadName, instance);
        }
    }
}
