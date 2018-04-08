import greenfoot.*;
import java.util.*;
import java.awt.*;

public class MyWorld extends World
{
    private int cnt;
    KPWidget fps = new KPWidget(150,255,Color.BLUE,new Color(0,0,0,0),true);
    
    private HashMap<String,Integer> inventory = new HashMap<String,Integer>();
    private HashMap<String,Integer> price = new HashMap<String,Integer>();
    private int delta = 10;
    
    private Human player = new Human();
    private Cow cow = new Cow();
    private Chicken chicken = new Chicken();
    private Sheep sheep = new Sheep();
    
    private OakTree[] oakTree = new OakTree[1000];
    private Farmland[] farmland = new Farmland[1000];
    private Fence[] fence = new Fence[1000];
    private Pond pond = new Pond();
    
    private House house = new House();
    private Barn barn = new Barn();
    private Coop coop = new Coop();
    private Silo silo = new Silo();
    
    private AppleTree appleTree = new AppleTree();
    
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
    GreenfootSound backgroundMusic = new GreenfootSound("countryMusic.mp3");
    
    private GreenfootImage bg;  // the main background image
    private GreenfootImage dark; // the 'darkness' image -- used to darken the main bg image
    private int dayTimer; // to track the time of day
    private int timeRate = 40; // number of acts per hour (one hour is transition time
    
    private InfoBar info = new InfoBar();
    private Bar bar = new Bar();
    private TradeBar tradeBar = new TradeBar();
    private TradeInfo tradeInfo = new TradeInfo();
    
    public MyWorld()
    {    
        super(960, 640, 1); 
        
        addObject(fps,800,500);
        
        // set main background image (scaled to window)
        GreenfootImage background = new GreenfootImage("sand2.jpg");
        background.scale(960, 640);
        setBackground(bg = new GreenfootImage(background));
        // create darkness image
        background.fill();
        dark = background;
        
        setPaintOrder(InfoBar.class,Bar.class,Animal.class,Crop.class,Farmland.class);
        addObject(player, 400, 400);
        addObject(cow, 200, 200);
        addObject(sheep, 300,300);
        addObject(chicken, 500,500);
        
        for(int i=0;i<50;++i){
            oakTree[i]=new OakTree();
            addObject(oakTree[i],30+Greenfoot.getRandomNumber(250),470+Greenfoot.getRandomNumber(100));
        }
        
        for(int i=0;i<162;++i){
            farmland[i]=new Farmland();
        }
        
        for(int i=0;i<3;++i){
            for(int j=0;j<6;++j){
                for(int k=0;k<3;++k){
                    for(int l=0;l<3;++l){
                        addObject(farmland[i*54+j*9+k*3+l],120+j*100+l*20,180+i*80+k*20);
                    }
                }
            }
        }
        
        for(int i=2;i<29;++i){
            fence[i]=new Fence(5);
            addObject(fence[i],6,85+(i-2)*15);
        }
        
        for(int i=35;i<52;++i){
            fence[i]=new Fence(3);
            addObject(fence[i],101+14*(i-35),25);
        }
        
        for(int i=62;i<71;++i){
            fence[i]=new Fence(3);
            addObject(fence[i],506+14*(i-62),23);
        }
        
        addObject(house,50,50);
        addObject(barn,700,50);
        addObject(coop,400,50);
        addObject(silo,453,40);
        addObject(pond,850,300); 
        //addObject(appleTree,820,180);
        /*addObject(oakTree0,30,500);
        addObject(oakTree1,60,497);
        addObject(oakTree2,90,490);
        addObject(oakTree3,120,500);
        addObject(oakTree4,150,505);
        addObject(oakTree5,185,520);
        addObject(oakTree6,220,540);
        addObject(oakTree7,265,560);
        addObject(oakTree8,45,540);
        addObject(oakTree9,88,530);
        addObject(oakTree10,130,550);
        addObject(oakTree11,160,565);
        addObject(oakTree12,190,550);
        addObject(oakTree13,224,570);
        addObject(oakTree14,248,600);
        addObject(oakTree15,25,570);
        addObject(oakTree16,68,560);
        addObject(oakTree17,97,580);
        addObject(oakTree18,15,610);
        addObject(oakTree19,60,615);
        addObject(oakTree20,110,610);
        addObject(oakTree21,140,590);
        addObject(oakTree22,170,605);
        addObject(oakTree23,200,600);
        addObject(oakTree24,280,615);*/
        addObject(fence1,20,70);
        addObject(fence2,7,70);
        
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
        
        addObject(flowerTree1,130,50);
        addObject(blossomTree1,210,50);
        addObject(purpleTree1, 290,50);
        addObject(flowerTree2,530,50);
        addObject(blossomTree2,600,50);
        addObject(boulder1,700,600);
        //addObject(boulder2,880,80);
        addObject(boulder3,900,500);
        addObject(bush1,480,560);
        addObject(bush2,465,570);
        addObject(bush3,485,570);
        addObject(bush4,473,580);
        
        inventory.put("tomato", 0);
        inventory.put("potato", 0);
        inventory.put("strawberry", 0);
        inventory.put("radish", 0);
        inventory.put("corn", 0);
        inventory.put("cucumber", 0);
        
        price.put("tomato", Greenfoot.getRandomNumber(350));
        price.put("strawberry", Greenfoot.getRandomNumber(350));
        price.put("radish", Greenfoot.getRandomNumber(350));
        price.put("corn", Greenfoot.getRandomNumber(350));
        price.put("potato", Greenfoot.getRandomNumber(350));
        price.put("cucumber", Greenfoot.getRandomNumber(350));

        addObject(info,480,615);
        addObject(bar,480,615);
        addObject(tradeBar,860,75);
        addObject(tradeInfo,860,75);
    }
    
    public void addCropInventory(String crop){
        inventory.put(crop, inventory.get(crop)+1);
    }
    
    private void adjustPrices(){
        for (String key : price.keySet()) {
            price.put(key, price.get(key)+Greenfoot.getRandomNumber(delta*2+1)-delta);
            if(price.get(key)==0){
                price.put(key,0);
            }
        }
    }
    
    public void act()
    {
        cnt++;
        if(cnt%5==0){
            fps.update(cnt,50);
        }
        if(cnt%60==0){
            adjustPrices();
        }
        info.update(inventory.get("corn"), inventory.get("cucumber"), inventory.get("potato"), inventory.get("strawberry"), inventory.get("tomato"), inventory.get("radish"));
        tradeInfo.update(price.get("corn"), price.get("cucumber"), price.get("potato"), price.get("strawberry"), price.get("tomato"), price.get("radish"));
        /*dayTimer = (dayTimer+1)%(24*timeRate); // next moment in time
        boolean afterdusk = dayTimer < 12*timeRate; // determine day or night time
        if ((dayTimer/timeRate)%12 == 11) // check if transition hour
        {
            setBackground(new GreenfootImage(bg)); // set main background image
            int minute = 60*(dayTimer%timeRate)/timeRate; // determine minute in transition hour
            dark.setTransparency(afterdusk ? 3*minute : 180-3*minute); // adjust darkness
            getBackground().drawImage(dark, 0, 0); // add darkness to main background image
        }*/
    }
    
    public void volume()
    {
        //Method for controlling the volume
        backgroundMusic.setVolume(25);
    }
}

