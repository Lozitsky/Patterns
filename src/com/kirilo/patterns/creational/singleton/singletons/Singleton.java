package com.kirilo.patterns.creational.singleton.singletons;
// https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
public interface Singleton {
    static Singleton getInstance() {
        return null;
    }

    // https://javarevisited.blogspot.com/2013/03/can-we-overload-and-override-static-method-java.html
    static Singleton getInstance(String value, Integer sleepValue) {
        return null;
    }

    String getValue();
}
