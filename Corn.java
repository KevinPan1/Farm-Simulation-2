import greenfoot.*;

/**
 * Write a description of class Corn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Corn extends Crop
{
    private final static String NAME = "corn";
    private final static int IMAGES = 6; 
    
    public Corn(Farmland land){
        this.land = land;
    }
    
    public String getName(){
        return NAME;
    }
    
    public int getImages(){
        return IMAGES;
    }
}
