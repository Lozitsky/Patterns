package com.kirilo.patterns.creational.factory_method.factory;

import com.kirilo.patterns.creational.factory_method.buttons.Button;

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
