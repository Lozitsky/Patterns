package com.kirilo.patterns.structural.flyweight.forest;

import com.kirilo.patterns.structural.flyweight.trees.Tree;
import com.kirilo.patterns.structural.flyweight.trees.TreeFactory;
import com.kirilo.patterns.structural.flyweight.trees.TreeType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Forest extends JFrame {
    private ArrayList<Tree> list = new ArrayList<>();

    public ArrayList<Tree> getList() {
        return list;
    }

    public void plantTree(int x, int y, String name, Color color, String otherStringData) {
        TreeType treeType = TreeFactory.getTreeType(name, color, otherStringData);
        Tree tree = new Tree(x, y, treeType);
        list.add(tree);
    }

    public void plantTreeWithoutFactory(int x, int y, String name, Color color, String otherStringData) {
        TreeType treeType = new TreeType(name, color, otherStringData);
        Tree tree = new Tree(x, y, treeType);
        list.add(tree);
    }

    @Override
    public void paint(Graphics g) {
        for (Tree tree : list) {
            tree.draw(g);
        }
    }
}
