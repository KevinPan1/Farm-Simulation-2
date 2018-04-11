import greenfoot.*;

/**
 * Cows wander around randomly
 * @author Kevin Pan, Haris Syed
 * @version April 2018
 */
public class Sheep extends Animal
{
    //used for animation
    private final static String name = "sheep";
    private final static int walkImages = 3;
    /**
     * @return sends the walking images
     */
    public int getWalkImages(){
        return walkImages;
    }
    
    /**
     * @return sends the name of the animal
     */
    public String getName(){
        return name;
    }
    
    public void harvest(){
        
    }
}
