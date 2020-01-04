package com.kirilo.patterns.behavioral.memento.shapes;

import java.util.List;

public interface ListShape {
    void add(Shape shape);

    void add(Shape... shapes);

    void remove(Shape shape);

    void remove(Shape... shapes);

    void clear();

    Shape getChildAt(int x, int y);

    boolean selectChildAt(int x, int y);

    List<Shape> getSelected();

}
