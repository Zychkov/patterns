package ru.zychkov.behavioral.visitor.example2.visitor;

import ru.zychkov.behavioral.visitor.example2.shapes.Circle;
import ru.zychkov.behavioral.visitor.example2.shapes.CompoundShape;
import ru.zychkov.behavioral.visitor.example2.shapes.Dot;
import ru.zychkov.behavioral.visitor.example2.shapes.Rectangle;

public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}
