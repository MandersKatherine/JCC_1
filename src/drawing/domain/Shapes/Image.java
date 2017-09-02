package drawing.domain.Shapes;

import drawing.domain.Color;
import drawing.domain.DrawingItem;

import java.io.File;

public class Image extends DrawingItem  {
    private File file;
    private Point anchor;
    private Double width;
    private Double height;

    public Image(Color color, File file, Point anchor, double width, double height) {
        super(color);
        this.file = file;
        this.anchor = anchor;
        this.width = width;
        this.height = height;
    }

    public Image(Color color, DrawingItem previousState, File file, Point anchor, Double width, Double height) {
        super(color, previousState);
        this.file = file;
        this.anchor = anchor;
        this.width = width;
        this.height = height;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

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

    @Override
    public Point getAcnhor() {
        return null;
    }

    @Override
    public Double getWidth() {
        return 0.00;
    }

    @Override
    public Double getHeight() {
        return 0.00;
    }
}
