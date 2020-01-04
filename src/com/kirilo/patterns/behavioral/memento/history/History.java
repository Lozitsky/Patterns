package com.kirilo.patterns.behavioral.memento.history;

import com.kirilo.patterns.behavioral.memento.commands.Command;

public interface History {
    void push(Command command, Memento memento);

    boolean undo();

    boolean redo();
}
