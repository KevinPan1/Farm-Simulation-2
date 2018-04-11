import greenfoot.*;
import java.util.List;
/**
 * A stationary explosion that dissappears after the animation ends
 * The Crops become rotten
 * 
 * @author Haris Syed
 * @version April 2018
 */
public class Nuke extends Actor
{
    
    /**
     * when theis button is clicked, the plants become rotten
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
