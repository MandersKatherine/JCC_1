package drawing.domain.Shapes;

import java.io.Serializable;

public class Point implements Serializable {
    private final Double x;
    private final Double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "X:" + x + " Y:" + y;
    }
}
