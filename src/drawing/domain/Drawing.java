package drawing.domain;

class Drawing {

    private String name;
    private DrawingItem _drawingItem;

    public Drawing(String name, DrawingItem drawingItem) {
        this.name = name;
        this._drawingItem = drawingItem;
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

    public void setDrawingItem(DrawingItem drawingItem) {
        _drawingItem.setPreviousState(_drawingItem);
        this._drawingItem = drawingItem;
    }
}
