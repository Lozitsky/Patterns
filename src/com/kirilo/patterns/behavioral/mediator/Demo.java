package com.kirilo.patterns.behavioral.mediator;

import com.kirilo.patterns.behavioral.mediator.components.*;
import com.kirilo.patterns.behavioral.mediator.mediators.Editor;
import com.kirilo.patterns.behavioral.mediator.mediators.Mediator;

import javax.swing.*;

public class Demo {
    public static void main(String[] args) {
        Mediator mediator = new Editor();
        mediator.registerComponent(new Title());
        mediator.registerComponent(new TextBox(15, 40));
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new SaveButton());
        mediator.registerComponent(new ListNotes(new DefaultListModel()));
        mediator.registerComponent(new Filter());

        mediator.createGUI();
    }
}
