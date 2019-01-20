// Represents all of the data in the application. This Model is the 'M' in MVC.
// A model ideally knows nothing about the user interface -- that knowledge is
// instead with the view. It also does not decide when to make updates to the
// data -- that is the controller's job.
//
// In a typical application, the model would also contain events to notify the
// view that its state has changed. In this case, however, we just provide a
// simple getter method which we expect the view to query when it wants to.
public class MyModel {
    // This app is very simple; it only has one data item.
    private final BlackBox box;
    
    // Initializes the model.
    public MyModel() {
        this.box = new BlackBox();
    }
    
    // Gets the only data item we have -- the box.
    public BlackBox getBox() {
        return this.box;
    }
}
