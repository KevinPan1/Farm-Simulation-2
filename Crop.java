import greenfoot.*;

/**
 * Crops that are planted by the human
 * they grow and change state
 * they also rot at certain times
 * 
 * @author Kevin Pan
 * @version April 2018
 */
public abstract class Crop extends Actor
{
    //growth process of each crop
    protected Farmland land;
    protected int age;
    protected int lifeSpan;
    protected int growth;
    protected int growthRate;
    protected int temp;
    protected boolean rotten;
    protected boolean fullGrown;
   
    
    /**
     * constructor for the crops 
     */
    public Crop()
    {
        growthRate=200+Greenfoot.getRandomNumber(500);
        lifeSpan=1000+Greenfoot.getRandomNumber(50000);
    }
    
    /**
     * controlls the growth of the plant
     * determains if the plant is rotten of not
     */
    public void act() 
    {
        age++;
        //will go rotten if not harvested in time
        if(age>lifeSpan){
            setImage(getName()+"Rotten.png");
            rotten=true;
        }
        if(temp==getImages()&&!fullGrown){
            fullGrown=true;
        }
    }  
    
    /**
     * recived the subclass' name
     */
    protected abstract String getName();
    
    //to indicate fully grown
    /**
     * checks if the plant is fully grown
     */
    public boolean isFullGrown(){
        return fullGrown;
    }
    
    //method for growing crops
    /**
     * the growth for crops
     */
    public void growCrop(){
        growth++;
        if(!rotten&&temp!=getImages()&&growth%growthRate==0){
            setImage(getName() + temp + ".png");
            temp++;
        }
    }
    
    //method for collecting crops
    /**
     * method for collecting crops, removing them from the soil
     */
    public void collect(){
        //remove plants add to inventory
        if(!rotten){
            ((MyWorld)getWorld()).addCropInventory(getName());
        }
        land.removePlant();
        getWorld().removeObject(this);
    }
    
    /**
     * checks to see if the plant is rotten of not 
     */
    public void setRotten(){
        rotten=true;
        fullGrown=true;
        setImage(getName()+"Rotten.png");
    }
    
    /**
     * recives the images of the crops
     */
    protected abstract int getImages();
    
}
