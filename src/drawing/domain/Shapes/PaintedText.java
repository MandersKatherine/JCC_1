package drawing.domain.Shapes;

import drawing.domain.Color;
import drawing.domain.DrawingItem;

public class PaintedText extends DrawingItem {
    private String context;
    private String fontName;
    private Point anchor;
    private Double width;
    private Double height;

    public PaintedText(Color color, String context, String fontName, Point anchor, double width, double height) {
        super(color);
        this.context = context;
        this.fontName = fontName;
        this.anchor = anchor;
        this.width = width;
        this.height = height;
    }

    public PaintedText(Color color, DrawingItem previousState, String context, String fontName, Point anchor, Double width, Double height) {
        super(color, previousState);
        this.context = context;
        this.fontName = fontName;
        this.anchor = anchor;
        this.width = width;
        this.height = height;
    }

    @Override
    public Double getWidth() {
        return width;
    }

    @Override
    public Double getHeight() {
        return height;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    @Override
    public Point getAnchor() {
        return anchor;
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
