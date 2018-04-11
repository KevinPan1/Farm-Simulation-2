import greenfoot.*;

/**
 * Cows produce milk and wander around randomly
 * @author Kevin Pan, Haris Syed
 * @version April 2018
 */
public class Cow extends Animal
{
    //used for animation
    private final static String name = "cow";
    private final static int walkImages = 3;
    private GreenfootSound cow = new GreenfootSound("cow.mp3");
    
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
     * the human milks the cow 
     */
    public void harvest(){
        cow.play();
        int random = 1+Greenfoot.getRandomNumber(3);
        for(int i=0;i<random;++i){
            ((MyWorld)getWorld()).addCropInventory("milk");
        }
    }
}
