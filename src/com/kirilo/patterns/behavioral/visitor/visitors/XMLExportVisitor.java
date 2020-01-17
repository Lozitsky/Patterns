package com.kirilo.patterns.behavioral.visitor.visitors;

import com.kirilo.patterns.behavioral.visitor.shapes.*;

public class XMLExportVisitor implements Visitor {
    public String export(Shape... shapes) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < shapes.length; i++) {
            Shape shape = shapes[i];
            stringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n")
                    .append(shape.accept(this));
            if (i < shapes.length - 1) {
                stringBuilder.append("\n\n");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String visit(Dot dot) {
        return getMainTag("dot",
                getTag("id", dot.getId()),
                getTag("x", dot.getX()),
                getTag("y", dot.getY())
        );
    }

    @Override
    public String visit(Circle circle) {
        return getMainTag("circle",
                getTag("id", circle.getId()),
                getTag("x", circle.getX()),
                getTag("y", circle.getY()),
                getTag("radius", circle.getRadius())
        );
    }

    @Override
    public String visit(Rectangle rectangle) {
        return getMainTag("rectangle",
                getTag("id", rectangle.getId()),
                getTag("x", rectangle.getX()),
                getTag("y", rectangle.getY()),
                getTag("height", rectangle.getHeight()),
                getTag("width", rectangle.getWidth())
        );
    }

    @Override
    public String visit(CompoundShape compoundShape) {
        return getMainTag("compound_shape",
                getTag("id", compoundShape.getId()),
                visitCompoundShape(compoundShape)
        );
    }

    private String visitCompoundShape(CompoundShape compoundShape) {
        StringBuilder builder = new StringBuilder();
        for (Shape shape : compoundShape.getShapes()) {
            String stringTags = shape.accept(this);
            stringTags = String.format("\t%1$s\n", stringTags.replace("\n", "\n\t"));
            builder.append(stringTags);
        }
        return builder.toString();
    }

    private String getTag(String name, Object value) {
        return String.format("\t<%1$s>%2$s</%1$s>\n", name, value.toString());
    }

    private String getMainTag(String name, String... values) {
        StringBuilder builder = new StringBuilder();
        for (String value : values) {
            builder.append(value);
        }
        return String.format("<%1$s>\n%2$s</%1$s>", name, builder.toString());
    }
}
