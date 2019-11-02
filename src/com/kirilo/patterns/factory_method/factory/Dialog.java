package com.kirilo.patterns.factory_method.factory;

import com.kirilo.patterns.factory_method.buttons.Button;

public interface Dialog {
    void renderWindow();

    Button createButton();
}
