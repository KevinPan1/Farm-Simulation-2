    import greenfoot.*;

/**
 * Chickens produce eggs and wander around randomly
 * @author Kevin Pan, Haris Syed
 * @version April 2018
 */
public class Chicken extends Animal
{
    //used for animation
    private final static String name = "chicken";
    private final static int walkImages = 4;
    private GreenfootSound chicken = new GreenfootSound("chicken.mp3");
    
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
    
    /**
     * the human collects the chicken's egg
     */
    public void harvest(){
        chicken.play();
        int random = 1+Greenfoot.getRandomNumber(3);
        for(int i=0;i<random;++i){
            ((MyWorld)getWorld()).addCropInventory("eggs");
        }
    }
}
