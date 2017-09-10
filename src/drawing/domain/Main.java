package drawing.domain;

import drawing.domain.Shapes.Oval;
import drawing.domain.Shapes.Point;
import drawing.domain.Shapes.Polygon;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
    }


    public static void main(String[] args)
    {
        // New oval
        DrawingItem item = new Oval(Color.BLUE,2.00,new Point(3.50,3.50),30.00,40.00);
        Drawing drawing = new Drawing("Oval", item);
        // Write to console
        System.out.println(drawing.toString());

        // Array with points of a polygon, a triangle in this case
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(5.00,3.00));
        points.add(new Point(3.00,4.25));
        points.add(new Point(7.00,6.25));

        // Create polygon
        item = new Polygon(Color.BLUE, item, points,1.00);
        // Write to console
        drawing.setDrawingItem(item);
        drawing.setName("Triangle");
        System.out.println(drawing.toString());
        System.out.println("Previous state: " + drawing.getDrawingItem().getPreviousState().toString());

        System.exit(0);
    }
}
