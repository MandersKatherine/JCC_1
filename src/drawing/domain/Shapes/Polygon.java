package drawing.domain.Shapes;

import drawing.domain.Color;
import drawing.domain.DrawingItem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Polygon extends DrawingItem {

    private final ArrayList<Point> vertices;
    private Double weight;

    public Polygon(Color color, ArrayList<Point> vertices, double weight) {
        super(color);
        this.vertices = vertices;
        this.weight = weight;
    }

    public Polygon(Color color, DrawingItem previousState, ArrayList<Point> vertices, Double weight) {
        super(color, previousState);
        this.vertices = vertices;
        this.weight = weight;
    }

    @Override
    public Point getAnchor() {
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

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        Iterator<Point> i = vertices.iterator();
        while (i.hasNext()) {
            String point = i.next().toString();
            returnString.append(point);
            if (i.hasNext()) {
                returnString.append(", ");
            }
        }
        if (!Objects.equals(returnString.toString(), "")){
            return super.getColor().toString() + " " + returnString;
        }
        return "No vertices available!!";
    }

    public ArrayList<Point> getVertices() {
        return vertices;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void PaintPolygon(){
        paint(this);
    }
}
