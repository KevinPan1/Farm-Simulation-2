import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Human here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Human extends Animal
{
    private final static String name = "male";
    private final static int walkImages = 3;
    private final static int waterImages = 4;
    private int counter;
    private int waterCounter;
    private int cropCounter;
    private int seedCounter;
    private int direction;
    private List<Actor> land;
    private List<Actor> crops;
    private List<Actor> seeds;
    private int landIndex=-1;
    private int cropIndex=-1;
    private int seedIndex=-1;
    private int temp;
    private boolean isWatering;
    private boolean isCroping;
    private boolean isSeeding; 
    
    public void act(){
        if(Greenfoot.isKeyDown("up"))
            run(0,1);
        else if(Greenfoot.isKeyDown("right"))
            run(1,1);
        else if(Greenfoot.isKeyDown("down"))
            run(2,1);
        else if(Greenfoot.isKeyDown("left"))
            run(3,1);        
        if(counter>0)
            counter--;
        if(counter==0&&Greenfoot.isKeyDown("u")){
            counter=100;
            placeFarmland();
        }
        if(!isWatering&&counter==0&&Greenfoot.isKeyDown("o")){
            counter=100;
            waterCrops();
        }
        if(!isCroping&&counter==0&&Greenfoot.isKeyDown("p")){
            counter=100;
            collectCrops();
        }
        if(!isSeeding&&counter==0&&Greenfoot.isKeyDown("i")){
            counter=100;
            plantSeeds();
        }
        if(!isWatering&&landIndex!=-1){
            if(intersects(land.get(landIndex))){
                isWatering=true;
                temp=0;
            }
            else{
                goTo(land.get(landIndex));
            }
        }
        if(!isCroping&&cropIndex!=-1){
            if(intersects(crops.get(cropIndex))){
                isCroping=true;
            }else{
                goTo(crops.get(cropIndex));
            }
        }
        if(!isSeeding&&seedIndex!=-1){
            if(((MyWorld)getWorld()).getCurrentCash()<=0){
                seedIndex=-1;
                return;
            }
            if(intersects(seeds.get(seedIndex))){
                isSeeding=true;
            }else{
                goTo(seeds.get(seedIndex));
            }
        }
        if(isWatering){
            if(waterCounter%10==0){
                waterCounter=0;
                if(temp==waterImages){
                    isWatering=false;
                    ((Farmland)land.get(landIndex)).water();
                    if(landIndex==land.size()-1){
                        setImage("maleWalk"+direction+".0.png");
                        landIndex=-1;
                    }else{
                        landIndex++;
                    }
                    return;
                }
                setImage("watering"+direction+"."+temp+".png");
                temp++;
            }
            waterCounter++;
        }
        if(isCroping){
            cropCounter++;
            if(cropCounter%10==0){
                cropCounter=0;
                isCroping=false;
                ((Crop)crops.get(cropIndex)).collect();
                if(cropIndex==crops.size()-1){
                    cropIndex=-1;
                }else{
                    cropIndex++;
                }
            }
        }
        if(isSeeding){
            seedCounter++;
            if(seedCounter%10==0){
                seedCounter=0;
                isSeeding=false;
                ((MyWorld)getWorld()).changeCash(-1*(25+Greenfoot.getRandomNumber(150)));
                ((Farmland)seeds.get(seedIndex)).plant(Greenfoot.getRandomNumber(6));
                if(seedIndex==seeds.size()-1){
                    seedIndex=-1;
                }else{
                    seedIndex++;
                }
            }
        }
    }
    
    public int getWalkImages(){
        return walkImages;
    }
    
    public String getName(){
        return name;
    }
    
    public void placeFarmland(){
        getWorld().addObject(new Farmland(),getX(),getY());
    }
    
    public void plantSeeds(){
        seeds = getWorld().getObjects(Farmland.class);
        for (Iterator<Actor> iter = seeds.listIterator(); iter.hasNext();) {
            Actor a = iter.next();
            if (((Farmland)(a)).hasPlant()) {
                iter.remove();
            }
        }
        if(seeds.size()>0)
            seedIndex=0;
    }
    
    public void waterCrops(){
        land = getWorld().getObjects(Farmland.class);
        landIndex=0;
    }
    
    public void collectCrops(){
        crops = getWorld().getObjects(Crop.class);
        for (Iterator<Actor> iter = crops.listIterator(); iter.hasNext();) {
            Actor a = iter.next();
            if (!((Crop)(a)).isFullGrown()) {
                iter.remove();
            }
        }
        if(crops.size()>0)
            cropIndex=0;
    }
    
    public void sellCrops(){
        
    }
    
    private void goTo(Actor actor){
        if(this.getX()<actor.getX()){
            run(1,1);
            direction=1;
        }
        else if(this.getX()>actor.getX()){
            run(3,1);
            direction=3;
        }
        else if(this.getY()<actor.getY()){
            run(2,1);
            direction=2;
        }
        else if(this.getY()>actor.getY()){
            run(0,1);
            direction=0;
        }
    }
}