import greenfoot.*;

/**
 * Write a description of class Cash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cash extends Actor
{
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {
            ((MyWorld)getWorld()).changeCash(1000);
        }
    }    
}
