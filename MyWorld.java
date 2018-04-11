import greenfoot.*;
import java.util.*;
import java.awt.*;
/*
 * 
 * 
 * 
 * Sources used for Sprites:
 * https://www.spriters-resource.com/game_boy_advance/hmfomt/
 * https://www.spriters-resource.com/ds_dsi/hmdscute/
 * https://www.spriters-resource.com/ds_dsi/harvestmoon/
 * https://www.spriters-resource.com/snes/harvestmoon/
 * https://www.spriters-resource.com/game_boy_advance/mother3/sheet/87184/
 * https://pokemontilesetstudio.deviantart.com/art/Barn-174684174
 * https://theartbook35.deviantart.com/art/barn-designs-142403472
 * http://pixeljoint.com/pixelart/83298.htm 
 * http://herebemonsters.wikia.com/wiki/File:Raspberry-Bush-Sprite.png 
 * https://www.spriters-resource.com/pc_computer/mightnmag8/sheet/43041/ 
 * http://photobucket.com/gallery/user/xrpgmaker2k3/media/cGF0aDpTcHJpdGVzL2diX2x0dHBfZmVuY2UucG5n/?ref= 
 * http://ct.glos.ac.uk/students/amydilorenzo/2d-graphics/pond-sprite/ 
 */
public class MyWorld extends World
{
    private int cnt;
    
    private HashMap<String,Integer> inventory = new HashMap<String,Integer>();
    private HashMap<String,Integer> price = new HashMap<String,Integer>();
    
    private int currentCash;
    private int delta = 10;
    //country music
    GreenfootSound backgroundMusic = new GreenfootSound("countryMusic.mp3");
    
    //animal classes are declared
    private Human player = new Human();
    private Cow cow = new Cow();
    private Chicken chicken = new Chicken();
    private Sheep sheep = new Sheep();
    
    //arrays of farmland tiles and aesthetics declared
    private OakTree[] oakTree = new OakTree[1000];
    private Farmland[] farmland = new Farmland[1000];
    private Fence[] fence = new Fence[1000];
    
    //buildings are declared
    private House house = new House();
    private Barn barn = new Barn();
    private Coop coop = new Coop();
    private Silo silo = new Silo();
    
    //all other types of fences declared
    private Fence fence1 = new Fence(10);
    private Fence fence2 = new Fence(2);
    
    private Fence fence29 = new Fence(5);
    private Fence fence30 = new Fence(9);
    private Fence fence31 = new Fence(6);
    private Fence fence32 = new Fence(8);
    private Fence fence33 = new Fence(5);
    private Fence fence34 = new Fence(5);
    private Fence fence35 = new Fence(2);

    private Fence fence53 = new Fence(4);
    private Fence fence54 = new Fence(5);
    private Fence fence55 = new Fence(5);
    private Fence fence56 = new Fence(0);
    private Fence fence57 = new Fence(10);
    private Fence fence58 = new Fence(8);
    private Fence fence59 = new Fence(6);
    private Fence fence60 = new Fence(5);
    private Fence fence61 = new Fence(5);
    private Fence fence62 = new Fence(2); 
    
    private Fence fence72 = new Fence(4);
    private Fence fence73 = new Fence(5);
    private Fence fence74 = new Fence(5);
    private Fence fence75 = new Fence(0);
    private Fence fence76 = new Fence(10);
    
    //aesthetic are declared
    private Pond pond = new Pond();
    private AppleTree appleTree = new AppleTree();
    private BlossomTree blossomTree1 = new BlossomTree();
    private BlossomTree blossomTree2 = new BlossomTree();
    private FlowerTree flowerTree1 = new FlowerTree();
    private FlowerTree flowerTree2 = new FlowerTree();
    private PurpleTree purpleTree1 = new PurpleTree();
    private Boulder boulder1 = new Boulder();
    private Boulder boulder2 = new Boulder();
    private Boulder boulder3 = new Boulder();
    private Bushes bush1 = new Bushes();
    private Bushes bush2 = new Bushes();
    private Bushes bush3 = new Bushes();
    private Bushes bush4 = new Bushes();
    
    // the main background image
    private GreenfootImage bg;  
    // the 'darkness' image -- used to darken the main bg image
    private GreenfootImage dark; 
    private int dayTimer; // to track the time of day   
    private int timeRate = 40; // number of acts per hour (one hour is transition time
    private int day;
    
