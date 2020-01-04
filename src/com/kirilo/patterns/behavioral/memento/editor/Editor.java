package com.kirilo.patterns.behavioral.memento.editor;

import com.kirilo.patterns.behavioral.memento.commands.Command;
import com.kirilo.patterns.behavioral.memento.shapes.CompoundShape;
import com.kirilo.patterns.behavioral.memento.shapes.Shape;

public interface Editor {
    void loadShapes(Shape... shapes);

    CompoundShape getShapes();

    void execute(Command command);

    void undo();

    void redo();

    String backup();

    boolean restore(String state);
}
