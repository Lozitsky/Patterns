package com.kirilo.patterns.behavioral.visitor.shapes;

public abstract class AbstractShape implements Shape {
    private int id;

    @Override
    public void move(int x, int y) {

    }

    @Override
    public void draw() {

    }

    public AbstractShape(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
