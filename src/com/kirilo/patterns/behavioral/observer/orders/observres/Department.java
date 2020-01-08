package com.kirilo.patterns.behavioral.observer.orders.observres;

import com.kirilo.patterns.behavioral.observer.orders.departments.Person;

import java.util.ArrayList;
import java.util.List;

public class Department implements Observer{
    private String name;
    List<Person> people;
    List<String> orders;

    public Department(String name) {
        this.name = name;
        people = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public Department(String name, List<Person> people) {
        this.name = name;
        this.people = people;
    }

    @Override
    public void update(String oder) {
        orders.add(oder);
    }

    public void printOrders() {
        System.out.println("Department: " + name);
        for (String order : orders) {
            System.out.println(order);
        }
    }
}
