package com.kirilo.patterns.behavioral.mediator.components;

import com.kirilo.patterns.behavioral.mediator.mediators.Elements;
import com.kirilo.patterns.behavioral.mediator.notes.Note;
import com.kirilo.patterns.behavioral.mediator.mediators.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddButton extends JButton implements Component {
    private Mediator mediator;

    public AddButton() {
        super("Add");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent event) {
        mediator.addNewNote(new Note());
    }

    @Override
    public String getName() {
        return Elements.AddButton.name();
    }
}
