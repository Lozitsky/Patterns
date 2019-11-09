package com.kirilo.patterns.creational.singleton.singletons;

import java.util.Random;

public class BillPughSingleton extends AbstractSingleton {

    private static String value;
    private static Integer sleepValue;

    private BillPughSingleton() {
        super();
    }

    private BillPughSingleton(String value, Integer sleepValue) {
        super(value, sleepValue);
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public static BillPughSingleton getInstance(String value, Integer sleepValue) {
        BillPughSingleton.value = value;
        BillPughSingleton.sleepValue = sleepValue;
        return SingletonHelperWithParam.INITIALIZE;
    }

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton("default Bill Pugh Singleton" + new Random().nextInt(100), 1000);
    }

    private static class SingletonHelperWithParam {
/*        private static String value;
        private static Integer sleepValue;*/

/*        private SingletonHelperWithParam(String value, Integer sleepValue) {
            SingletonHelperWithParam.value = value;
            SingletonHelperWithParam.sleepValue = sleepValue;
        }*/

//        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
        private static final BillPughSingleton INITIALIZE = new BillPughSingleton(value, sleepValue);
    }
}
