import greenfoot.*;

/**
 * corn planted by the human
 * 
 * @author Brian Yip and Xavier Law
 * @version April 2018
 */
public class Corn extends Crop
{
    //6 total images, named corn
    private final static String NAME = "corn";
    private final static int IMAGES = 6; 
    
    //place on farmland
    /**
     * places the corn on the the farm tile
     * @param takes the farmland tile
     */
    public Corn(Farmland land){
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
