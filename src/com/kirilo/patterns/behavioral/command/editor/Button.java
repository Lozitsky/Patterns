package com.kirilo.patterns.behavioral.command.editor;

import com.kirilo.patterns.behavioral.command.commands.Command;
import com.kirilo.patterns.behavioral.command.commands.CommandHistory;

import javax.swing.*;

public class Button extends JButton{

    public Button(String name) {
        super(name);
    }

    public void activate(Command command) {
        super.addActionListener(e -> {
            if (command.execute()) {
                    CommandHistory.push(command);
            }});
    }
}
