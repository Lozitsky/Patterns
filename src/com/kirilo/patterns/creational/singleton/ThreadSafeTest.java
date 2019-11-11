package com.kirilo.patterns.creational.singleton;

import com.kirilo.patterns.creational.singleton.singletons.*;

public class ThreadSafeTest {
    public static void main(String[] args) {
        int count = 5;
        RunThreads.invoke(EagerInitializedSingleton.class, count, true);
        RunThreads.invoke(EagerInitializedSingleton.class, count, false);

        RunThreads.invoke(StaticBlockInitializedSingleton.class, count, true);
        RunThreads.invoke(StaticBlockInitializedSingleton.class, count, false);

        RunThreads.invoke(LazyInitializedSingleton.class, count, true);
        RunThreads.invoke(LazyInitializedSingleton.class, count, false);

        RunThreads.invoke(ThreadSafeSingleton.class, count, true);
        RunThreads.invoke(ThreadSafeSingleton.class, count, false);

        RunThreads.invoke(DoubleCheckedLockingSingleton.class, count, true);
        RunThreads.invoke(DoubleCheckedLockingSingleton.class, count, false);

        RunThreads.invoke(BillPughSingleton.class, count, true);
        RunThreads.invoke(BillPughSingleton.class, count, false);

        RunThreads.invoke(EnumSingleton.class, count, true);
        RunThreads.invoke(EnumSingleton.class, count, false);
    }

    static void print(String s, Singleton instance) {
        String values = instance != null ? (getValues(instance)) : "0";
        System.out.println(s + ": " + values);
    }

    private static String getValues(Singleton instance) {
        return instance.getValue() + ", " + instance.hashCode();
    }


    static class ThreadSingleton implements Runnable {
        private String threadName;
        private Class<? extends Singleton> clazz;
        private boolean isWithParameters;

        ThreadSingleton(String threadName, Class<? extends Singleton> clazz, boolean isWithParameters) {
            this.threadName = threadName;
            this.clazz = clazz;
            this.isWithParameters = isWithParameters;
        }

        @Override
        public void run() {
            Singleton instance = new ReflectionFactory().invoke(clazz, threadName, isWithParameters);

            print(threadName, instance);
        }

    }

    private static class RunThreads {
        private static void invoke(Class<? extends Singleton> clazz, int count, boolean isParameters) {
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
