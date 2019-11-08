package com.kirilo.patterns.creational.abstract_factory;

import com.kirilo.patterns.creational.abstract_factory.objects.buttons.Button;
import com.kirilo.patterns.creational.abstract_factory.objects.checkboxes.Checkbox;
import com.kirilo.patterns.creational.abstract_factory.factories.GUIFactory;

public class ClientCode {
    private Button button;
    private Checkbox checkbox;

    public ClientCode(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
