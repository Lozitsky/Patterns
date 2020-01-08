package com.kirilo.patterns.behavioral.observer.orders.observres;

import com.kirilo.patterns.behavioral.observer.orders.departments.OrderType;

public interface Observable {
    void registerObserver(Observer observer, OrderType orderType);

    void registerObserver(Observer observer, OrderType... orderType);

    void unregisterObserver(Observer observer, OrderType orderType);

    void unregisterObserver(Observer observer, OrderType... orderType);

    void notifyObservers(OrderType orderType, String message);
}
