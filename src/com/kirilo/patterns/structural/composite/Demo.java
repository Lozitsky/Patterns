package com.kirilo.patterns.structural.composite;

import com.kirilo.patterns.structural.composite.editor.ImageEditor;
import com.kirilo.patterns.structural.composite.shapes.Circle;
import com.kirilo.patterns.structural.composite.shapes.CompoundShape;
import com.kirilo.patterns.structural.composite.shapes.Dot;
import com.kirilo.patterns.structural.composite.shapes.Rectangle;

import java.awt.*;

public class Demo {
    public static void main(String[] args) {
        ImageEditor editor = new ImageEditor();
        editor.loadShapes(
                new Circle(10, 10, Color.BLUE, 10),
                new CompoundShape(
                        new Circle(110, 110, Color.RED, 50),
                        new Dot(160, 160, Color.RED),
                        new Rectangle(100, 100, Color.RED, 60, 50)
                ),
                new CompoundShape(
                        new Rectangle(250, 250, Color.GREEN, 100, 100),
                        new Dot(240, 240, Color.GREEN),
                        new Dot(240, 360, Color.GREEN),
                        new Dot(360, 360, Color.GREEN),
                        new Dot(360, 240, Color.GREEN)
                )
        );
    }
}
