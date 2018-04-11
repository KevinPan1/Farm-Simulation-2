import greenfoot.*;

/**
 * The tiles used by the human to plant on
 * Changes between a dry and a wet state
 * 
 * @author Kevin Pan
 * @version April 10 2018
 */
public class Farmland extends Building
{
    private int type;
    private boolean plantInWorld = false;
    //starts off dry
    private boolean isWet = false;
    //duration of how long the tile will be wet
    private int wetDuration;
    //used to check 
    private int wetTimer = 0;
    //crops are declared
    private Crop plant;
    //crops are assigned a number 
    
    /**
     * Determains the duration of the wet tile
     */
    public Farmland(){
        wetDuration=1000+Greenfoot.getRandomNumber(1500);
    }
    
    /**
     * Determains the type of plant the seeds are for
     * 
     * @param type  The variable to determaine the seed
     */
    public void plant(int type){
        if(type==0){
            plant=new Corn(this);
        }else if(type==1){
            plant=new Tomato(this);
        }else if(type==2){
            plant=new Potato(this);
        }else if(type==3){
            plant=new Strawberry(this);
        }else if(type==4){
            plant=new Radish(this);
        }else if(type==5){
            plant=new Cucumber(this);
        }
        getWorld().addObject(plant,getX(),getY());
        plantInWorld=true;
    }
    
    /**
     * Checks to determain if the tile is wet or not and controlls the duration of the time its wet
     */
    public void act(){
        //if wet timer and tile is wet equals zero
        if(isWet&&wetTimer==0){
            //it is not wet and set soil to dry
            isWet=false;
            setImage("drySoil.png");
        }
        if(isWet&&plantInWorld){
            plant.growCrop();
        }
        if(wetTimer>0){
            //reduce wet timer if greater than 0
            wetTimer--;
        }
    }
    
    //method to remove plants
    /**
     * checks to remove plant
     */
    public void removePlant(){
        plantInWorld=false;
    }
    
    //method for watering
    /**
     * is called when the soil becomes wet
     */
    public void water(){
        wetTimer=wetDuration;
        if(!isWet){
            isWet=true;
            setImage("wetSoil.png");
        }
    }
    
    //to indicate if there is a plant on this tile
    /**
     * Indicates if theres a plant on this tile
     */
    public boolean hasPlant(){
        return plantInWorld;
    }
}
