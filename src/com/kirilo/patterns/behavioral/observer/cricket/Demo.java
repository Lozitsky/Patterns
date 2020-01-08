package com.kirilo.patterns.behavioral.observer.cricket;

import com.kirilo.patterns.behavioral.observer.cricket.observers.AverageScoreDisplay;
import com.kirilo.patterns.behavioral.observer.cricket.observers.CricketDataManager;
import com.kirilo.patterns.behavioral.observer.cricket.observers.CurrentScoreDisplay;

public class Demo {
    public static void main(String[] args) {
        AverageScoreDisplay averageScoreDisplay =
                new AverageScoreDisplay();
        CurrentScoreDisplay currentScoreDisplay =
                new CurrentScoreDisplay();

        CricketDataManager manager = new CricketDataManager();
        manager.registerObserver(averageScoreDisplay);
        manager.registerObserver(currentScoreDisplay);

        manager.changeData();
        System.out.println("------------------------------");
        manager.unregisterObserver(averageScoreDisplay);
        manager.changeData();
    }
}
