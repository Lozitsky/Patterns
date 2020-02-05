package com.kirilo.patterns.behavioral.mediator.mediators;

import com.kirilo.patterns.behavioral.mediator.components.Component;
import com.kirilo.patterns.behavioral.mediator.components.*;
import com.kirilo.patterns.behavioral.mediator.notes.Note;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Editor implements Mediator {
    private Title title;
    private TextBox textBox;
    private JScrollPane scrollTextBox;
    private AddButton add;
    private DeleteButton del;
    private SaveButton save;
    private ListNotes listNotes;
    private Filter filter;

    private JLabel titleLabel = new JLabel("Title:");
    private JLabel textLabel = new JLabel("Text:");
    private JLabel label = new JLabel("Add or select existing note to proceed...");

    @Override
    public void addNewNote(Note note) {
        title.setText("");
        textBox.setText("");
        listNotes.addElement(note);
    }

    @Override
    public void deleteNote() {
        listNotes.deleteElement();
    }

    @Override
    public void getInfoFromList(Note note) {
        title.setText(note.getName().replace('*', ' '));
        textBox.setText(note.getText());
    }

    @Override
    public void saveChanges() {
        try {
            Note note = listNotes.getSelectedValue();
            note.setName(title.getText());
            note.setText(textBox.getText());
            listNotes.repaint();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void markNote() {
        try {
            Note note = listNotes.getCurrentElement();
            String name = note.getName();
            if (!name.endsWith("*")) {
                note.setName(String.format("%s*", name));
            }
            listNotes.repaint();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clear() {
        title.setText("");
        textBox.setText("");
    }

    @Override
    public void sendToFilter(ListModel listModel) {
        filter.setListModel(listModel);
    }

    @Override
    public void setElementsList(ListModel listModel) {
        listNotes.setModel(listModel);
        listNotes.repaint();
    }

    @Override
    public void registerComponent(Component component) {
        component.setMediator(this);
        switch (Elements.valueOf(component.getName())) {
            case AddButton:
                add = (AddButton) component;
                break;
            case DelButton:
                del = (DeleteButton) component;
                break;
            case Filter:
                filter = (Filter) component;
                break;
            case List:
                listNotes = (ListNotes) component;
                listNotes.addListSelectionListener(e -> {
                    Note note = listNotes.getSelectedValue();
                    if (note != null) {
                        getInfoFromList(note);
                    } else {
                        clear();
                    }
                });
                break;
            case SaveButton:
                save = (SaveButton) component;
                break;
            case TextBox:
                textBox = (TextBox) component;
                break;
            case Title:
                title = (Title) component;
                break;
        }
    }

    @Override
    public void hideElements(boolean flag) {
        titleLabel.setVisible(!flag);
        textLabel.setVisible(!flag);
        title.setVisible(!flag);
//        textBox.setVisible(!flag);
        scrollTextBox.setVisible(!flag);
        save.setVisible(!flag);
        label.setVisible(flag);
    }

    @Override
    public void createGUI() {
        JFrame notes = new JFrame("Notes");
        notes.setSize(960, 600);
        notes.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel left = new JPanel();
        left.setBorder(new LineBorder(Color.BLACK));
        JLabel labelFilter = new JLabel("Filter:");
        JLabel labelNotes = new JLabel("Notes:");

        listNotes.setFixedCellWidth(260);
        listNotes.setBorder(new LineBorder(Color.DARK_GRAY));
        JScrollPane scrollPane = new JScrollPane(listNotes);

        GroupLayout layoutL = new GroupLayout(left);
        left.setLayout(layoutL);
        layoutL.setAutoCreateGaps(true);
        layoutL.setAutoCreateContainerGaps(true);

        layoutL.setHorizontalGroup(layoutL.createParallelGroup()
                .addGroup(layoutL.createSequentialGroup()
                        .addComponent(labelFilter)
                        .addComponent(filter)
                )
                .addComponent(labelNotes)
                .addComponent(scrollPane)
                .addGroup(GroupLayout.Alignment.CENTER, layoutL.createSequentialGroup()
                        .addComponent(add)
                        .addComponent(del)
                )
        );

        layoutL.linkSize(SwingConstants.VERTICAL, labelFilter, filter);
        layoutL.linkSize(SwingConstants.HORIZONTAL, add, del);

        layoutL.setVerticalGroup(layoutL.createSequentialGroup()
                .addGroup(layoutL.createParallelGroup()
                        .addComponent(labelFilter)
                        .addComponent(filter)
                )
                .addComponent(labelNotes)
                .addComponent(scrollPane)
                .addGroup(layoutL.createParallelGroup()
                        .addComponent(add)
                        .addComponent(del)
                )
        );

        JPanel right = new JPanel();
        GroupLayout layoutR = new GroupLayout(right);
        right.setLayout(layoutR);
        right.setBorder(new LineBorder(Color.BLACK));
        layoutR.setAutoCreateGaps(true);
        layoutR.setAutoCreateContainerGaps(true);
        textBox.setBorder(new LineBorder(Color.DARK_GRAY));
        scrollTextBox = new JScrollPane(textBox);
        scrollTextBox.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollTextBox.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        label.setFont(new Font("Verdana", Font.PLAIN, 22));

        layoutR.setHorizontalGroup(layoutR.createSequentialGroup()
                .addGroup(layoutR.createParallelGroup()
                        .addGroup(layoutR.createSequentialGroup()
                                .addComponent(titleLabel)
                                .addComponent(title)
                        )
                        .addComponent(textLabel)
                        .addComponent(scrollTextBox)
                        .addComponent(label, 100, 445, 640)
                        .addComponent(save, GroupLayout.Alignment.CENTER)
                )
        );

        layoutR.linkSize(SwingConstants.VERTICAL, titleLabel, title);

        layoutR.setVerticalGroup(
                layoutR.createSequentialGroup()
                        .addGroup(layoutR.createParallelGroup()
                                .addComponent(titleLabel)
                                .addComponent(title)
                        )
                        .addComponent(textLabel)
                        .addComponent(scrollTextBox, 100, 470, 500)
                        .addComponent(label, 100, 600, 600)
                        .addComponent(save)
        );

        GroupLayout layout = new GroupLayout(notes.getContentPane());
        notes.getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(left)
                .addComponent(right)
        );

        layout.setVerticalGroup(layout.createParallelGroup()
                .addComponent(left)
                .addComponent(right)
        );
        notes.setResizable(false);
        notes.setLocationRelativeTo(null);
        notes.setVisible(true);
    }
}
