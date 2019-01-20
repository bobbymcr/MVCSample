// Represents a size with user-defined limits. The size is not allowed to grow
// above the max or shrink below the min.
public class BoundedSize {
    // The min and max limits. These fields are immutable.
    private final int min;
    private final int max;
    
    // The current position. This field is allowed to change and can be updated
    // by the increment method.
    private int current;
    
    // Initializes the size with the given min and max limits and a starting
    // value.
    public BoundedSize(int min, int max, int current) {
        this.min = min;
        this.max = max;
        this.current = current;
    }
    
    // Returns a string representation of this object, which is just the
    // current size.
    @Override
    public String toString() {
        return "" + this.current;
    }
    
    // Gets the current size.
    public int getSize() {
        return this.current;
    }
    
    // Attempts to increment the size by the given delta. The method first
    // checks whether the new size would be in range. If so, it will set the
    // current size to the new value and return true. Otherwise, it makes no
    // changes and returns false.
    public boolean increment(int d) {
        int newSize = this.current + d;
        if ((newSize <= this.max) && (newSize >= this.min)) {
            this.current = newSize;
            return true;
        } else {
            return false;
        }
    }
}