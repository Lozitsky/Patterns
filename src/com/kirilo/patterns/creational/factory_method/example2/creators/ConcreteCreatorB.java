package com.kirilo.patterns.creational.factory_method.example2.creators;

import com.kirilo.patterns.creational.factory_method.example2.products.ConcreteProductB;
import com.kirilo.patterns.creational.factory_method.example2.products.Product;

public class ConcreteCreatorB implements Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}
