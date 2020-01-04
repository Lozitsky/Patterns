package com.kirilo.patterns.behavioral.memento.commands;

public interface Move {
    void start(int x, int y);

    void move(int x, int y);

    void stop(int x, int y);
}
