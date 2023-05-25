import controller.Controller;
import view.View;

public class Main {
    public static void main(String[] args) {
        new Controller(new View());
    }
    //we create a new instance of the Controler where we introduce as a atribute an object of type view (GUI)
}