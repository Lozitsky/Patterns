package com.kirilo.patterns.behavioral.observer.orders;

import com.kirilo.patterns.behavioral.observer.orders.observres.Department;
import com.kirilo.patterns.behavioral.observer.orders.observres.OrderManager;

import static com.kirilo.patterns.behavioral.observer.orders.departments.OrderType.*;

public class Demo {
    public static void main(String[] args) {
        Department department11 = new Department("department11");
        Department department12 = new Department("department12");

        OrderManager orderManager = new OrderManager();
        orderManager.registerObserver(department11, volume1, volume3);
        orderManager.registerObserver(department12, volume2);

        orderManager.notifyObservers(volume1, "Attention! Very important order!");
        orderManager.notifyObservers(volume3, "Not important order!");
        orderManager.notifyObservers(volume2, "Middle important order!");

        department11.printOrders();
        department12.printOrders();
    }
}
