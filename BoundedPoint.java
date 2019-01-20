// Represents a point with user-defined boundaries. The point is not allowed to
// move left of or above the min, nor can it move right of or below the max.
public class BoundedPoint {
    // The min and max boundaries. These fields are immutable.
    private final Point min;
    private final Point max;

    // The current point. This field is allowed to change and can be updated by
    // the move method.
    private Point current;

    // Initializes the point with the given min and max bounds. The initial
    // location is set to min (upper left boundary).
    public BoundedPoint(int minX, int minY, int maxX, int maxY) {
        this.min = new Point(minX, minY);
        this.max = new Point(maxX, maxY);
        this.current = this.min;
    }
    
    // Returns a string representation of this object, which is just the
    // current Point location.
    @Override
    public String toString() {
        return this.current.toString();
    }
    
    // Gets the current point.
    public Point getPoint() {
        return this.current;
    }
    
    // Attempts to move the point by the given delta. The method first checks
    // whether the new point would be in bounds. If so, it will set the current
    // point to the new point and return true. Otherwise, it makes no changes
    // and returns false.
    public boolean move(int dx, int dy) {
        Point newPoint = this.current.translate(dx, dy);
        if ((newPoint.getX() >= this.min.getX()) &&
            (newPoint.getX() <= this.max.getX()) &&
            (newPoint.getY() >= this.min.getY()) &&
            (newPoint.getY() <= this.max.getY())) {
            this.current = newPoint;
            return true;
        } else {        
            return false;
        }
    }
}