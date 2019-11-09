package com.kirilo.patterns.creational.singleton;

import java.lang.reflect.InvocationTargetException;

public class ThreadSafeTest {
    public static void main(String[] args) {
        RunThreads.invoke(EagerInitialized.class, 5, true);
        RunThreads.invoke(LazyInitialized.class, 5, true);
        RunThreads.invoke(EagerInitialized.class, 5, false);
        RunThreads.invoke(LazyInitialized.class, 5, false);
    }

    static void print(String s, AbstractSingleton instance) {
        String values = instance != null ? (getValues(instance)) : "0";
        System.out.println(s + ": " + values);
    }

    private static String getValues(AbstractSingleton instance) {
        return instance.getValue() + ", " + instance.hashCode();
    }


    static class ThreadSingleton implements Runnable {
        private String threadName;
        private Class<? extends AbstractSingleton> clazz;
        private boolean isWithParameters;

        ThreadSingleton(String threadName, Class<? extends AbstractSingleton> clazz, boolean isWithParameters) {
            this.threadName = threadName;
            this.clazz = clazz;
            this.isWithParameters = isWithParameters;
        }

        @Override
        public void run() {
            Object invoke;
            AbstractSingleton instance = null;
/*            if (clazz.equals(EagerInitialized.class)) {
                if (isWithParameters) {
                    instance = EagerInitialized.getInstance(threadName + " Eager Singleton", 1000);
                } else {
                    instance = EagerInitialized.getInstance();
                }
            } else if (clazz.equals(LazyInitialized.class)) {
                if (isWithParameters) {
                    instance = LazyInitialized.getInstance(threadName + " Lazy Singleton", 1000);
                } else {
                    instance = LazyInitialized.getInstance();
                }
            } else {
                if (isWithParameters) {
                    instance = AbstractSingleton.getInstance(threadName + " Abstract Singleton", 1000);
                } else {
                    instance = AbstractSingleton.getInstance();
                }
            }*/
            try {
                if (isWithParameters) {
                    invoke = clazz.getDeclaredMethod("getInstance", String.class, Integer.class).invoke(null, threadName + " " + clazz.getSimpleName(), 1000);
                } else {
                    invoke = clazz.getDeclaredMethod("getInstance").invoke(null);
                }

                switch (clazz.getSimpleName()) {
                    case "EagerInitialized":
                        instance = (EagerInitialized) invoke;
                        break;
                    case "LazyInitialized":
                        instance = (LazyInitialized) invoke;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + clazz.getSimpleName());
                }

            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }

            print(threadName, instance);
        }
    }

    private static class RunThreads {
        private static void invoke(Class<? extends AbstractSingleton> clazz, int count, boolean isParameters) {
            Thread[] threads = new Thread[count];
            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(new ThreadSingleton("Thread" + i, clazz, isParameters));
            }
            for (Thread thread : threads) {
                thread.start();
            }
        }
    }
}
