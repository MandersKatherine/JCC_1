package drawing.domain;

import drawing.domain.Shapes.Oval;
import drawing.domain.Shapes.Point;
import drawing.domain.Shapes.Polygon;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import drawing.javafx.*;

import javax.swing.*;

import static javax.swing.JComponent.WHEN_FOCUSED;


public class Main extends Application {

    private int clicks = 0;
    private Point firstClick;
    private JavaFXPaintable jfxp;

    @Override
    public void start(Stage primaryStage) {


        Group root = new Group();
        Scene s = new Scene(root, 600, 400, javafx.scene.paint.Color.BLACK);

        final Canvas canvas = new Canvas(500, 300);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        jfxp = new JavaFXPaintable(gc);
        root.getChildren().add(canvas);
        Drawing d = new DatabaseMediator().load("Drawing");
        for (DrawingItem item : d.getDrawings()) {
            if(item.getClass() == Oval.class){
                jfxp.paint((Oval)item);
            }
            else if (item.getClass() == Polygon.class){
                jfxp.paint((Polygon)item);
            }
        }
        primaryStage.setScene(s);
        primaryStage.show();


        s.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("X: " + event.getX() + " Y: " + event.getY());

                //if (cbOvals.Checked){
                //todo een cbOvals maken
                if (clicks >= 1) {
                    //todo check inbouwen voor de linkerbovenhoek, wanneer deze groter is dan de tweede klik
                    double width = event.getX() - firstClick.getX();
                    double height = event.getY() - firstClick.getY();

                    Oval oval = new Oval(Color.BLUE, 3, firstClick, width, height);
                    jfxp.paint(oval);
                    clicks = 0;
                } else {
                    firstClick = new Point(event.getX(), event.getY());
                    clicks++;
                }

                ArrayList<Point> points = new ArrayList<>();
                points.add(new Point(5.00, 3.00));
                points.add(new Point(30.00, 40.25));
                points.add(new Point(170.00, 60.25));
                Polygon polygon = new Polygon(Color.RED, points, 1);
                jfxp.paint(polygon);

                gc.strokeText("JCC IS COOL", 180, 33);

            }
        });
    }

     public static void main(String[] args) {
                // New oval
                DrawingItem item = new Oval(Color.BLUE, 2.00, new Point(3.50, 3.50), 30.00, 40.00);
                Drawing drawing = new Drawing("Oval", item);
                // Write to console
                System.out.println(drawing.toString());

                // Array with points of a polygon, a triangle in this case
                ArrayList<Point> points = new ArrayList<>();
                points.add(new Point(5.00, 3.00));
                points.add(new Point(80.00, 45.25));
                points.add(new Point(150.00, 90.25));

                // Create polygon
                item = new Polygon(Color.BLUE, item, points, 1.00);
                // Write to console
                drawing.setDrawingItem(item);
                drawing.setName("Triangle");
                System.out.println(drawing.toString());
                System.out.println("Previous state: " + drawing.getDrawingItem().getPreviousState().toString());

                ArrayList<DrawingItem> di = new ArrayList<>();
                di.add(new Oval(Color.BLUE, 2.00, new Point(3.50, 3.50), 30.00, 40.00));
                di.add(new Polygon(Color.RED, points, 1));
                Drawing d = new Drawing("Drawing", di);
                new DatabaseMediator().save(d);

                


                launch(args);
            }
        }


