import greenfoot.*;

/**
 * Write a description of class Cow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cow extends Animal
{
    private final static String name = "cow";
    private final static int walkImages = 3;
    
    public int getWalkImages(){
        return walkImages;
    }
    
    public String getName(){
        return name;
    }
}
