package com.kirilo.patterns.behavioral.visitor.shapes;

import com.kirilo.patterns.behavioral.visitor.visitors.Visitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompoundShape extends AbstractShape {
    private List<Shape> shapes = new ArrayList<>();

    public CompoundShape(int id) {
        super(id);
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    @Override
    public void move(int x, int y) {
        shapes.forEach(shape -> shape.move(x, y));
    }

    @Override
    public void draw() {
        shapes.forEach(Shape::draw);
    }

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public void add(Shape... shapes) {
        this.shapes.addAll(Arrays.asList(shapes));
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
