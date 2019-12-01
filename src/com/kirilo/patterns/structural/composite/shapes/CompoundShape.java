package com.kirilo.patterns.structural.composite.shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompoundShape extends BaseShape {
    private List<Shape> children = new ArrayList<>();

    public CompoundShape(Shape... components) {
        super(0, 0, Color.BLACK);
        add(components);
    }

    public void add(Shape... components) {
        children.addAll(Arrays.asList(components));
    }
    public void add(Shape component) {
        children.add(component);
    }

    public void remove(Shape... components) {
        children.removeAll(Arrays.asList(components));
    }

    public void remove(Shape component) {
        children.remove(component);
    }



    public void clear() {
        children.clear();
    }

    @Override
    public int getX() {
        int x = 0;
        if (children.size() > 0) {
            x = children.get(0).getX();
            for (int i = 1; i < children.size(); i++) {
                Shape child = children.get(i);
                if (child.getX() < x) {
                    x = child.getX();
                }
            }
        }
        return x;
    }

    @Override
    public int getY() {
        int y = 0;
        if (children.size() > 0) {
            y = children.get(0).getY();
            for (int i = 1; i < children.size(); i++) {
                Shape child = children.get(i);
                if (child.getY() < y) {
                    y = child.getY();
                }
            }
        }
        return y;
    }

    @Override
    public int getWidth() {
        int maxWidth = 0;
        for (Shape child : children) {
            int currentWidth = child.getX() - getX() + child.getWidth();
            if (currentWidth > maxWidth) {
                maxWidth = currentWidth;
            }
        }
        return maxWidth;
    }

    @Override
    public int getHeight() {
        int maxHeight = 0;
        for (Shape child : children) {
            int currentHeight = child.getY() - getY() + child.getHeight();
            if (currentHeight > maxHeight) {
                maxHeight = currentHeight;
            }
        }
        return maxHeight;
    }

    @Override
    public void move(int x, int y) {
        for (Shape child : children) {
            child.move(x, y);
        }
    }

    @Override
    public boolean isInsideBounds(int x, int y) {
        for (Shape child : children) {
            if (child.isInsideBounds(x, y)) {
                return true;
            }
        }
        return false;
    }

    public void selectChildAt(int x, int y) {
        for (Shape child : children) {
            if (child.isInsideBounds(x, y)) {
                child.select();
                return;
            }
        }
    }

    @Override
    public void unselect() {
        super.unselect();
        for (Shape child : children) {
            child.unselect();
        }
    }

    @Override
    public void paint(Graphics graphics) {
        if (isSelected()) {
            enableSelectionStyle(graphics);
            graphics.drawRect(getX() - 1, getY() - 1, getWidth() + 1, getHeight() + 1);
            disableSelectionStyle(graphics);
        }
        for (Shape child : children) {
            child.paint(graphics);
        }
    }
}
