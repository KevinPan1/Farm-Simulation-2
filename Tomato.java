import greenfoot.*;

/**
 * Write a description of class Tomato here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tomato extends Crop
{
    private final static String NAME = "tomato";
    private final static int IMAGES = 5;
    
    public Tomato(Farmland land){
        this.land = land;
    }
    
    public String getName(){
        return NAME;
    }
    
    public int getImages(){
        return IMAGES;
    }
}