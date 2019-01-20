// Represents a 2-D point on a graphical display.
//
// In most 2-D computer graphics, the coordinate system defines (0, 0) as the
// top left of the display and (X, Y) as a point X units to the right and Y
// units *below*. The y-axis is thus "backwards" compared to what you probably
// learned in Algebra class.
//
// Note that this class is immutable, kind of like String in Java. That is,
// there is no way to modify an existing Point's values. Rather, you would use
// the translate method which returns a *new* instance with *new* values.
public class Point {
    // These fields are final, meaning they cannot be changed after
    // the instance is constructed. This ensures immutability.
    private final int x;
    private final int y;

    // Initializes the Point with the given X and Y value.
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    // Gets the X coordinate.
    public int getX() {
        return this.x;
    }

    // Gets the Y coordinate.
    public int getY() {
        return this.y;
    }
    
    // Returns a new Point translated by the given dx (left/right) and dy
    // (up/down) values.
    public Point translate(int dx, int dy) {
        return new Point(this.x + dx, this.y + dy);
    }
    
    // Returns a string representation of this object, "(x, y)".
    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}