package com.kirilo.patterns.behavioral.command.editor;

import com.kirilo.patterns.behavioral.command.commands.CopyCommand;
import com.kirilo.patterns.behavioral.command.commands.CutCommand;
import com.kirilo.patterns.behavioral.command.commands.PasteCommand;
import com.kirilo.patterns.behavioral.command.commands.UndoCommand;

import javax.swing.*;
import java.awt.*;

public class Editor {
    private JTextArea textArea;

    public JTextArea getTextArea() {
        return textArea;
    }

    public void init() {
        JFrame frame = new JFrame("Text editor (type and use buttons)");
        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        panel.add(textArea);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Button ctrlC = new Button("Ctrl+C");
        Button ctrlX = new Button("Ctrl+X");
        Button ctrlV = new Button("Ctrl+V");
        Button ctrlZ = new Button("Ctrl+Z");
//        Editor editor = this;
        ctrlC.activate(new CopyCommand(this));
        ctrlX.activate(new CutCommand(this));
        ctrlV.activate(new PasteCommand(this));
        ctrlZ.activate(new UndoCommand(this));
        buttons.add(ctrlC);
        buttons.add(ctrlX);
        buttons.add(ctrlV);
        buttons.add(ctrlZ);
        panel.add(buttons);
        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
