package drawing.javafx;

import drawing.domain.IPaintable;
import drawing.domain.Shapes.*;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.*;

public class JavaFXPaintable implements IPaintable {

    //GraphicsContext gc =
    //this.drawingCanvas.getGraphicsContext2D();
    //this.paintable = new JavaFXPaintable(gc);
    //this.drawing.paintUsing(this.paintable);


    @Override
    public void paint(Oval oval) {
        Group root = new Group();
        Scene s = new Scene(root, 300, 300, Color.BLACK);

        final Canvas canvas = new Canvas(250, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setStroke(Color.WHITESMOKE);
        gc.strokeOval(oval.getAnchor().getX(), oval.getAnchor().getY(), oval.getWidth(), oval.getHeight());

        root.getChildren().add(canvas);
    }

    @Override
    public void paint(Polygon polygon) {

    }

    @Override
    public void paint(PaintedText text) {

    }

    @Override
    public void paint(Image image) {

    }
}
