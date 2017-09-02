package drawing.domain.Shapes;

import drawing.domain.Color;
import drawing.domain.DrawingItem;

public class Oval extends DrawingItem {
    private Double weight;
    private Point anchor;
    private Double width;
    private Double height;

    public Oval(Color color, double weight, Point anchor, double width, double height) {
        super(color);
        this.weight = weight;
        this.anchor = anchor;
        this.width = width;
        this.height = height;
    }

    public Oval(Color color, DrawingItem previousState, Double weight, Point anchor, Double width, Double height) {
        super(color, previousState);
        this.weight = weight;
        this.anchor = anchor;
        this.width = width;
        this.height = height;
    }

    @Override
    public Point getAcnhor() {
        return anchor;
    }

    @Override
    public Double getWidth() {
        return width;
    }

    @Override
    public Double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return super.getColor() + " X:" + anchor.getX().toString() + " Y:" + anchor.getY().toString();
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setAnchor(Point anchor) {
        this.anchor = anchor;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}
