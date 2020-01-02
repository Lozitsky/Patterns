package com.kirilo.patterns.behavioral.mediator.mediators;

import com.kirilo.patterns.behavioral.mediator.notes.Note;
import com.kirilo.patterns.behavioral.mediator.components.Component;

import javax.swing.*;

public interface Mediator {
    void addNewNote(Note note);

    void deleteNote();

    void getInfoFromList(Note note);

    void saveChanges();

    void markNote();

    void clear();

    void sendToFilter(ListModel listModel);

    void setElementsList(ListModel listModel);

    void registerComponent(Component component);

    void hideElements(boolean flag);

    void createGUI();
}
