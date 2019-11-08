package com.kirilo.patterns.creational.abstract_factory.factories;

import com.kirilo.patterns.creational.abstract_factory.objects.buttons.Button;
import com.kirilo.patterns.creational.abstract_factory.objects.checkboxes.Checkbox;

public interface GUIFactory {
    Button createButton();

    Checkbox createCheckbox();
}
