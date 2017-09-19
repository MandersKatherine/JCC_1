package drawing.javafx;

import drawing.domain.IPaintable;
import drawing.domain.Shapes.*;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JavaFXPaintable implements IPaintable {


    private GraphicsContext gc;

    public JavaFXPaintable(GraphicsContext graphicsContext) {
        gc = graphicsContext;
    }

    @Override
    public void paint(Oval oval) {
        gc.setStroke(Color.WHITESMOKE);
        gc.strokeOval(oval.getAnchor().getX(), oval.getAnchor().getY(), oval.getWidth(), oval.getHeight());
    }

    public void getX(Polygon polygon){

        List<Point> pointsarray = polygon.getVertices();

        List Xlist = new ArrayList();

        for (Iterator<Point> i = pointsarray.iterator(); i.hasNext();) {
            Point item = i.next();

            Xlist.add(item.getX());
        }
    }

    public void getY(Polygon polygon)
    {
        List<Point> pointsarray = polygon.getVertices();

        List Ylist = new ArrayList();

        for (Iterator<Point> i = pointsarray.iterator(); i.hasNext();) {
            Point item = i.next();

            Ylist.add(item.getY());
        }
    }


    @Override
    public void paint(Polygon polygon) {

        double[] X = new double[polygon.getVertices().size()];
        double[] Y = new double[polygon.getVertices().size()];

        int i = 0;

        for(Point p: polygon.getVertices()){
            X[i] = p.getX();
            Y[i] = p.getY();
            i++;
        }

        gc.setStroke(Color.RED);
        gc.strokePolygon(X, Y, polygon.getVertices().size());

    }

    @Override
    public void paint(PaintedText text) {



    }

    @Override
    public void paint(Image image) {

    }
}
