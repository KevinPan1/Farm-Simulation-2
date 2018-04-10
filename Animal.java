import greenfoot.*;

/**
 * Write a description of class Animal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Animal extends Actor
{
    protected int[][] delta = {{0,-1},{1,0},{0,1},{-1,0}}; // 0 -north, 1 - east, 2 - south, 3 - west 
    protected int counter=0;
    protected int temp;
    protected int lastDirection = 2; // maybe used to reset the position
    protected int lifeSpan;
    protected int age;
    protected int direction;
    
    public void act() 
    {
        if(Greenfoot.isKeyDown("up"))
            run(0,1);
        else if(Greenfoot.isKeyDown("right"))
            run(1,1);
        else if(Greenfoot.isKeyDown("down"))
            run(2,1);
        else if(Greenfoot.isKeyDown("left"))
            run(3,1);
    }
    
    protected void run(int direction,int speed){
        counter++;
        if(lastDirection!=direction)
            counter=0;
        if(counter%10==0){
            counter=0;
            setImage(getName() + "Walk" + direction + "." + temp + ".png");
            temp++;
            if(temp%getWalkImages()==0)
                temp=0;
        }
        setLocation(getX()+delta[direction][0]*speed,getY()+delta[direction][1]*speed);
        lastDirection = direction;
    }
    
    public abstract String getName();
    
    public abstract int getWalkImages();
    
    protected void goTo(Actor actor){
        if(this.getX()<actor.getX()){
            run(1,1);
            direction=1;
        }
        else if(this.getX()>actor.getX()){
            run(3,1);
            direction=3;
        }
        else if(this.getY()<actor.getY()){
            run(2,1);
            direction=2;
        }
        else if(this.getY()>actor.getY()){
            run(0,1);
            direction=0;
        }
    }
    
    protected boolean isAt(Actor actor){
        return (this.getX()==actor.getX()&&this.getY()==actor.getY());
    }
}
