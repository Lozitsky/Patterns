package com.kirilo.patterns.behavioral.memento.commands;

import com.kirilo.patterns.behavioral.memento.editor.Editor;
import com.kirilo.patterns.behavioral.memento.shapes.Shape;

public class MoveCommand implements Command, Move {
    private Editor editor;
    private int startX, startY, endX, endY;

    public MoveCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public String getName() {
        return "Move by X:" + (endX - startX) + " Y:" + (endY - startY);
    }

    @Override
    public boolean execute() {
        try {
            editor.getShapes().getSelected().forEach(shape -> shape.moveBy(endX - startX, endY - startY));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void start(int x, int y) {
        startX = x;
        startY = y;
        editor.getShapes().getSelected().forEach(Shape::drag);
    }

    @Override
    public void move(int x, int y) {
        editor.getShapes().getSelected().forEach(shape -> shape.moveTo(x - startX, y - startY));
    }

    @Override
    public void stop(int x, int y) {
        endX = x;
        endY = y;
        editor.getShapes().getSelected().forEach(Shape::drop);
    }
}
