import greenfoot.*;

/**
 * Write a description of class Sheep here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sheep extends Animal
{
    //used for animation
    private final static String name = "sheep";
    private final static int walkImages = 3;
    public int getWalkImages(){
        return walkImages;
    }
    
    public String getName(){
        return name;
    }
}
