package com.kirilo.patterns.structural.adapter.round;

public class RoundHole {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public boolean fits(RoundPeg peg) {
        return this.radius >= peg.getRadius();
    }
}
