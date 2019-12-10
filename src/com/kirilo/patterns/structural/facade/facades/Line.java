package com.kirilo.patterns.structural.facade.facades;

public class Line implements Movement {
    private Point first, second;

    public Line(Point first, Point second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public void move(int x, int y) {
        first.move(x, y);
        second.move(x, y);
    }

    @Override
    public String toString() {
        return "Line{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    @Override
    public void rotate(int angle) {
        second.rotate(angle, first);
    }
}
