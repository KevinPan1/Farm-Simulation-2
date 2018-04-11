import greenfoot.*;

/**
 * tomato planted by the human
 * 
 * @author Brian Yip and Xavier Law
 * @version April 2018
 */
public class Tomato extends Crop
{
    //6 total images, named tomato
    private final static String NAME = "tomato";
    private final static int IMAGES = 6;
    
    //place on farmland
    /**
     * places the tomato on the the farm tile
     * @param takes the farmland tile
     */
    public Tomato(Farmland land){
        this.land = land;
    }
    
    /**
     * @return sends the name of the class
     */public String getName(){
        return NAME;
    }
    
    /**
     * @return sends the image of this plant
     */
    public int getImages(){
        return IMAGES;
    }
}