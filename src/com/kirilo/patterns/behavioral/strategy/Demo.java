package com.kirilo.patterns.behavioral.strategy;

import com.kirilo.patterns.behavioral.strategy.strategies.PayByCreditCard;
import com.kirilo.patterns.behavioral.strategy.strategies.PayByPayPal;
import com.kirilo.patterns.behavioral.strategy.strategies.PayStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Demo {
    private static Order order;
    private static Map<Integer, Integer> priceOnProducts;
//    private static String continueChoice = "";


    static {
        order = new Order();
        priceOnProducts = new HashMap<>();
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String continueChoice = "";
        PayStrategy strategy = null;

        try {
            while (!order.isClosed()) {
                int cost;

                do {
                    System.out.println(continueChoice);
                    System.out.print("Please, select a product:" + "\n" +
                            "1 - Mother board" + "\n" +
                            "2 - CPU" + "\n" +
                            "3 - HDD" + "\n" +
                            "4 - Memory" + "\n");
                    try {
                        int choice = Integer.parseInt(reader.readLine());
                        cost = priceOnProducts.get(choice);
                        System.out.println("Count: ");
                        int count = Integer.parseInt(reader.readLine());
                        order.setTotalCost(cost * count);
                    } catch (NumberFormatException e) {
                        continueChoice = "EXIT";
                        break;
                    }
                    System.out.println("Do you wish to continue selecting products? Y/N: ");
                    continueChoice = reader.readLine();

                } while (continueChoice.equalsIgnoreCase("Y"));

                if (checkExit(continueChoice)) break;
                if (strategy != null) {
                    continue;
                }
                boolean nextInput = false;
                do {
                    System.out.println("Please, select a payment method:" + "\n" +
                            "1 - PalPay" + "\n" +
                            "2 - Credit Card");
                    switch (reader.readLine()) {
                        case "1":
                            strategy = new PayByPayPal();
                            break;
                        case "2":
                            strategy = new PayByCreditCard();
                            break;
                        case "EXIT":
                        case "exit":
                            continueChoice = "EXIT";
                            break;
                        default:
                            System.out.println("Incorrect input. Please try again.");
                            nextInput = true;
                            break;
                    }
                } while (nextInput);
                if (checkExit(continueChoice)) break;
                order.processOrder(strategy);

                System.out.println("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
                if (reader.readLine().equalsIgnoreCase("P")) {
                    if (strategy.pay(order.getTotalCost())) {
                        order.setClosed();
//                        continueChoice = "exit";
                        System.out.println("Payment has been successful.");
                    } else {
                        System.out.println("FAIL! Please, check your data.");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkExit(String continueChoice) {
        return continueChoice.equalsIgnoreCase("EXIT");
    }
}
