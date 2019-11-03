package com.kirilo.patterns.prototype.shapes;

import com.kirilo.patterns.prototype.Cloner;

import java.util.Objects;

public abstract class Shape implements Cloner {
    private int x;
    private int y;
    private String color;

    public Shape() {
    }

    public Shape(Shape shape) {
        if (shape != null) {
            x = shape.x;
            y = shape.y;
            color = shape.color;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shape)) return false;
        Shape shape = (Shape) o;
        return x == shape.x &&
                y == shape.y &&
                color.equals(shape.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, color);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public abstract Shape clone();
}
