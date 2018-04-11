import greenfoot.*;

/**
 * Abstract class created for animal classes to inherit.
 * mainly used for creating animations.
 *
 * @author Kevin Pan Haris Syed
 * @version April 2018
 */

public abstract class Animal extends Actor
{
    protected int[][] delta = {{0,-1},{1,0},{0,1},{-1,0}}; 
    protected int counter=0;
    protected int temp;
    protected int lastDirection = 2; // maybe used to reset the position
    protected int lifeSpan;
    protected int age;
    protected int direction=0;
    
    public void act(){
        int random = Greenfoot.getRandomNumber(30);
        if(random==0){
            int random2=Greenfoot.getRandomNumber(4);
            direction=random2;
        }
        random = Greenfoot.getRandomNumber(60);
        if(random!=60)
            run(direction,1);
    }
    
    //running along with animations
    /**
 	* Method used for creating the name of the various pictures added in the image file for animations
 	*
 	* @param direction  the direction is declared for subclasses to fill in
 	* @param speed  	declared for the subclasses to fill in
 	*/
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
    
     /**
 	* created for subclasses to get name
 	*/
    public abstract String getName();
    
    /**
 	* created for subclasses to obtain their walking images
 	*/
    public abstract int getWalkImages();
    
    /**
 	* Method for farmer is declared
 	*/
    public abstract void harvest();
    
    //setting directions
    /**
 	* Method for setting directions
 	*
 	* @param actor   used to get xy coordinates
 	* @param speed   set the speed for each direction
 	*/
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
    
    /**
 	* used for location tracking
 	*
 	* @param actor	used to obtain xy coordinates
 	* @return boolean return location, used to see if this actor is at a specific spot
 	*/
    protected boolean isAt(Actor actor){
        return (this.getX()==actor.getX()&&this.getY()==actor.getY());
    }
}
