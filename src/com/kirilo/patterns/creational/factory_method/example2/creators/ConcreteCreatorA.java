package com.kirilo.patterns.creational.factory_method.example2.creators;

import com.kirilo.patterns.creational.factory_method.example2.products.ConcreteProductA;
import com.kirilo.patterns.creational.factory_method.example2.products.Product;

public class ConcreteCreatorA implements Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}
