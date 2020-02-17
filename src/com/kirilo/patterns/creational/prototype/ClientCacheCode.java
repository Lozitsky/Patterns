package com.kirilo.patterns.creational.prototype;

import com.kirilo.patterns.creational.prototype.cache.BundledShapeCache;
import com.kirilo.patterns.creational.prototype.shapes.Shape;

import static com.kirilo.patterns.creational.prototype.MemoryInfo.compareShapes;

//https://stackoverflow.com/questions/7060215/how-can-i-get-the-memory-location-of-a-object-in-java/7060500
//https://javapapers.com/core-java/address-of-a-java-object/

public class ClientCacheCode {
//    private static Unsafe unsafe;

    public static void main(String[] args) {
        BundledShapeCache cache = new BundledShapeCache();

        Shape shape1 = cache.get("Small red circle");
        Shape shape2 = cache.get("Medium blue rectangle");
        Shape shape3 = cache.get("Medium blue rectangle");

        compareShapes(cache, shape1, shape2);
        System.out.println();
        compareShapes(cache, shape2, shape3);
        System.out.println();
        compareShapes(cache, shape3, shape3);
    }

}
