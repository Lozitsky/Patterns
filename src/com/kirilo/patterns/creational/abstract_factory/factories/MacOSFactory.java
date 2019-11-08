package com.kirilo.patterns.creational.abstract_factory.factories;

import com.kirilo.patterns.creational.abstract_factory.objects.buttons.Button;
import com.kirilo.patterns.creational.abstract_factory.objects.buttons.MacOSButton;
import com.kirilo.patterns.creational.abstract_factory.objects.checkboxes.Checkbox;
import com.kirilo.patterns.creational.abstract_factory.objects.checkboxes.MacOSCheckbox;

public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
