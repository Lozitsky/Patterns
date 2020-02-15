package com.kirilo.patterns.creational.prototype;

import com.kirilo.patterns.creational.prototype.cache.BundledShapeCache;
import com.kirilo.patterns.creational.prototype.shapes.Shape;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

//https://stackoverflow.com/questions/7060215/how-can-i-get-the-memory-location-of-a-object-in-java/7060500
public class ClientCacheCode {
    private static Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long addressOf(Object o)
            throws Exception {
        Object[] array = new Object[]{o};

        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        int addressSize = unsafe.addressSize();
        long objectAddress;
        switch (addressSize) {
            case 4:
                objectAddress = unsafe.getInt(array, baseOffset);
                break;
            case 8:
                objectAddress = unsafe.getLong(array, baseOffset);
                break;
            default:
                throw new Error("unsupported address size: " + addressSize);
        }

        return (objectAddress);
    }

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
            System.out.println("Medium blue rectangles are different objects");
            if (shape2.equals(shape3)) {
                System.out.println("And they are identical.");
                try {
                    System.out.printf("shape2: %d{%s}\nshape3: %d{%s}\n", shape2.hashCode(), addressOf(shape2), shape3.hashCode(), addressOf(shape3));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("But they are not identical.");
            }
        } else {
            System.out.println("Rectangle objects are the same.");
        }
    }
}
