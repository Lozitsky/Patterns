package com.kirilo.patterns.behavioral.mediator.components;

import com.kirilo.patterns.behavioral.mediator.mediators.Elements;
import com.kirilo.patterns.behavioral.mediator.mediators.Mediator;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Title extends JTextField implements Component {
    private Mediator mediator;

    @Override
    protected void processComponentKeyEvent(KeyEvent e) {
        mediator.markNote();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return Elements.Title.name();
    }
}
