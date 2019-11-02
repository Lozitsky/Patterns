package com.kirilo.patterns.abstract_factory.objects;

import com.kirilo.patterns.abstract_factory.objects.buttons.Button;
import com.kirilo.patterns.abstract_factory.objects.checkboxes.Checkbox;
import com.kirilo.patterns.abstract_factory.objects.factories.GUIFactory;

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
