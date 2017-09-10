package drawing.domain;
import drawing.domain.Shapes.*;
import javafx.scene.shape.*;


public abstract class DrawingItem implements IPaintable{

    private Color color;
    private DrawingItem previousState;

    protected DrawingItem(Color color) {
        this.color = color;
    }

    protected DrawingItem(Color color, DrawingItem previousState) {
        this.color = color;
        this.previousState = previousState;
    }

    public abstract Point getAnchor();
    public abstract Double getWidth();

    public abstract Double getHeight();

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public DrawingItem getPreviousState() {
        return previousState;
    }

    public void setPreviousState(DrawingItem previousState) {
        this.previousState = previousState;
    }

    @Override
    public String toString(){return color.toString();}

    @Override
    public void paint(Oval oval) {
        //todo dingen
        Ellipse elipse = new Ellipse();


    }

    @Override
    public void paint(drawing.domain.Shapes.Polygon polygon) {
        //todo tekenen van een polygon met 3 ankerpunten

    }

    @Override
    public void paint(PaintedText text) {

        //todo
    }

    @Override
    public void paint(Image image) {

    }



}