    //HUD is declared
    private InventoryBar bar = new InventoryBar();
    private InventoryInfo info = new InventoryInfo();
    private TradeBar tradeBar = new TradeBar();
    private TradeInfo tradeInfo = new TradeInfo();
    private CashBar cashBar = new CashBar();
    private CashInfo cashInfo = new CashInfo();
    private DayInfo dayInfo = new DayInfo();
    private DayBar dayBar = new DayBar();
    
    private Market market = new Market();
    
    private int task = 0;
    
    public MyWorld()
    {    
        super(960, 640, 1);
        
        dayTimer=timeRate*6; 
        
        //method to set volume of the music
        volume();
        //music plays in loop
        backgroundMusic.playLoop();
        
        // set main background image (scaled to window)
        GreenfootImage background = new GreenfootImage("sand2.jpg");
        background.scale(960, 640);
        setBackground(bg = new GreenfootImage(background));
        // create darkness image for day and night cycle
        background.fill();
        dark = background;
        
        //order for classes overlapping each other
        setPaintOrder(FlowerTree.class, BlossomTree.class, PurpleTree.class,Building.class,HUD.class,Human.class,Animal.class,Crop.class,Farmland.class);
        addObject(player, 400, 400);
        addObject(cow, 200, 200);
        addObject(sheep, 300,300);
        addObject(chicken, 500,500);
        
        //creates OakTrees for forest randomized
        for(int i=0;i<50;++i){
            oakTree[i]=new OakTree();
            addObject(oakTree[i],30+Greenfoot.getRandomNumber(250),470+Greenfoot.getRandomNumber(100));
        }
        
        //creates a total of 162 Farmland tiles
        for(int i=0;i<162;++i){
            farmland[i]=new Farmland();
        }
        
        //For loops for creating farmland tiles
        //i is used to create the total amount of sets in width
        for(int i=0;i<3;++i){
            //j is used to create the total amoint of sets in length
            for(int j=0;j<6;++j){
                //k creates the width of each individual set
                for(int k=0;k<3;++k){
                    /*l creates the length of each indvidual set
                     *adds how much space are in between each Farmland tile 
                     */
                    for(int l=0;l<3;++l){
                        addObject(farmland[i*54+j*9+k*3+l],120+j*100+l*20,180+i*80+k*20);
                    }
                }
            }
        }
        
        //creates fence type 5
        for(int i=2;i<29;++i){
            fence[i]=new Fence(5);
            addObject(fence[i],6,85+(i-2)*15);
        }
        
        //creates fence type 3
        for(int i=35;i<52;++i){
            fence[i]=new Fence(3);
            addObject(fence[i],101+14*(i-35),25);
        }
        
        //creates fence fence type 3 again but in a different part of the world
        for(int i=62;i<71;++i){
            fence[i]=new Fence(3);
            addObject(fence[i],506+14*(i-62),23);
        }
        
        //Objects of buildings 
        addObject(house,50,50);
        addObject(barn,700,50);
        addObject(coop,400,50);
        addObject(silo,453,40);
        addObject(market,845,440);
        
        //these types of fence only need to be added once
        addObject(fence1,20,70);
        addObject(fence2,7,70);
        
        /*individually added due to the use of multiple types of fences in one area
         *using a for loop here would only apply to small amounts of fences
         */
        addObject(fence30,8,480);
        addObject(fence31,85,70);
        addObject(fence32,73,70);
        addObject(fence33,85,55);
        addObject(fence34,85,40);
        addObject(fence35,86,25);
      
        addObject(fence53,339,25);
        addObject(fence54,339,40);
        addObject(fence55,339,55);
        addObject(fence56,340,70);
        addObject(fence57,353,70);
        addObject(fence58,475,70);
        addObject(fence59,490,70);
        addObject(fence60,490,54);
        addObject(fence61,490,39);
        addObject(fence62,491,23);
        
        addObject(fence72,632,23);
        addObject(fence73,632,39);
        addObject(fence74,632,54);
        addObject(fence75,633,70);
        addObject(fence76,648,70);
        
        //Aesthetics are added here
        addObject(flowerTree1,130,50);
        addObject(blossomTree1,210,50);
        addObject(purpleTree1, 290,50);
        addObject(flowerTree2,530,50);
        addObject(blossomTree2,600,50);
        addObject(boulder1,700,600);
        addObject(pond,850,300);
        //addObject(boulder2,880,80);
        addObject(boulder3,900,500);
        addObject(bush1,480,560);
        addObject(bush2,465,570);
        addObject(bush3,485,570);
        addObject(bush4,473,580);
        
        //set his inventory to zero
        inventory.put("tomato", 0);
        inventory.put("potato", 0);
        inventory.put("strawberry", 0);
        inventory.put("radish", 0);
        inventory.put("corn", 0);
        inventory.put("cucumber", 0);
        inventory.put("eggs",0);
        inventory.put("milk",0);
        
        //rndomizes the price of each item
        price.put("tomato", Greenfoot.getRandomNumber(350));
        price.put("strawberry", Greenfoot.getRandomNumber(350));
        price.put("radish", Greenfoot.getRandomNumber(350));
        price.put("corn", Greenfoot.getRandomNumber(350));
        price.put("potato", Greenfoot.getRandomNumber(350));
        price.put("cucumber", Greenfoot.getRandomNumber(350));
        price.put("eggs", Greenfoot.getRandomNumber(350));
        price.put("milk", Greenfoot.getRandomNumber(350));
        
        //Object of Hud are added
        addObject(bar,480,615);
        addObject(info,480,615);
        addObject(tradeBar,860,75);
        addObject(tradeInfo,860,75);
        addObject(cashBar,860,175);
        addObject(cashInfo,860,175);
        addObject(dayBar,890,220);
        addObject(dayInfo,890,220);
        
        //current cash will be set $1000
        currentCash = 2500 + Greenfoot.getRandomNumber(2000);
    }
    
