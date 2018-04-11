import greenfoot.*;

/**
 * cucumber planted by the human
 * 
 * @author Brian Yip and Xavier Law
 * @version April 2018
 */
public class Cucumber extends Crop
{
    //5 total images, named cucumber
    private final static String NAME = "cucumber";
    private final static int IMAGES = 5; 
    
    //place on farmland
    /**
     * places the cucumber on the the farm tile
     * @param takes the farmland tile
     */
    public Cucumber(Farmland land){
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
