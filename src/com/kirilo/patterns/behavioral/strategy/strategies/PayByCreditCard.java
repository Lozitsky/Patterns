package com.kirilo.patterns.behavioral.strategy.strategies;

import com.kirilo.patterns.behavioral.strategy.CreditCard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PayByCreditCard implements PayStrategy {
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard creditCard;

    @Override
    public boolean pay(int paymentAmount) {
        if (paymentAmount == 0 || !isCardPresent()) {
            return false;
        }
        System.out.println("Paying " + paymentAmount + " using Credit Card.");
        return creditCard.setAmount(creditCard.getAmount() - paymentAmount);
//        return true;
    }

    @Override
    public void collectPaymentDetails() {
        System.out.println("Enter the card number: ");
        try {
            String number = READER.readLine();
            System.out.println("Enter the card expiration date 'mm/yy': ");
            String date = READER.readLine();
            System.out.println("Enter the cvv code: ");
            String cvv = READER.readLine();
            creditCard = new CreditCard(number, date, cvv);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isCardPresent() {
        return creditCard != null;
    }
}
