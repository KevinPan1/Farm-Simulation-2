import greenfoot.*;

/**
 * Write a description of class Farmland here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Farmland extends Building
{
    private int type;
    private boolean plantInWorld = false;
    //starts off dry
    private boolean isWet = false;
    //duration of how long the tile will be wet
    private int wetDuration = 1000;
    //used to check 
    private int wetTimer = 0;
    //crops are declared
    private Crop plant;
    //crops are assigned a number 
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
    public void removePlant(){
        plantInWorld=false;
    }
    
    //method for watering
    public void water(){
        wetTimer=wetDuration;
        if(!isWet){
            isWet=true;
            setImage("wetSoil.png");
        }
    }
    
    //to indicate if there is a plant on this tile
    public boolean hasPlant(){
        return plantInWorld;
    }
}
