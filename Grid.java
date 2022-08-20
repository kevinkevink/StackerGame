
public class Grid {
    private int rows = 12;
    private int cols = 7;
    private int activeBlocks = 3;
    private boolean movedBlocks = false;
    private Block[][] blockGrid = new Block[rows][cols];
    private boolean win = false;
    private boolean lose = false;

    public void startGame(){
        blockGrid[0][1] = new Block();
        blockGrid[0][2] = new Block();
        blockGrid[0][3] = new Block();
    }

    public boolean getWin(){
        return win;
    }

    public boolean getLose(){
        return lose;
    }

    public void newLine(){
        int highestRow = -1;
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(blockGrid[i][j] != null){
                    if(i > 0 && blockGrid[i - 1][j] == null) {
                        blockGrid[i][j] = null;
                        activeBlocks--;
                    }

                    if(i > highestRow){
                        highestRow = i;
                    }
                    if(blockGrid[i][j] != null)
                        blockGrid[i][j].setInactive();
                }
            }
        }
        if((highestRow == 4 && activeBlocks == 3) || (highestRow == 7 && activeBlocks == 2)){
            activeBlocks--;
        }
        if(highestRow != 11) {
            for(int i = 1; i <= activeBlocks; i++){
                blockGrid[highestRow + 1][i] = new Block();
            }
        }else{
            win = true;
        }
        if(activeBlocks == 0){
            lose = true;
        }
    }

    public void moveBlocks(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(blockGrid[i][j] != null && !movedBlocks && blockGrid[i][j].isActive()){
                        if(((j == cols - activeBlocks) && (blockGrid[i][j - 1] == null)) || (j == 0)){
                            for(int k = 0; k < activeBlocks; k++){
                                blockGrid[i][j + k].changeDirection();
                            }
                        }
                        if(blockGrid[i][j].getDirection().equals("right")) {
                            for(int k = 0; k < activeBlocks; k++){
                                blockGrid[i][j + activeBlocks - k] = blockGrid[i][j + activeBlocks - k - 1];
                                blockGrid[i][j + activeBlocks - k - 1] = null;
                            }
                            movedBlocks = true;
                        }else{
                            for(int k = 0; k < activeBlocks; k++){
                                blockGrid[i][j + k - 1] = blockGrid[i][j + k];
                                blockGrid[i][j + k] = null;
                            }
                            movedBlocks = true;
                        }
                }
            }
            if(movedBlocks){
                movedBlocks = false;
                break;
            }
        }
    }

    public Block[][] returnGrid(){
        return blockGrid;
    }

}

