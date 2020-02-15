package com.kirilo.patterns.creational.factory_method.example2;

import com.kirilo.patterns.creational.factory_method.example2.creators.*;

public class Demo {
    private static Creator[] getCreators(Creator... creators) {
        return creators;
    }

    public static void main(String[] args) {
        for (Creator creator : getCreators(new ConcreteCreatorA(), new ConcreteCreatorB())) {
            System.out.printf("Created\t{%s}\n", creator.factoryMethod().getClass());
        }
    }
}
