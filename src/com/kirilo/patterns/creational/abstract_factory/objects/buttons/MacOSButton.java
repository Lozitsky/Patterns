package com.kirilo.patterns.creational.abstract_factory.objects.buttons;

public class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created MacOSButton.");
    }
}
