package com.kirilo.patterns.creational.factory_method.example1.factory;

import com.kirilo.patterns.creational.factory_method.example1.buttons.Button;

public interface Dialog {
    void renderWindow();

    Button createButton();
}
