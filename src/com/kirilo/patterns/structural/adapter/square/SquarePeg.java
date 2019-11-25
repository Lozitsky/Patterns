package com.kirilo.patterns.structural.adapter.square;

public class SquarePeg {
    private double width;

    public double getWidth() {
        return width;
    }

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getSquare() {
        return Math.pow(width, 2);
    }
}
