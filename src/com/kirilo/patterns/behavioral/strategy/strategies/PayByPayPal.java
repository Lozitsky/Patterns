package com.kirilo.patterns.behavioral.strategy.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PayByPayPal implements PayStrategy {
    private static final Map<String, String> DATA_BASE;

    static {
        DATA_BASE = new HashMap<>();
        DATA_BASE.put("amanda@ya.com", "amanda1985");
        DATA_BASE.put("john@amazon.eu", "qwerty");
    }

    private final BufferedReader READER;
    private String email;
    private String password;
    private boolean signedIn;

    public PayByPayPal() {
        READER = new BufferedReader(new InputStreamReader(System.in));
    }

    private static boolean checkExit(String continueChoice) {
        return continueChoice.equalsIgnoreCase("EXIT");
    }

    public void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }

    @Override
    public boolean pay(int paymentAmount) {
        if (signedIn) {
            System.out.println("Paying " + paymentAmount + " using PayPal.");
        }
        return signedIn;
    }

    @Override
    public void collectPaymentDetails() {
        while (!signedIn) {
            System.out.println("Enter the user's email: ");
            try {
                email = READER.readLine();
                if (checkExit(email)) break;
                System.out.println("Enter the user's password: ");
                password = READER.readLine();
                if (checkExit(password)) break;
                String message = verify() ? "Data verification has been successful" : "Wrong email or password";
                System.out.println(message);

                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean verify() {
        setSignedIn(password.equals(DATA_BASE.get(email)));
        return false;
    }
}
