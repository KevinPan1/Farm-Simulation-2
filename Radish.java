import greenfoot.*;

/**
 * radish planted by the human
 * 
 * @author Brian Yip and Xavier Law
 * @version April 2018
 */
public class Radish extends Crop {
    //4 total images, named radish
    private final static String NAME = "radish";
    private final static int IMAGES = 4;
    private final static int lifeSpan = 1000;
    
    //place on farmland
    /**
     * places the raddish on the the farm tile
     * @param takes the farmland tile
     */
    public Radish(Farmland land){
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
