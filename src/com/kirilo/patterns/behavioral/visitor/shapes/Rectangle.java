package com.kirilo.patterns.behavioral.visitor.shapes;

import com.kirilo.patterns.behavioral.visitor.visitors.Visitor;

public class Rectangle extends Dot {
    private int width, height;

    public Rectangle(int id, int x, int y, int width, int height) {
        super(id, x, y);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
