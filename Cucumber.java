import greenfoot.*;

/**
 * Write a description of class Cucumber here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cucumber extends Crop
{
    private final static String NAME = "cucumber";
    private final static int IMAGES = 5; 
    
    public Cucumber(Farmland land){
        this.land = land;
    }
    
    public String getName(){
        return NAME;
    }
    
    public int getImages(){
        return IMAGES;
    }
}
