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
    //used for animation
    private final static String name = "male";
    private final static int walkImages = 3;
    private final static int waterImages = 4;
    
    private int counter;
    private int waterCounter;
    private int cropCounter;
    private int seedCounter;
    private int sellCounter;
    private int homeCounter;
    private List<Actor> land;
    private List<Actor> crops;
    private List<Actor> seeds;
    private List<Actor> animals;
    private int landIndex=-1;
    private int cropIndex=-1;
    private int seedIndex=-1;
    private int sellIndex=-1;
    private int homeIndex=-1;
    private int animalIndex=-1;
    private int temp;
    //used for farming process
    private boolean isWatering;
    private boolean isCroping;
    private boolean isSeeding; 
    private boolean isSelling;
    private boolean isResting;
    private boolean isAnimaling;
    
    private boolean isIdle=true;
    private Actor target;
    
    public void act(){
        if(!isSelling&&sellIndex!=-1){
            if(isAt(((MyWorld)getWorld()).getMarket())){
                isSelling=true;
                temp=0;
            }else{
                goTo(((MyWorld)getWorld()).getMarket(),1);
            }
        }
        if(!isWatering&&landIndex!=-1){
            if(isAt(land.get(landIndex))){
                isWatering=true;
                temp=0;
            }
            else{
                goTo(land.get(landIndex),1);
            }
        }
        if(!isCroping&&cropIndex!=-1){
            if(isAt(crops.get(cropIndex))){
                isCroping=true;
            }else{
                goTo(crops.get(cropIndex),1);
            }
        }
        if(!isSeeding&&seedIndex!=-1){
            if(((MyWorld)getWorld()).getCurrentCash()<=500+Greenfoot.getRandomNumber(500)){
                seedIndex=-1;
                changeIdle(true);;
                ((MyWorld)getWorld()).increaseTasks();
                return;
            }
            if(isAt(seeds.get(seedIndex))){
                isSeeding=true;
            }else{
                goTo(seeds.get(seedIndex),1);
            }
        }
        if(!isAnimaling&&animalIndex!=-1){
            if(isAt(animals.get(animalIndex))){
                isAnimaling=true;
            }else{
                goTo(animals.get(animalIndex),2);
            }
        }
        if(isAnimaling){
            ((Animal)animals.get(animalIndex)).harvest();
            if(animalIndex==animals.size()-1){
                animalIndex=-1;
                changeIdle(true);
                isAnimaling=false;
                ((MyWorld)getWorld()).increaseTasks();
            }else{
                animalIndex++;
            }
        }
        if(isSelling){
            if(temp==100){
                temp=0;
                ((MyWorld)(getWorld())).sellProduce();
                sellIndex=-1;
                isSelling=false;
                changeIdle(true);;
                ((MyWorld)getWorld()).increaseTasks();
            }
            temp++;
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
                        changeIdle(true);;
                        ((MyWorld)getWorld()).increaseTasks();
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
                    changeIdle(true);;
                    ((MyWorld)getWorld()).increaseTasks();
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
                    changeIdle(true);;
                    ((MyWorld)getWorld()).increaseTasks();
                }else{
                    seedIndex++;
                }
            }
        }
        if(isResting){
            if(isAt(target)){
                isResting=false;
                changeIdle(true);;
                ((MyWorld)getWorld()).increaseTasks();
            }else{
                goTo(target,1);
            }
        }
    }
    
    //used to return walking images
    public int getWalkImages(){
        return walkImages;
    }
    
    public String getName(){
        return name;
    }
    
    public void placeFarmland(){
        getWorld().addObject(new Farmland(),getX(),getY());
    }
    
    public void collectAnimals(){
        int random =300+Greenfoot.getRandomNumber(450);
        animals=getObjectsInRange(random,Chicken.class);
        animals.addAll(getObjectsInRange(random,Cow.class));
        if(!animals.isEmpty()){
            animalIndex=0;
        }else{
            changeIdle(true);
            ((MyWorld)getWorld()).increaseTasks();
        }
    }
    
    //method for planting seeds
    public void plantSeeds(){
        seeds = getWorld().getObjects(Farmland.class);
        for (Iterator<Actor> iter = seeds.listIterator(); iter.hasNext();) {
            Actor a = iter.next();
            if (((Farmland)(a)).hasPlant()) {
                iter.remove();
            }
        }
        if(seeds.size()>0){
            seedIndex=0;
        }else{
            changeIdle(true);;
            ((MyWorld)getWorld()).increaseTasks();
        }
    }
    
    //method for watering crops
    public void waterCrops(){
        land = getWorld().getObjects(Farmland.class);
        for (Iterator<Actor> iter = land.listIterator(); iter.hasNext();) {
            Actor a = iter.next();
            if (!((Farmland)(a)).hasPlant()) {
                iter.remove();
            }
        }
        if(!land.isEmpty()){
            landIndex=0;
        }else{
            changeIdle(true);
            ((MyWorld)getWorld()).increaseTasks();
        }
    }
    
    //method for harvesting
    public void collectCrops(){
        crops = getWorld().getObjects(Crop.class);
        for (Iterator<Actor> iter = crops.listIterator(); iter.hasNext();) {
            Actor a = iter.next();
            if (!((Crop)(a)).isFullGrown()) {
                iter.remove();
            }
        }
        if(!crops.isEmpty())
            cropIndex=0;
        else{
            changeIdle(true);;
            ((MyWorld)getWorld()).increaseTasks();
        }
    }
    
    public void goHome(){
        isResting=true;
        target=((MyWorld)getWorld()).getHouse();
    }
    
    //method for selling
    public void sellCrops(){
        sellIndex=0;
    }
    
    public void changeIdle(boolean idleStatus){
        isIdle=idleStatus;
    }
    
    public boolean isIdle(){
        return isIdle;
    }
    
    public void harvest(){
        
    }
}