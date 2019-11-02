package com.kirilo.patterns.factory_method.factory;

import com.kirilo.patterns.factory_method.buttons.Button;
import com.kirilo.patterns.factory_method.buttons.WindowsButton;

public class WindowsDialog extends AbstractDialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
