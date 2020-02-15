package com.kirilo.patterns.creational.factory_method.example1.factory;

import com.kirilo.patterns.creational.factory_method.example1.buttons.Button;
import com.kirilo.patterns.creational.factory_method.example1.buttons.*;

public class WindowsDialog extends AbstractDialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
