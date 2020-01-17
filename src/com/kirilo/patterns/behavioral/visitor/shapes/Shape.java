package com.kirilo.patterns.behavioral.visitor.shapes;

import com.kirilo.patterns.behavioral.visitor.visitors.Visitor;

public interface Shape {
    int getId();

    void move(int x, int y);

    void draw();

    String accept(Visitor visitor);
}
