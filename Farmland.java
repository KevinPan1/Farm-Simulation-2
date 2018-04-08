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
    private boolean isWet = false;
    private int wetDuration = 1000;
    private int wetTimer = 0;
    private Crop plant;
    
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
        if(isWet&&wetTimer==0){
            isWet=false;
            setImage("drySoil.png");
        }
        if(isWet&&plantInWorld){
            plant.growCrop();
        }
        if(wetTimer>0){
            wetTimer--;
        }
    }
    
    public void removePlant(){
        plantInWorld=false;
    }
    
    public void water(){
        wetTimer=wetDuration;
        if(!isWet){
            isWet=true;
            setImage("wetSoil.png");
        }
    }
    
    public boolean hasPlant(){
        return plantInWorld;
    }
}
