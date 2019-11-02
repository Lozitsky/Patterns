package com.kirilo.patterns.factory_method.factory;

import com.kirilo.patterns.factory_method.buttons.Button;

public abstract class AbstractDialog implements Dialog {
    @Override
    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
    }

    //    Factory Method pattern
    @Override
    public abstract Button createButton();
}
