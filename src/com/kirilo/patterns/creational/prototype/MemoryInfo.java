package com.kirilo.patterns.creational.prototype;

import com.kirilo.patterns.creational.prototype.cache.BundledShapeCache;
import com.kirilo.patterns.creational.prototype.shapes.Shape;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class MemoryInfo {
    static Unsafe getUnsafeInstance() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(Unsafe.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static long addressOf(Object o) throws Exception {
        Unsafe unsafe = getUnsafeInstance();
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

    public static void compareShapes(BundledShapeCache cache, Shape shape1, Shape shape2) {
        String key1 = cache.getKey(shape1);
        String key2 = cache.getKey(shape2);

        if (shape1 != shape2) {
            if (key1.equals(key2)) {
                System.out.printf("%ss are different objects\n", key1);
                if (shape1.equals(shape2)) {
                    System.out.println("But they are identical.");
                } else {
                    System.out.println("And they are not identical.");
                }
            } else {
                //            System.out.println("Small red circle != Medium blue rectangle");
                if (!shape1.equals(shape2)) {
                    System.out.printf("%s != %s\n", key1, key2);
                } else {
                    System.out.printf("%s and %s are the same.\n", key1, key2);
                }
            }
        } else {
            if (key1.equals(key2)) {
                System.out.printf("%ss are the same.\n", key1);
            } else {
//            System.out.println("Small red circle == Medium blue rectangle");
                System.out.printf("%s == %s\n", key1, key2);
            }
        }

        getMemoryInfo(shape1, shape2);
    }

    public static void getMemoryInfo(Shape shape1, Shape shape2) {
        try {
            System.out.printf("shape1: {hash: %d}, {memory: %s}\nshape2: {hash: %d}, {memory: %s}\n", shape1.hashCode(), MemoryInfo.addressOf(shape1), shape2.hashCode(), MemoryInfo.addressOf(shape2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}