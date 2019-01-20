// Just a simple black box that we can draw on the screen. This class is part
// of our model. Note that the box itself doesn't know anything about graphics.
// The view takes care of that detail, while the box just keeps track of its
// position, etc.
public class BlackBox {
    // Class constants representing the min and max size of the box.
    private static final int MIN_SIZE = 4;    
    private static final int MAX_SIZE = 40;

    // The point representing the current position (top left edge) of the box.
    private final BoundedPoint position;
    
    // The current size of the box. The box is a square so we only need to
    // store one size value.
    private final BoundedSize size;
    
    // Initializes the box with a starting size and location.
    public BlackBox() {
        this.size = new BoundedSize(MIN_SIZE, MAX_SIZE, 3 * MIN_SIZE);
        this.position = new BoundedPoint(100, 100, 300, 300);
    }
    
    // Returns a string representation of this object, which is just the
    // position and size, e.g. "(x, y) N".
    @Override
    public String toString() {
        return this.position + " " + this.size;
    }
    
    // Moves the box (if possible).
    public boolean move(int dx, int dy) {
        return this.position.move(dx, dy);
    }
    
    // Resizes the box (if possible).
    public boolean changeSize(int d) {
        return this.size.increment(d);
    }
    
    // Returns the current position.
    public Point getPosition() {
        return this.position.getPoint();
    }
    
    // Returns the current size.
    public int getSize() {
        return this.size.getSize();
    }
}