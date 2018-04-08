import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class heart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heart extends Actor
{
    /**
     * Act - do whatever the heart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int runcount=0;
    public void act() 
    {
        animation();
    }    
    private void animation()
    {
        setImage("heart" + (runcount)/5 + ".fw.png");
        if (runcount < 35)
        {
            runcount++;
        }
        else
        {
            getWorld().removeObject(this);
        }
    }
}
