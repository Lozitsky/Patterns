package com.kirilo.patterns.behavioral.observer.cricket.observers;

public interface ObserverManager {
    void registerObserver(Observer observer);

    void unregisterObserver(Observer observer);

    void notifyObservers();
}
