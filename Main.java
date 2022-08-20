
public class Main{
    public static void main(String[]args) {

        Grid stacker = new Grid();
        Window test = new Window(stacker);
        test.createAndShowGUI();
        stacker.startGame();

    }
}

