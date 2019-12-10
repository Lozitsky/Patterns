package com.kirilo.patterns.structural.facade.facades;

public class PointPolar {
    private double radius, angle;

    public PointPolar(double radius, double angle) {
        this.radius = radius;
        this.angle = angle;
    }

    public double getRadius() {
        return radius;
    }

    public double getAngle() {
        return angle;
    }

    public void rotate(int angle) {
        this.angle += angle % 360;
    }

    @Override
    public String toString() {
        return "PointPolar{" +
                "radius=" + radius +
                ", angle=" + angle +
                '}';
    }
}
