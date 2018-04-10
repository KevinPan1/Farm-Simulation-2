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
    protected int animation;
    protected int lifeSpan = 1000;
    protected int growth;
    protected int growthRate = 50;
    protected int temp;
    protected boolean fullGrown;
    
    public void act() 
    {
        //age++;
        //will go rotten if not harvested in time
        if(age>lifeSpan){
            setImage(getName()+"Rotten.png");
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
        ((MyWorld)getWorld()).addCropInventory(getName());
        land.removePlant();
        getWorld().removeObject(this);
    }
    
    protected abstract int getImages();
}
