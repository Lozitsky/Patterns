package com.kirilo.patterns.structural.facade.facades;

public class PointCartesian {
    private double x, y;

    public PointCartesian(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "PointCartesian{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void move(int x, int y) {

        this.x += x;
        this.y += y;
    }
}
