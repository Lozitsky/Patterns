package com.kirilo.patterns.creational.prototype;

import com.kirilo.patterns.creational.prototype.cache.BundledShapeCache;
import com.kirilo.patterns.creational.prototype.shapes.Shape;

public class ClientCacheCode {
    public static void main(String[] args) {
        BundledShapeCache cache = new BundledShapeCache();

        Shape shape1 = cache.get("Small red circle");
        Shape shape2 = cache.get("Medium blue rectangle");
        Shape shape3 = cache.get("Medium blue rectangle");

        if (shape1 != shape2 && !shape1.equals(shape2)) {
            System.out.println("Small red circle != Medium blue rectangle");
        } else {
            System.out.println("Small red circle == Medium blue rectangle");
        }

        if (shape2 != shape3) {
            System.out.println("Medium blue rectangle are different objects");
            if (shape2.equals(shape3)) {
                System.out.println("And they are identical.");
                System.out.println("shape2: " + shape2.hashCode() + "\nshape3: " + shape3.hashCode());
            } else {
                System.out.println("But they are not identical.");
            }
        } else {
            System.out.println("Rectangle objects are the same.");
        }
    }
}
