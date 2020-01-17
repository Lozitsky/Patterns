package com.kirilo.patterns.behavioral.visitor;

import com.kirilo.patterns.behavioral.visitor.shapes.Circle;
import com.kirilo.patterns.behavioral.visitor.shapes.CompoundShape;
import com.kirilo.patterns.behavioral.visitor.shapes.Dot;
import com.kirilo.patterns.behavioral.visitor.shapes.Rectangle;
import com.kirilo.patterns.behavioral.visitor.visitors.XMLExportVisitor;

public class Demo {
    public static void main(String[] args) {
        Dot dot = new Dot(1, 10, 55);
        Circle circle = new Circle(2, 23, 15, 10);
        Rectangle rectangle = new Rectangle(3, 10, 17, 20, 30);

        CompoundShape compoundShape = new CompoundShape(4);
        compoundShape.add(dot, circle, rectangle);

        CompoundShape compoundShape2 = new CompoundShape(5);
        compoundShape2.add(dot);
        compoundShape.add(compoundShape2);

        CompoundShape compoundShape3 = new CompoundShape(6);
        compoundShape3.add(dot, rectangle);

        XMLExportVisitor xmlExportVisitor = new XMLExportVisitor();
        System.out.println(xmlExportVisitor.export(circle, compoundShape, compoundShape3));
    }
}
