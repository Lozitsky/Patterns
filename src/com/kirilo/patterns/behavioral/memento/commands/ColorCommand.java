package com.kirilo.patterns.behavioral.memento.commands;

import com.kirilo.patterns.behavioral.memento.editor.Editor;

import java.awt.*;

public class ColorCommand implements Command {
    private Editor editor;
    private Color color;

    public ColorCommand(Editor editor, Color color) {
        this.editor = editor;
        this.color = color;
    }

    @Override
    public String getName() {
        return "Colorize: " + color.toString();
    }

    @Override
    public boolean execute() {
        try {
            editor.getShapes().getSelected().forEach(shape -> shape.setColor(color));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
