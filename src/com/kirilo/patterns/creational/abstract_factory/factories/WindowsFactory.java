package com.kirilo.patterns.creational.abstract_factory.factories;

import com.kirilo.patterns.creational.abstract_factory.objects.buttons.Button;
import com.kirilo.patterns.creational.abstract_factory.objects.buttons.WindowsButton;
import com.kirilo.patterns.creational.abstract_factory.objects.checkboxes.Checkbox;
import com.kirilo.patterns.creational.abstract_factory.objects.checkboxes.WindowsCheckbox;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
