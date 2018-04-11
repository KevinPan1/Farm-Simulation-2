import greenfoot.*;

/**
 * potato planted by the human
 * 
 * @author Brian Yip and Xavier Law
 * @version April 2018
 */
public class Potato extends Crop {
    //4 total images, named potato
    private final static String NAME = "potato";
    private final static int IMAGES = 4;
    private final static int lifeSpan = 1000;
    
    //place on farmland
    /**
     * places the potato on the the farm tile
     * @param takes the farmland tile
     */
    public Potato(Farmland land){
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
