import greenfoot.*;

/**
 * Write a description of class Chicken here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chicken extends Animal
{
    //used for animation
    private final static String name = "chicken";
    private final static int walkImages = 4;
    
    public int getWalkImages(){
        return walkImages;
    }
    
    public String getName(){
        return name;
    }
    
    public void harvest(){
        int random = 1+Greenfoot.getRandomNumber(3);
        for(int i=0;i<random;++i){
            ((MyWorld)getWorld()).addCropInventory("eggs");
        }
    }
}
