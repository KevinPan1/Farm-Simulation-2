import greenfoot.*;

/**
 * strawberry planted by the human
 * 
 * @author Brian Yip and Xavier Law
 * @version April 2018
 */
public class Strawberry extends Crop {
    //5 total images, named strawberry
    private final static String NAME = "strawberry";
    private final static int IMAGES = 5;
    private final static int lifeSpan = 1000;
    
    //place on farmland
    /**
     * places the strawberry on the the farm tile
     * @param takes the farmland tile
     */
    public Strawberry(Farmland land){
        this.land = land;
    }
    
    /**
     * @return sends the name of the class
     */
    public String getName(){
        return NAME;
    }
    
    /**
     * @return sends the image of this plant
     */
    public int getImages(){
        return IMAGES;
    }
}
