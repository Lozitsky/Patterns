package com.kirilo.patterns.creational.factory_method.example1.factory;

import com.kirilo.patterns.creational.factory_method.example1.buttons.Button;

public abstract class AbstractDialog implements Dialog {
    @Override
    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
    }

    //    Factory Method
    @Override
    public abstract Button createButton();
}
