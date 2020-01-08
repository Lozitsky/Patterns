package com.kirilo.patterns.behavioral.observer.cricket.observers;

import java.util.ArrayList;
import java.util.List;

public class CricketDataManager implements ObserverManager {
    private int runs;
    private int wickets;
    private float overs;
    private List<Observer> observers;

    public CricketDataManager() {
        observers = new ArrayList<>();
    }

    private int getLatestRuns() {
        return 90;
    }

    private int getLatestWickets() {
        return 2;
    }

    private float getLatestOvers() {
        return 10.2f;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(runs, wickets, overs));
    }

    public void changeData() {
        runs = getLatestRuns();
        wickets = getLatestWickets();
        overs = getLatestOvers();
        notifyObservers();
    }
}
