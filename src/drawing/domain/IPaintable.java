package drawing.domain;

import drawing.domain.Shapes.Image;
import drawing.domain.Shapes.Oval;
import drawing.domain.Shapes.PaintedText;
import drawing.domain.Shapes.Polygon;

public interface IPaintable {

void paint(Oval oval);

void paint(Polygon polygon);

void paint(PaintedText text);

void paint(Image image);

}
