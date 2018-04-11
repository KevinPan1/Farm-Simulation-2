import greenfoot.*;

/**
 * Write a description of class Farmland here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
   
    public Crop(){
        growthRate=200+Greenfoot.getRandomNumber(500);
        lifeSpan=1000+Greenfoot.getRandomNumber(20000);
    }
    
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
    
    protected abstract String getName();
    
    //to indicate fully grown
    public boolean isFullGrown(){
        return fullGrown;
    }
    
    //method for growing crops
    public void growCrop(){
        growth++;
        if(temp!=getImages()&&growth%growthRate==0){
            setImage(getName() + temp + ".png");
            temp++;
        }
    }
    
    //method for collecting crops
    public void collect(){
        //remove plants add to inventory
        if(!rotten){
            ((MyWorld)getWorld()).addCropInventory(getName());
        }
        land.removePlant();
        getWorld().removeObject(this);
    }
    
    protected abstract int getImages();
}
