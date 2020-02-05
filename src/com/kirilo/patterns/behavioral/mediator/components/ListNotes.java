package com.kirilo.patterns.behavioral.mediator.components;

import com.kirilo.patterns.behavioral.mediator.mediators.Elements;
import com.kirilo.patterns.behavioral.mediator.mediators.Mediator;
import com.kirilo.patterns.behavioral.mediator.notes.Note;

import javax.swing.*;

public class ListNotes extends JList<Note> implements Component {
    private final DefaultListModel LIST_MODEL;
    private Mediator mediator;

    public ListNotes(DefaultListModel defaultListModel) {
        super(defaultListModel);
        this.LIST_MODEL = defaultListModel;
        setLayoutOrientation(JList.VERTICAL);
        Thread thread = new Thread(new Hide(this));
        thread.start();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void addElement(Note note) {
        LIST_MODEL.addElement(note);
        int index = LIST_MODEL.size() - 1;
        setSelectedIndex(index);
        ensureIndexIsVisible(index);
        mediator.sendToFilter(LIST_MODEL);
    }

    public void deleteElement() {
        try {
            for (Note note : getSelectedValuesList()) {
                LIST_MODEL.removeElement(note);
            }
            mediator.sendToFilter(LIST_MODEL);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public Note getCurrentElement() {
        return getSelectedValue();
    }

    @Override
    public String getName() {
        return Elements.List.name();
    }

    private class Hide implements Runnable {
        private ListNotes listNotes;

        public Hide(ListNotes listNotes) {
            this.listNotes = listNotes;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (listNotes.isSelectionEmpty()) {
                    mediator.hideElements(true);
                } else {
                    mediator.hideElements(false);
                }
            }
        }
    }
}
