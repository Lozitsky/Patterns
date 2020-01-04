package com.kirilo.patterns.behavioral.memento.shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CompoundShape extends BaseShape implements ListShape {
    private List<Shape> shapes = new ArrayList<>();

    public CompoundShape(Shape... shapes) {
        super(0, 0, Color.BLACK);
        add(shapes);
    }

    @Override
    public int getX() {
        return shapes.size() == 0 ? 0 : shapes.stream().min(Comparator.comparingInt(Shape::getX)).get().getX();
    }

    @Override
    public int getY() {
        return shapes.size() == 0 ? 0 : shapes.stream().min(Comparator.comparingInt(Shape::getY)).get().getY();
    }

    @Override
    public int getWidth() {
        return shapes.stream().map(shape -> shape.getX() - getX() + shape.getWidth()).max(Integer::compareTo).orElse(0);
    }

    @Override
    public int getHeight() {
        return shapes.stream().map(shape -> shape.getY() - getY() + shape.getHeight()).max(Integer::compareTo).orElse(0);
    }

    @Override
    public void drag() {
        shapes.forEach(Shape::drag);
    }

    @Override
    public void drop() {
        shapes.forEach(Shape::drop);
    }

    @Override
    public void moveTo(int x, int y) {
        shapes.forEach(shape -> shape.moveTo(x, y));
    }

    @Override
    public void moveBy(int x, int y) {
        shapes.forEach(shape -> shape.moveBy(x, y));
    }

    @Override
    public boolean isInsideBounds(int x, int y) {
        return shapes.stream().map(shape -> shape.isInsideBounds(x, y)).filter(Boolean::booleanValue).findFirst().orElse(false);
    }

    @Override
    public Color getColor() {
        return super.getColor();
    }

    @Override
    public void setColor(Color color) {
        shapes.forEach(shape -> shape.setColor(color));
    }

    @Override
    public void unSelect() {
        super.unSelect();
        shapes.forEach(Shape::unSelect);
    }

    @Override
    public boolean isSelected() {
        return super.isSelected();
    }

    @Override
    public boolean select() {
        return super.select();
    }

    @Override
    public void paint(Graphics graphics) {
        if (isSelected()) {
            enableSelectionStyle(graphics);
            graphics.drawRect(getX() - 1, getY() - 1, getWidth() + 1, getHeight() + 1);
            disableSelectionStyle(graphics);
        }
        shapes.forEach(shape -> shape.paint(graphics));
    }

    @Override
    public void add(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public void add(Shape... shapes) {
        this.shapes.addAll(Arrays.asList(shapes));
    }

    @Override
    public void remove(Shape shape) {
        shapes.remove(shape);
    }

    @Override
    public void remove(Shape... shapes) {
        this.shapes.addAll(Arrays.asList(shapes));
    }

    @Override
    public void clear() {
        shapes.clear();
    }

    @Override
    public Shape getChildAt(int x, int y) {
        return shapes.stream().filter(shape -> shape.isInsideBounds(x, y)).findFirst().orElse(null);
    }

    @Override
    public boolean selectChildAt(int x, int y) {
        Shape child = getChildAt(x, y);
        return child != null && child.select();
    }

    @Override
    public List<Shape> getSelected() {
        return shapes.stream().filter(Shape::isSelected).collect(Collectors.toList());
    }
}
