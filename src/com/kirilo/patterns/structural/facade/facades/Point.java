package com.kirilo.patterns.structural.facade.facades;

public class Point implements Movement {
    private PointCartesian pointCartesian;

    /*    private Point point;

        public Point(double x, double y, Point point) {
            this.point = point;
            pointCartesian = new PointCartesian(x, y);
        }*/
    public Point(double x, double y) {
        pointCartesian = new PointCartesian(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "pointCartesian=" + pointCartesian.toString() +
                '}';
    }

    @Override
    public void move(int x, int y) {
        pointCartesian.move(x, y);
    }

    @Override
    public void rotate(int angle) {
        this.rotate(angle, new Point(0, 0));
    }

    public void rotate(int angle, Point point) {
        double x = pointCartesian.getX() - point.pointCartesian.getX();
        double y = pointCartesian.getY() - point.pointCartesian.getY();
        PointPolar pointPolar = new PointPolar(Math.sqrt(x * x + y * y), Math.atan2(y, x) * 180 / Math.PI);
        pointPolar.rotate(angle);
        System.out.println("  PointPolar is " + pointPolar);
        String str = pointPolar.toString();
        double r = pointPolar.getRadius();
        double a = pointPolar.getAngle();
        pointCartesian = new PointCartesian(r * Math.cos(a * Math.PI / 180) + point.pointCartesian.getX(),
                r * Math.sin(a * Math.PI / 180) + point.pointCartesian.getY());
    }
}
