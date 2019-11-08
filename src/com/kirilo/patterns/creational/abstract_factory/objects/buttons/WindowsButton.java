package com.kirilo.patterns.creational.abstract_factory.objects.buttons;

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created WindowsButton.");
    }
}
