package com.kirilo.patterns.creational.singleton;

import com.kirilo.patterns.creational.singleton.singletons.*;

public class ClientCode {
    public static void main(String[] args) {

        startTestSingleton(EagerInitializedSingleton.class, false);
        startTestSingleton(EagerInitializedSingleton.class, true);

        startTestSingleton(StaticBlockInitializedSingleton.class, false);
        startTestSingleton(StaticBlockInitializedSingleton.class, true);

        startTestSingleton(LazyInitializedSingleton.class, false);
        startTestSingleton(LazyInitializedSingleton.class, true);

        startTestSingleton(ThreadSafeSingleton.class, false);
        startTestSingleton(ThreadSafeSingleton.class, true);

        startTestSingleton(BillPughSingleton.class, false);
        startTestSingleton(BillPughSingleton.class, true);

    }

    private static void startTestSingleton(Class<? extends AbstractSingleton> aClass, boolean isParameters) {

        AbstractSingleton singleton;
        AbstractSingleton anotherSingleton;
        switch (aClass.getSimpleName()) {
            case "EagerInitializedSingleton":
                if (!isParameters) {
                    singleton = EagerInitializedSingleton.getInstance();
                    anotherSingleton = EagerInitializedSingleton.getInstance();
                } else {
                    singleton = EagerInitializedSingleton.getInstance(aClass.getSimpleName(), 1000);
                    anotherSingleton = EagerInitializedSingleton.getInstance(aClass.getSimpleName(), 1000);
                }
                break;
            case "LazyInitializedSingleton":
                if (!isParameters) {
                    singleton = LazyInitializedSingleton.getInstance();
                    anotherSingleton = LazyInitializedSingleton.getInstance();
                } else {
                    singleton = LazyInitializedSingleton.getInstance(aClass.getSimpleName(), 1000);
                    anotherSingleton = LazyInitializedSingleton.getInstance(aClass.getSimpleName(), 1000);
                }
                break;
            case "StaticBlockInitializedSingleton":
                if (!isParameters) {
                    singleton = StaticBlockInitializedSingleton.getInstance();
                    anotherSingleton = StaticBlockInitializedSingleton.getInstance();
                } else {
                    singleton = StaticBlockInitializedSingleton.getInstance(aClass.getSimpleName(), 1000);
                    anotherSingleton = StaticBlockInitializedSingleton.getInstance(aClass.getSimpleName(), 1000);
                }
                break;
            case "ThreadSafeSingleton":
                if (!isParameters) {
                    singleton = ThreadSafeSingleton.getInstance();
                    anotherSingleton = ThreadSafeSingleton.getInstance();
                } else {
                    singleton = ThreadSafeSingleton.getInstance(aClass.getSimpleName(), 1000);
                    anotherSingleton = ThreadSafeSingleton.getInstance(aClass.getSimpleName(), 1000);
                }
                break;
            case "BillPughSingleton":
                if (!isParameters) {
                    singleton = BillPughSingleton.getInstance();
                    anotherSingleton = BillPughSingleton.getInstance();
                } else {
                    singleton = BillPughSingleton.getInstance(aClass.getSimpleName(), 1000);
                    anotherSingleton = BillPughSingleton.getInstance(aClass.getSimpleName(), 1000);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + aClass.getSimpleName());
        }
        testSingleton(singleton, anotherSingleton, isParameters);
    }

    // https://stackoverflow.com/a/14443867/9586230
    private static void testSingleton(AbstractSingleton singleton, AbstractSingleton anotherSingleton, boolean isMethodWithParameters) {

        AbstractSingleton reflectionSingleton = new ReflectionFactory().invoke(singleton.getClass(), "Reflection", isMethodWithParameters);

        System.out.println("\n==========================Test for " + singleton.getClass().getSimpleName() + (isMethodWithParameters ? " with parameters" : "") + "======================================\n");
        ThreadSafeTest.print("singleton", singleton);
        ThreadSafeTest.print("anotherSingleton", anotherSingleton);
        ThreadSafeTest.print("\nGet Singleton using reflection."
                + "\nreflectionSingleton", reflectionSingleton);
    }

}
