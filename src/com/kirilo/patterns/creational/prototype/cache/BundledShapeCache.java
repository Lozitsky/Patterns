package com.kirilo.patterns.creational.prototype.cache;

import com.kirilo.patterns.creational.prototype.shapes.Circle;
import com.kirilo.patterns.creational.prototype.shapes.Rectangle;
import com.kirilo.patterns.creational.prototype.shapes.Shape;

import java.util.HashMap;
import java.util.Map;

public class BundledShapeCache {
    private Map<String, Shape> cache = new HashMap<>();

    public BundledShapeCache() {
        Circle circle = new Circle();
        circle.setX(10);
        circle.setY(20);
        circle.setRadius(15);
        circle.setColor("red");

        Rectangle rectangle = new Rectangle();
        rectangle.setX(20);
        rectangle.setY(30);
        rectangle.setHeight(10);
        rectangle.setHeight(20);
        rectangle.setColor("blue");

        cache.put("Small red circle", circle);
        cache.put("Medium blue rectangle", rectangle);
    }

    public Shape put(String key, Shape shape) {
        cache.put(key, shape);
        return shape;
    }

    public Shape get(String key) {
        return cache.get(key).clone();
    }

    public String getKey(Shape shape) {
        for (String key : cache.keySet()) {
            if (cache.get(key).equals(shape)) {
                return key;
            }
        }
        return null;
    }
}
