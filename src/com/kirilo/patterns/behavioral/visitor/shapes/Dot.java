package com.kirilo.patterns.behavioral.visitor.shapes;

import com.kirilo.patterns.behavioral.visitor.visitors.Visitor;

public class Dot extends AbstractShape {
    private int x;
    private int y;

    public Dot(int id, int x, int y) {
        super(id);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
