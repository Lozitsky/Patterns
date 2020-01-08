package com.kirilo.patterns.behavioral.observer.orders.observres;

import com.kirilo.patterns.behavioral.observer.orders.departments.OrderType;

import java.util.*;

public class OrderManager implements Observable {
    private Map<OrderType, ArrayList<Observer>> departments;

    public OrderManager() {
        departments = new HashMap<>();

        for (OrderType type : OrderType.values()) {
            departments.put(type, new ArrayList<>());
        }
    }

    @Override
    public void registerObserver(Observer observer, OrderType orderType) {
        List<Observer> observers = departments.get(orderType);
        observers.add(observer);
    }

    @Override
    public void registerObserver(Observer observer, OrderType... orderTypes) {
        for (OrderType orderType : orderTypes) {
            List<Observer> observers = departments.get(orderType);
            observers.add(observer);
        }
    }

    @Override
    public void unregisterObserver(Observer observer, OrderType orderType) {
        List<Observer> observers = departments.get(orderType);
        observers.remove(observer);
    }

    @Override
    public void unregisterObserver(Observer observer, OrderType... orderTypes) {
        for (OrderType orderType : orderTypes) {
            List<Observer> observers = departments.get(orderType);
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers(OrderType orderType, String order) {
        ArrayList<Observer> observers = departments.get(orderType);
        observers.forEach(observer -> observer.update(order));
    }
}
