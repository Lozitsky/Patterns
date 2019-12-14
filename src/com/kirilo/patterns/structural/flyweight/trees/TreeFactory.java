package com.kirilo.patterns.structural.flyweight.trees;

import java.awt.*;
import java.util.HashMap;

public class TreeFactory {
    private static HashMap<String, TreeType> hashMap;

    public static TreeType getTreeType(String name, Color color, String otherTreeType) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }

        TreeType type = hashMap.get(name);
        if (type == null) {
            type = new TreeType(name, color, otherTreeType);
        }
        hashMap.put(name, type);

        return type;
    }
}
