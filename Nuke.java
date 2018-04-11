import greenfoot.*;
import java.util.List;
/**
 * Write a description of class Nuke here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nuke extends Actor
{
    /**
     * Act - do whatever the Nuke wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {
            List<Actor> crops = getWorld().getObjects(Crop.class);
            for(Actor a : crops){
                ((Crop)a).setRotten();
            }
            getWorld().addObject(new Explosion(),300+Greenfoot.getRandomNumber(100),200+Greenfoot.getRandomNumber(100));
        }
    }    
}
