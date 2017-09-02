package drawing.domain;
import drawing.domain.Shapes.Point;


public abstract class DrawingItem {

    private Color color;
    private DrawingItem previousState;

    public DrawingItem(Color color) {
        this.color = color;
    }

    public DrawingItem(Color color, DrawingItem previousState) {
        this.color = color;
        this.previousState = previousState;
    }

    public abstract Point getAcnhor();
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
}
