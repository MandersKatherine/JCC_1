package drawing.javafx;

import drawing.domain.IPaintable;
import drawing.domain.Shapes.*;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;

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
