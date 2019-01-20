// Represents all of the user interactions in the application. This Controller
// is the 'C' in MVC. The controller interacts with the model, usually when
// told to do so due to an "event" (like a key press or mouse movement).
//
// Ideally, a controller does not know how the user interface is implemented.
// It is typically the view's responsibility to tell the controller that an
// event happened and in a way that the controller will understand. So you will
// not see any code relating to key presses or anything like that. Instead, the
// controller provides "commands" that the view should invoke given specific
// user input.
public class MyController {
    // Class constant for the delta value of each movement.    
    private static final int DELTA = 2;

    // The model which we will update on user input.
    private final MyModel model;
    
    // Initializes the controller with this model.
    public MyController(MyModel model) {
        this.model = model;
    }
    
    // Requests the model item (box) to move up.
    public boolean moveUp() {
        return this.model.getBox().move(0, -DELTA);
    }

    // Requests the model item (box) to move down.
    public boolean moveDown() {
        return this.model.getBox().move(0, DELTA);
    }

    // Requests the model item (box) to move left.
    public boolean moveLeft() {
        return this.model.getBox().move(-DELTA, 0);
    }

    // Requests the model item (box) to move right.
    public boolean moveRight() {
        return this.model.getBox().move(DELTA, 0);
    }

    // Requests the model item (box) to zoom in.
    public boolean zoomIn() {
        return this.model.getBox().changeSize(DELTA);
    }

    // Requests the model item (box) to zoom out.
    public boolean zoomOut() {
        return this.model.getBox().changeSize(-DELTA);
    }
}