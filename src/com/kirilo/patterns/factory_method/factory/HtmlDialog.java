package com.kirilo.patterns.factory_method.factory;

import com.kirilo.patterns.factory_method.buttons.Button;
import com.kirilo.patterns.factory_method.buttons.HtmlButton;

public class HtmlDialog extends AbstractDialog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
