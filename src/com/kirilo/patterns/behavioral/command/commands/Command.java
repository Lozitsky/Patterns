package com.kirilo.patterns.behavioral.command.commands;

public interface Command {
    void backup();

    void undo();

    boolean execute();
}
