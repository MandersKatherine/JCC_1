package drawing.domain.Shapes;

import drawing.domain.Color;
import drawing.domain.DrawingItem;

import java.util.ArrayList;
import java.util.Iterator;

public class Polygon extends DrawingItem {

    private ArrayList<Point> vertices;
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

    @Override
    public String toString() {
        String returnString = "";
        Iterator<Point> i = vertices.iterator();
        while (i.hasNext()) {
            String point = i.next().toString();
            returnString += point;
            if (i.hasNext()) {
                returnString += ", ";
            }
        }
        if (returnString != ""){
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
}
