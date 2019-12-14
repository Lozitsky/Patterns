//https://stackoverflow.com/questions/52353/in-java-what-is-the-best-way-to-determine-the-size-of-an-object/52682#52682

package com.kirilo.patterns.structural.flyweight;

import com.kirilo.patterns.structural.flyweight.forest.Forest;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import javax.swing.*;
import java.awt.*;

public class Demo {
    static int CANVAS_SIZE = 1000;
    static int TREES_TO_DRAW = 1000000;
    static int TREE_TYPES = 2;
    static boolean isFlyweight = true;

    public static void main(String[] args) {

        Forest forest = new Forest();
        long freeMemory = Runtime.getRuntime().freeMemory();
        if (!isFlyweight) {
            for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
                forest.plantTreeWithoutFactory(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE), " Summer Oak", Color.GREEN, "Summer Oak texture stub");
                forest.plantTreeWithoutFactory(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE), " Autumn Oak", Color.ORANGE, "Autumn Oak texture stub");
            }
        } else {
            for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
                forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE), " Summer Oak", Color.GREEN, "Summer Oak texture stub");
                forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE), " Autumn Oak", Color.ORANGE, "Autumn Oak texture stub");
            }
        }

        System.out.println("Obtains used memory using Runtime.getRuntime().freeMemory(): " + (freeMemory - Runtime.getRuntime().freeMemory()) / 1024 / 1024 + "Mb");

        forest.setSize(CANVAS_SIZE, CANVAS_SIZE);
        forest.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        forest.setVisible(true);

        System.out.println("Get object size using ObjectSizeCalculator: " + getObjectMemory(forest) + "Mb");
    }

    private static long getObjectMemory(Object object) {
/*        return (Runtime.getRuntime().totalMemory() -
                Runtime.getRuntime().freeMemory())/1024/1024;*/
        String property = System.getProperty("java.vm.name");
        System.out.println(property);
        if (property.startsWith("Java HotSpot(TM)")) {
            try {
                return ObjectSizeCalculator.getObjectSize(object) / 1024 / 1024;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return com.twitter.common.objectsize.ObjectSizeCalculator.getObjectSize(object) / 1024 / 1024;
        }
        return 0;
    }

    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
