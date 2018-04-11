import greenfoot.*;

/**
 * The cash that the human starts off with
 * 
 * @author Brian Yip
 * @version April 2018
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
