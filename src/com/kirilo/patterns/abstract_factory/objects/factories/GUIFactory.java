package com.kirilo.patterns.abstract_factory.objects.factories;

import com.kirilo.patterns.abstract_factory.objects.buttons.Button;
import com.kirilo.patterns.abstract_factory.objects.checkboxes.Checkbox;

public interface GUIFactory {
    Button createButton();

    Checkbox createCheckbox();
}
