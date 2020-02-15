package com.kirilo.patterns.creational.factory_method.example1.buttons;

public class HtmlButton implements Button {
    @Override
    public void render() {
        System.out.println("<button>Test Button</button>");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("Click! Button says - 'Hello World!'");
    }
}
