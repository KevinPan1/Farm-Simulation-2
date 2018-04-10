import greenfoot.*;

/**
 * Write a description of class Corn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Corn extends Crop
{
    //6 total images, named corn
    private final static String NAME = "corn";
    private final static int IMAGES = 6; 
    
    //place on farmland
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
