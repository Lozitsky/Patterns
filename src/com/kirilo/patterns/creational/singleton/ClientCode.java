package com.kirilo.patterns.creational.singleton;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ClientCode {
    public static void main(String[] args) {

        startTestSingleton(EagerInitialized.class, false);

        startTestSingleton(EagerInitialized.class, true);

        startTestSingleton(LazyInitialized.class, false);

        startTestSingleton(LazyInitialized.class, true);

    }

    private static void startTestSingleton(Class<? extends AbstractSingleton> aClass, boolean isParameters) {
        try {
            Object invoke;
            Object invoke2;
            if (isParameters) {
                invoke = aClass.getDeclaredMethod("getInstance", String.class, Integer.class).invoke(null, aClass.getSimpleName(), 1000);
                invoke2 = aClass.getDeclaredMethod("getInstance", String.class, Integer.class).invoke(null, aClass.getSimpleName(), 1000);
            } else {
                invoke = aClass.getDeclaredMethod("getInstance").invoke(null);
                invoke2 = aClass.getDeclaredMethod("getInstance").invoke(null);
            }
            AbstractSingleton singleton;
            AbstractSingleton anotherSingleton;
            AbstractSingleton reflectionSingleton = null;
            switch (aClass.getSimpleName()) {
                case "EagerInitialized":
                    singleton = (EagerInitialized) invoke;
                    anotherSingleton = (EagerInitialized) invoke2;
                    break;
                case "LazyInitialized":
                    singleton = (LazyInitialized) invoke;
                    anotherSingleton = (LazyInitialized) invoke2;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + aClass.getSimpleName());
            }
            testSingleton(singleton, anotherSingleton, reflectionSingleton, isParameters);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    // https://stackoverflow.com/a/14443867/9586230
    private static void testSingleton(AbstractSingleton singleton, AbstractSingleton anotherSingleton, AbstractSingleton reflectionSingleton, boolean isMethodWithParameters) {
//        Constructor<?>[] constructors = singleton.getClass().getDeclaredConstructors();
        Method[] methods = singleton.getClass().getDeclaredMethods();

//        for (Constructor<?> constructor : constructors) {
        for (Method method : methods) {
            method.setAccessible(true);
//            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Class<?>[] parameterTypes = method.getParameterTypes();

            String parameters = Arrays.toString(parameterTypes);
            System.out.println("==========================Test for " + singleton.getClass().getSimpleName() + " Singleton======================================");
            System.out.println("Method parameters: " + parameters);
            try {
                if (singleton.getClass().equals(EagerInitialized.class)) {
                    reflectionSingleton = (EagerInitialized) (parameters.equals("[]") ? (!isMethodWithParameters) ? method.invoke(null) : null : isMethodWithParameters ? method.invoke(null, "Reflection Eager Singleton", 1000) : null);
                } else if (singleton.getClass().equals(LazyInitialized.class)) {
                    reflectionSingleton = (LazyInitialized) (parameters.equals("[]") ? (!isMethodWithParameters) ? method.invoke(null) : null : isMethodWithParameters ? method.invoke(null, "Reflection Lazy Singleton", 1000) : null);
                } else {
//                    reflectionSingleton = (AbstractSingleton) (parameters.equals("[]") ? constructor.newInstance() : constructor.newInstance("default Singleton", 1000));
                    reflectionSingleton = (AbstractSingleton) (parameters.equals("[]") ? (!isMethodWithParameters) ? method.invoke(null) : null : isMethodWithParameters ? method.invoke(null, "Reflection Abstract Singleton", 1000) : null);
                }
                if (reflectionSingleton != null) {
                    break;
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        ThreadSafeTest.print("singleton", singleton);
        ThreadSafeTest.print("anotherSingleton", anotherSingleton);
        ThreadSafeTest.print("\nGet Singleton using reflection."
                + "\nreflectionSingleton", reflectionSingleton);
    }

}
