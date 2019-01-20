import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
import javafx.stage.*;

// Represents the main visual elements in the application. This View is the 'V'
// in MVC. The view interacts with the controller when user input is received
// and shows any updates from the data model on the screen. The view should
// contain as little "business logic" as possible -- that information is
// better handled by the controller and model.
public class MyView {
    // Class constants for the width and height of the window.
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    // The graphics object where we will draw updates.
    private final GraphicsContext graphics;
    
    // The model from which we will ask for data when updating.
    private final MyModel model;

    // The controller where we will send commands based on user input.
    private final MyController controller;

    // Instantiates the view by setting up all the UI elements and hooking up
    // the model and controller interactions.
    public MyView(Stage stage, MyController controller, MyModel model) {
        // Create the basic UI elements. We need to wrap the canvas in a Group
        // in order to add it to the scene.
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        Group root = new Group();
        root.getChildren().add(canvas);

        // Set the scene.
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene);

        // Set the class instance fields.
        this.graphics = canvas.getGraphicsContext2D();
        this.model = model;
        this.controller = controller;

        // We need to refresh explicitly once at the beginning, otherwise we
        // would have to wait for the user to press a key to see anything.
        this.refresh();

        // Finally, set up the UI events.
        //
        // NOTE: We need to request focus in order for key press events to be
        // handled by the Canvas. The term "focus" is used a lot in UI
        // programming and refers to which UI element is considered "active."
        //
        // A Canvas (unlike, say, a Button or TextField) is not usually
        // considered a "focusable" UI element, and key events are only sent to
        // "the node that has focus" (see:
        // https://docs.oracle.com/javafx/2/events/processing.htm ).
        canvas.requestFocus();
        canvas.setOnKeyPressed(e -> this.onKeyPressed(e));
    }
    
    // Responds to a key press event. If the event is handled (i.e. if it was
    // a valid user input that we understand), we will take that as a hint to
    // refresh the UI.
    private void onKeyPressed(KeyEvent e) {
        boolean handled = this.handleKeyPress(e.getCode());
        if (handled) {
            this.refresh();
        }
    }

    // Handles the key press. If we understand the key, we will ask the
    // controller to do the action associated with that key. This is called
    // "dispatching," and is much like how a transportation dispatcher might
    // give instructions to a truck driver on what route they should be
    // taking. The dispatcher is not interested in the details -- in the
    // case of this application it simply needs to be told "yes, I'll do it"
    // (boolean `true` value) or "no, that can't be done" (boolean `false`
    // value).
    private boolean handleKeyPress(KeyCode code) {
        switch (code) {
            // Arrow keys correspond to movement actions.
            case UP:
                return this.controller.moveUp();
            case DOWN:
                return this.controller.moveDown();
            case LEFT:
                return this.controller.moveLeft();
            case RIGHT:
                return this.controller.moveRight();
            // 'Z' and 'X' correspond to zoom actions.
            case Z:
                return this.controller.zoomOut();
            case X:
                return this.controller.zoomIn();
            // We don't understand any other key presses.
            default:
                return false;
        }
    }
    
    // Called whenever our canvas needs to be redrawn.
    private void refresh() {
        this.graphics.setFill(Color.GREEN);
        this.graphics.fillRect(0, 0, WIDTH, HEIGHT);
        this.drawBox();
    }
    
    // Draws the box on the screen.
    private void drawBox() {
        this.graphics.setFill(Color.BLACK);
        BlackBox box = this.model.getBox();
        this.graphics.fillText(box.toString(), WIDTH / 4, HEIGHT / 10);
        Point p = box.getPosition();
        int size = box.getSize();
        this.graphics.fillRect(p.getX(), p.getY(), size, size);
    }
}