import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements  ActionListener {
    private static final Color BACKGROUND = Color.BLACK;
    private Timer refreshTimer = new Timer(500,this);
    private JFrame frame;
    private Grid grid;
    private StackerImage screen;
    private JLabel winLabel;
    private JLabel loseLabel;

    public Window(Grid grid){
        this.grid = grid;
    }

    public void createAndShowGUI()
    {
        screen = new StackerImage(grid.returnGrid());
        frame = new JFrame();
        frame.add(screen);
        screen.setLayout(new FlowLayout());
        winLabel = new JLabel("You Win! :)");
        winLabel.setFont(new Font("Arial", 0, 30));
        winLabel.setForeground(Color.BLUE);
        loseLabel = new JLabel("You Lose! :(");
        loseLabel.setFont(new Font("Arial", 0, 30));
        loseLabel.setForeground(Color.BLUE);
        frame.setSize(350, 600);
        frame.setTitle("Stacker");
        screen.setBackground(BACKGROUND);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        refreshTimer.start();
    }

    public void actionPerformed(ActionEvent e){
        if(grid.getWin()){
            screen.add(winLabel);
            frame.setVisible(true);
        }else if(grid.getLose()){
            screen.add(loseLabel);
            frame.setVisible(true);
        }
        grid.moveBlocks();
        screen.refreshBlocks();
        if(screen.getMakeNewLine()){
            screen.setMakeNewLineFalse();
            grid.newLine();
        }

    }
}
