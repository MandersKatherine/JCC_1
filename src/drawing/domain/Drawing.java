package drawing.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Drawing implements Serializable{

    private String name;
    private DrawingItem _drawingItem;
    private ArrayList<DrawingItem> drawings;

    public Drawing(String name, DrawingItem drawingItem) {
        this.name = name;
        this._drawingItem = drawingItem;
    }

    public Drawing(String name, ArrayList<DrawingItem> drawingItems) {
        this.name = name;
        this.drawings = drawingItems;
    }

    @Override
    public String toString() {
        return name + ' ' + _drawingItem.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DrawingItem getDrawingItem() {
        return _drawingItem;
    }

    public ArrayList<DrawingItem> getDrawings() {
        return drawings;
    }

    public void setDrawingItem(DrawingItem drawingItem) {
        _drawingItem.setPreviousState(_drawingItem);
        this._drawingItem = drawingItem;
    }
}
