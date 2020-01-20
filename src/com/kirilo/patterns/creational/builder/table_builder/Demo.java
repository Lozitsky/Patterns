package com.kirilo.patterns.creational.builder.table_builder;

import com.kirilo.patterns.creational.builder.table_builder.builders.Builder;
import com.kirilo.patterns.creational.builder.table_builder.builders.TableDirector;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class Demo {
    public static void main(String[] args) {
        new Demo().runDemo(args);
    }

    public void runDemo(String... args) {
        String className = args.length > 0 ? args[0] : "JTableBuilder";
//        GridLayoutBuilder
//        GridBagLayoutBuilder
        Builder builder = null;

        try {
            builder = (Builder) Class.forName(getClass().getPackage().getName() + ".builders." +className).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        String file = getClass().getResource("./BuilderDemo.dat").getFile();
        TableDirector director = new TableDirector(builder);
        director.construct(file);
        Component component = builder.getResult();

        JFrame frame = new JFrame("BuilderDemo - " + className);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(component);
        frame.pack();
        frame.setVisible(true);
    }
}
