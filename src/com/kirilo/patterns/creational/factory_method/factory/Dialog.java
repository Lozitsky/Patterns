package com.kirilo.patterns.creational.factory_method.factory;

import com.kirilo.patterns.creational.factory_method.buttons.Button;

public interface Dialog {
    void renderWindow();

    Button createButton();
}
