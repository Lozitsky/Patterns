package com.kirilo.patterns.behavioral.memento.commands;

public interface Command {
    String getName();

    boolean execute();
}