    //crops are added into inventory when harvested
    public void addCropInventory(String crop){
        inventory.put(crop, inventory.get(crop)+1);
    }
    
    //price are randomly chosen for each item
    private void adjustPrices(){
        for (String key : price.keySet()) {
            price.put(key, price.get(key)+Greenfoot.getRandomNumber(delta*2+1)-delta);
            if(price.get(key)<0){
                price.put(key,0);
            }
        }
    }
    
    //returns the current amount of cash
    public int getCurrentCash(){
        return currentCash;
    }
    
    //change the amount of money
    public void changeCash(int delta){
        currentCash += delta;
        if(currentCash<0)
            currentCash=0;
    }
    
    //used to sell product
    public void sellProduce(){
        for(String key: inventory.keySet()){
            if(inventory.get(key)==0)
                continue;
            int amt = Greenfoot.getRandomNumber(inventory.get(key)+1);
            changeCash(amt*price.get(key));
            inventory.put(key,inventory.get(key)-amt);
        }
    }
    
    public Actor getMarket(){
        return market;
    }
    
    public Actor getHouse(){
        return house;
    }
    
    public void act()
    {
        cnt++;
        if(cnt%60==0){
            adjustPrices();
        }
        
        if(task==0&&player.isIdle()){
            player.changeIdle(false);
            player.plantSeeds();
        }else if(task==1&&player.isIdle()){
            player.changeIdle(false);
            player.waterCrops();
        }else if(task==2&&player.isIdle()){
            player.changeIdle(false);
            player.collectCrops();
        }else if(task==3&&player.isIdle()){
            player.changeIdle(false);
            player.sellCrops();
        }else if(task==4&&player.isIdle()){
            player.changeIdle(false);
            player.collectAnimals();
        }else if(task==5&&player.isIdle()){
            player.changeIdle(false);
            player.goHome();
        }else if(task==6&&player.isIdle()){
            dayTimer++;
            animateNight();
        }
        
        if(dayTimer==timeRate*6){
            task=0;
            dayTimer=0;
            day++;
            dayInfo.update(day);
            currentCash-=500;
        }
        info.update(inventory.get("corn"), inventory.get("cucumber"), inventory.get("potato"), inventory.get("strawberry"), inventory.get("tomato"), inventory.get("radish"), inventory.get("eggs"), inventory.get("milk"));
        tradeInfo.update(price.get("corn"), price.get("cucumber"), price.get("potato"), price.get("strawberry"), price.get("tomato"), price.get("radish"), price.get("eggs"), price.get("milk"));
        cashInfo.update(currentCash);
    }
    
    public void animateNight(){
        // check if transition hour
        setBackground(new GreenfootImage(bg)); 
        // adjust darkness
        if(dayTimer/timeRate==0)
            dark.setTransparency((int)((dayTimer*1.0/timeRate)*180));
        else if(dayTimer/timeRate==5){
            dark.setTransparency(180-(int)(((dayTimer*1.0-timeRate*5)/(timeRate))*180));
        }
        // add darkness to main background image
        getBackground().drawImage(dark, 0, 0);
    }
    
    public void volume()
    {
        //Method for controlling the volume
        backgroundMusic.setVolume(0);
    }
    
    public void increaseTasks(){
        task++;
    }
}

