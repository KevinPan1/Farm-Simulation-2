import greenfoot.*;
/**
 * A stationary explosion that dissappears after the animation ends
 * @author Haris Syed
 */
public class Explosion extends Actor
{
    private int counter;
    public Explosion()
    {
        Greenfoot.playSound("explosion.mp3"); // play an explosion sound
    }

    public void act() 
    {
        if(counter%5==0) // every five acts, change the image
        { 
            GreenfootImage image = new GreenfootImage("explosion " + (counter/5 + 1) + ".png");
            image.scale(image.getWidth() + 400, image.getHeight() + 400); // resize image 
            setImage(image);
        }
        counter++; 
        if(counter==75) // after 75 acts, remove this actor
        { 
            getWorld().removeObject(this);
        }
    }    
}
