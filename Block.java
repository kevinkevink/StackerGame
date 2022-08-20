public class Block {
    private boolean active;
    private String direction;

    public Block(){
        active = true;
        direction = "right";
    }

    public void setInactive(){
        active = false;
    }

    public boolean isActive(){
        return active;
    }

    public void changeDirection(){
        if(direction.equals("right")){
            direction = "left";
        }else{
            direction = "right";
        }
    }

    public String getDirection(){
        return direction;
    }

}
