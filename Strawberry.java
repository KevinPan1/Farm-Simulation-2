import greenfoot.*;

/**
 * Write a description of class Strawberry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Strawberry extends Crop {
    private final static String NAME = "strawberry";
    private final static int IMAGES = 5;
    private final static int lifeSpan = 1000;
    
    public Strawberry(Farmland land){
        this.land = land;
    }
    
    public String getName(){
        return NAME;
    }
    
    public int getImages(){
        return IMAGES;
    }
}
