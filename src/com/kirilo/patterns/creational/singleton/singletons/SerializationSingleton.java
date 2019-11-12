package com.kirilo.patterns.creational.singleton.singletons;

import java.io.Serializable;
import java.util.Random;

public class SerializationSingleton extends AbstractSingleton implements Serializable {
    private static final long serialVersionUID = -1943721534326787659L;
    private static String value;
    private static Integer sleepValue;

    private SerializationSingleton() {
        super();
    }

    private SerializationSingleton(String value, Integer sleepValue) {
        super(value, sleepValue);
    }

    public static SerializationSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public static SerializationSingleton getInstance(String value, Integer sleepValue) {
        SerializationSingleton.value = value;
        SerializationSingleton.sleepValue = sleepValue;
        return SingletonHelperWithParam.INITIALIZE;
    }

    private static class SingletonHelper {
        private static final SerializationSingleton INSTANCE = new SerializationSingleton("default Serialization Singleton" + new Random().nextInt(100), 1000);
    }

    private static class SingletonHelperWithParam {
        private static final SerializationSingleton INITIALIZE = new SerializationSingleton(value, sleepValue);
    }

//    doesn't work properly without this method. Otherwise we'll get value == null
    protected Object readResolve() {
        return getInstance();
    }
}
