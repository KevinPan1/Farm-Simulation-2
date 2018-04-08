import greenfoot.*;

/**
 * Write a description of class Farmland here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Crop extends Actor
{
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
        if(age>lifeSpan){
            setImage(getName()+"Rotten.png");
        }
        if(temp==getImages()&&!fullGrown){
            fullGrown=true;
        }
    }  
    
    protected abstract String getName();
    
    public boolean isFullGrown(){
        return fullGrown;
    }
    
    public void growCrop(){
        growth++;
        if(temp!=getImages()&&growth%growthRate==0){
            setImage(getName() + temp + ".png");
            temp++;
        }
    }
    
    public void collect(){
        ((MyWorld)getWorld()).addCropInventory(getName());
        land.removePlant();
        getWorld().removeObject(this);
    }
    
    protected abstract int getImages();
}
