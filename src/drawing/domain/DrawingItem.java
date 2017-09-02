package drawing.domain;
import drawing.domain.Shapes.Point;


public abstract class DrawingItem {

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
}
