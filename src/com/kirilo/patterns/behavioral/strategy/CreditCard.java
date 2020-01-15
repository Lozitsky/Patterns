package com.kirilo.patterns.behavioral.strategy;

public class CreditCard {
    private String number;
    private String date;
    private String cvv;
    private int amount;

    public CreditCard(String number, String date, String cvv) {
        amount = 100_000;
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }

    public int getAmount() {
        return amount;
    }

    public boolean setAmount(int amount) {
        if (amount < 0) {
            return false;
        }

        this.amount = amount;
        return true;
    }
}
