package com.kirilo.patterns.behavioral.memento.shapes;

import java.awt.*;

public abstract class BaseShape implements Shape {
    private int x, y, dx, dy;
    private Color color;
    private boolean selected;

    public BaseShape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void drag() {
        dx = x;
        dy = y;
    }

    @Override
    public void drop() {
        x = dx;
        y = dy;
    }


    @Override
    public void moveTo(int x, int y) {

        this.x = x + dx;
        this.y = y + dy;
    }

    @Override
    public void moveBy(int x, int y) {

        this.x += x;
        this.y += y;
    }

    @Override
    public boolean isInsideBounds(int x, int y) {
        return x > this.x && x < this.x + getWidth()
                && y > this.y && y < this.y + getHeight();
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {

        this.color = color;
    }

    @Override
    public boolean select() {
        return selected = true;
    }

    @Override
    public void unSelect() {
        selected = false;
    }

    @Override
    public boolean toggle() {
        return selected = !selected;
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    @Override
    public void paint(Graphics graphics) {
        if (isSelected()) {
            enableSelectionStyle(graphics);
        } else {
            disableSelectionStyle(graphics);
        }
    }

    protected void enableSelectionStyle(Graphics graphics) {
        graphics.setColor(Color.LIGHT_GRAY);
        Graphics2D graphics2D = (Graphics2D) graphics;
        float[] dash = {2.0f};
        graphics2D.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 2.0f, dash, 0.0f));
    }

    protected void disableSelectionStyle(Graphics graphics) {
        graphics.setColor(color);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setStroke(new BasicStroke());
    }

}
