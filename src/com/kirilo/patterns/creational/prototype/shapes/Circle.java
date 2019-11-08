package com.kirilo.patterns.creational.prototype.shapes;

import java.util.Objects;

public class Circle extends Shape {
    private int radius;

    public Circle() {
    }

    public Circle(Circle shape) {
        super(shape);
        if (shape != null) {
            radius = shape.radius;
        }
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius);
    }

    @Override
    public Circle clone() {
        return new Circle(this);
    }
}
