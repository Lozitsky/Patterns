package com.kirilo.patterns.behavioral.observer.orders.departments;

public class Person {
    private String name;
    private int rang;
    private String position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Person(String name, int rang, String position) {
        this.name = name;
        this.rang = rang;
        this.position = position;
    }
}
