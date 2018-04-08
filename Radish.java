import greenfoot.*;

/**
 * Write a description of class Strawberry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Radish extends Crop {
    private final static String NAME = "radish";
    private final static int IMAGES = 4;
    private final static int lifeSpan = 1000;
   
    public Radish(Farmland land){
        this.land = land;
    }
    
    public String getName(){
        return NAME;
    }
    
    public int getImages(){
        return IMAGES;
    }
}
