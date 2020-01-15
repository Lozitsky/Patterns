package com.kirilo.patterns.behavioral.strategy;

import com.kirilo.patterns.behavioral.strategy.strategies.PayStrategy;

public class Order {
    private int totalCost;
    private boolean isClosed;

    public void processOrder(PayStrategy strategy) {
        strategy.collectPaymentDetails();
    }
    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost += totalCost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        isClosed = true;
    }
}
