import javafx.application.*;
import javafx.stage.*;

// The Main application class. Here we set up the "MVC" components and display
// the primary stage (main window).
public class Main extends Application {
    // Our entry point (the "main" of JavaFX). Since we are using an "MVC"
    // design, most of the real work happens in the MyModel, MyView, and
    // MyController classes.
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MVC Sample App");

        MyModel model = new MyModel();
        MyController controller = new MyController(model);
        MyView view = new MyView(primaryStage, controller, model);
        
        primaryStage.show();
    }
}