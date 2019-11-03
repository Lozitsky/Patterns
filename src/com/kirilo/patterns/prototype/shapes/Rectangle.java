package com.kirilo.patterns.prototype.shapes;

import java.util.Objects;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(Rectangle shape) {
        super(shape);
        if (shape != null) {
            width = shape.width;
            height = shape.height;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return width == rectangle.width &&
                height == rectangle.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), width, height);
    }

    public Rectangle() {
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public Rectangle clone() {
        return new Rectangle(this);
    }
}
