import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StackerImage extends JPanel implements KeyListener {

    private boolean makeNewLine = false;
    private Block[][] grid;

    public StackerImage(Block[][] grid){
        this.grid = grid;
        setOpaque(true);
        addKeyListener(this);
        setFocusable(true);

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] != null){
                    g.setColor(Color.WHITE);
                    g.fillRect( j * 50, 525 - i * 50, 50, 50);
                    g.setColor(Color.RED);
                    g.fillRect( j * 50 + 5, 530 - i * 50, 40, 40);
                }
            }
        }
    }
    public void keyTyped(KeyEvent e)
    {
    }

    public void keyReleased(KeyEvent e)
    {
    }

    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_SPACE){
            makeNewLine = true;
        }
    }

    public boolean getMakeNewLine(){
        return makeNewLine;
    }

    public void setMakeNewLineFalse(){
        makeNewLine = false;
    }

    public void refreshBlocks() {
        repaint();
    }
}
