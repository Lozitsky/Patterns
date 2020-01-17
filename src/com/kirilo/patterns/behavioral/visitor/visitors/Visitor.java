package com.kirilo.patterns.behavioral.visitor.visitors;

import com.kirilo.patterns.behavioral.visitor.shapes.Circle;
import com.kirilo.patterns.behavioral.visitor.shapes.CompoundShape;
import com.kirilo.patterns.behavioral.visitor.shapes.Dot;
import com.kirilo.patterns.behavioral.visitor.shapes.Rectangle;

public interface Visitor {
    String visit(Dot dot);

    String visit(Circle circle);

    String visit(Rectangle rectangle);

    String visit(CompoundShape compoundShape);
}
