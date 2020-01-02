package com.kirilo.patterns.behavioral.mediator.components;

import com.kirilo.patterns.behavioral.mediator.mediators.Elements;
import com.kirilo.patterns.behavioral.mediator.notes.Note;
import com.kirilo.patterns.behavioral.mediator.mediators.Mediator;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Filter extends JTextField implements Component {
    private Mediator mediator;
    private ListModel<Note> listModel;

    public Filter() {
    }

    public void setListModel(ListModel listModel) {
        this.listModel = listModel;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent e) {
        String start = getText();
        searchElements(start);
    }

    private void searchElements(String start) {
        if (listModel == null) {
            return;
        }
        if (start.equals("")) {
            mediator.setElementsList(listModel);
            return;
        }

        DefaultListModel<Note> listModel = new DefaultListModel<>();

        for (int i = 0; i < this.listModel.getSize(); i++) {
            Note note = this.listModel.getElementAt(i);
            if (note.getName().contains(start)) {
                listModel.addElement(note);
            }
        }

        mediator.setElementsList(listModel);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return Elements.Filter.name();
    }
}
