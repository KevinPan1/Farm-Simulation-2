import greenfoot.*;
import java.util.*;
import java.awt.*;

public class MyWorld extends World
{
    private int cnt;
    KPWidget fps = new KPWidget(150,255,Color.BLUE,new Color(0,0,0,0),true);
    
    private HashMap<String,Integer> inventory = new HashMap<String,Integer>();
    
    private Human player = new Human();
    private Cow cow = new Cow();
    private Chicken chicken = new Chicken();
    private Sheep sheep = new Sheep();
    private Farmland farmland0 = new Farmland(0);
    private Farmland farmland1 = new Farmland(1);
    private Farmland farmland2 = new Farmland(2);
    private Farmland farmland3 = new Farmland(3);
    private Farmland farmland4 = new Farmland(4);
    private Farmland farmland5 = new Farmland(5);
    
    private House house = new House();
    private Barn barn = new Barn();
    private Coop coop = new Coop();
    private Silo silo = new Silo();
    private Pond pond = new Pond();
    private AppleTree appleTree = new AppleTree();
    private OakTree oakTree0 = new OakTree();
    private OakTree oakTree1 = new OakTree();
    private OakTree oakTree2 = new OakTree();
    private OakTree oakTree3 = new OakTree();
    private OakTree oakTree4 = new OakTree();
    private OakTree oakTree5 = new OakTree();
    private OakTree oakTree6 = new OakTree();
    private OakTree oakTree7 = new OakTree();
    private OakTree oakTree8 = new OakTree();
    private OakTree oakTree9 = new OakTree();
    private OakTree oakTree10 = new OakTree();
    private OakTree oakTree11 = new OakTree();
    private OakTree oakTree12 = new OakTree();
    private OakTree oakTree13 = new OakTree();
    private OakTree oakTree14 = new OakTree();
    private OakTree oakTree15 = new OakTree();
    private OakTree oakTree16 = new OakTree();
    private OakTree oakTree17 = new OakTree();
    private OakTree oakTree18 = new OakTree();
    private OakTree oakTree19 = new OakTree();
    private OakTree oakTree20 = new OakTree();
    private OakTree oakTree21 = new OakTree();
    private OakTree oakTree22 = new OakTree();
    private OakTree oakTree23 = new OakTree();
    private OakTree oakTree24 = new OakTree();
    private Fence10 fence1 = new Fence10();
    private Fence2 fence2 = new Fence2();
    private Fence5 fence3 = new Fence5();
    private Fence5 fence4 = new Fence5();
    private Fence5 fence5 = new Fence5();
    private Fence5 fence6 = new Fence5();
    private Fence5 fence7 = new Fence5();
    private Fence5 fence8 = new Fence5();
    private Fence5 fence9 = new Fence5();
    private Fence5 fence10 = new Fence5();
    private Fence5 fence11 = new Fence5();
    private Fence5 fence12 = new Fence5();
    private Fence5 fence13 = new Fence5();
    private Fence5 fence14 = new Fence5();
    private Fence5 fence15 = new Fence5();
    private Fence5 fence16 = new Fence5();
    private Fence5 fence17 = new Fence5();
    private Fence5 fence18 = new Fence5();
    private Fence5 fence19 = new Fence5();
    private Fence5 fence20 = new Fence5();
    private Fence5 fence21 = new Fence5();
    private Fence5 fence22 = new Fence5();
    private Fence5 fence23 = new Fence5();
    private Fence5 fence24 = new Fence5();
    private Fence5 fence25 = new Fence5();
    private Fence5 fence26 = new Fence5();
    private Fence5 fence27 = new Fence5();
    private Fence5 fence28 = new Fence5();
    private Fence5 fence29 = new Fence5();
    private Fence9 fence30 = new Fence9();
    private Fence6 fence31 = new Fence6();
    private Fence8 fence32 = new Fence8();
    private Fence5 fence33 = new Fence5();
    private Fence5 fence34 = new Fence5();
    private Fence2 fence35 = new Fence2();
    private Fence3 fence36 = new Fence3();
    private Fence3 fence37 = new Fence3();
    private Fence3 fence38 = new Fence3();
    private Fence3 fence39 = new Fence3();
    private Fence3 fence40 = new Fence3();
    private Fence3 fence41 = new Fence3();
    private Fence3 fence42 = new Fence3();
    private Fence3 fence43 = new Fence3();
    private Fence3 fence44 = new Fence3();
    private Fence3 fence45 = new Fence3();
    private Fence3 fence46 = new Fence3();
    private Fence3 fence47 = new Fence3();
    private Fence3 fence48 = new Fence3();
    private Fence3 fence49 = new Fence3();
    private Fence3 fence50 = new Fence3();
    private Fence3 fence51 = new Fence3();
    private Fence3 fence52 = new Fence3();
    private Fence4 fence53 = new Fence4();
    private Fence5 fence54 = new Fence5();
    private Fence5 fence55 = new Fence5();
    private Fence0 fence56 = new Fence0();
    private Fence10 fence57 = new Fence10();
    private Fence8 fence58 = new Fence8();
    private Fence6 fence59 = new Fence6();
    private Fence5 fence60 = new Fence5();
    private Fence5 fence61 = new Fence5();
    private Fence2 fence62 = new Fence2(); 
    private Fence3 fence63 = new Fence3();
    private Fence3 fence64 = new Fence3();
    private Fence3 fence65 = new Fence3();
    private Fence3 fence66 = new Fence3();
    private Fence3 fence67 = new Fence3();
    private Fence3 fence68 = new Fence3();
    private Fence3 fence69 = new Fence3();
    private Fence3 fence70 = new Fence3();
    private Fence3 fence71 = new Fence3();
    private Fence4 fence72 = new Fence4();
    private Fence5 fence73 = new Fence5();
    private Fence5 fence74 = new Fence5();
    private Fence0 fence75 = new Fence0();
    private Fence10 fence76 = new Fence10();
    
    private GreenfootImage bg;  // the main background image
    private GreenfootImage dark; // the 'darkness' image -- used to darken the main bg image
    private int dayTimer; // to track the time of day
    private int timeRate = 40; // number of acts per hour (one hour is transition time
    
    
    public MyWorld()
    {    
        super(960, 640, 1); 
        
        addObject(fps,100,100);
        
        // set main background image (scaled to window)
        GreenfootImage background = new GreenfootImage("sand2.jpg");
        background.scale(960, 640);
        setBackground(bg = new GreenfootImage(background));
        // create darkness image
        background.fill();
        dark = background;
        
        setPaintOrder(Animal.class,Crop.class,Farmland.class);
        addObject(player, 400, 400);
        addObject(cow, 200, 200);
        addObject(sheep, 300,300);
        addObject(chicken, 500,500);
        addObject(farmland0,800,400);
        addObject(farmland1,800,420);
        addObject(farmland2,800,440);
        addObject(farmland3,800,460);
        addObject(farmland4,800,480);
        addObject(farmland5,800,500);
        
        
        addObject(house,50,50);
        addObject(barn,700,50);
        addObject(coop,400,50);
        addObject(silo,453,40);
        addObject(pond,850,300); 
        addObject(appleTree,820,180);
        addObject(oakTree0,30,500);
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
        addObject(oakTree24,280,615);
        addObject(fence1,20,70);
        addObject(fence2,7,70);
        addObject(fence3,6,85);
        addObject(fence4,6,100);
        addObject(fence5,6,115);
        addObject(fence6,6,130);
        addObject(fence7,6,145);
        addObject(fence8,6,160);
        addObject(fence9,6,175);
        addObject(fence10,6,190);
        addObject(fence11,6,205);
        addObject(fence12,6,220);
        addObject(fence13,6,235);
        addObject(fence14,6,250);
        addObject(fence15,6,265);
        addObject(fence16,6,280);
        addObject(fence17,6,295);
        addObject(fence18,6,310);
        addObject(fence19,6,315);
        addObject(fence20,6,330);
        addObject(fence21,6,345);
        addObject(fence22,6,360);
        addObject(fence23,6,375);
        addObject(fence24,6,390);
        addObject(fence25,6,405);
        addObject(fence26,6,420);
        addObject(fence27,6,435);
        addObject(fence28,6,450);
        addObject(fence29,6,465);
        addObject(fence30,8,480);
        addObject(fence31,85,70);
        addObject(fence32,73,70);
        addObject(fence33,85,55);
        addObject(fence34,85,40);
        addObject(fence35,86,25);
        addObject(fence36,101,25);
        addObject(fence37,115,25);
        addObject(fence38,129,25);
        addObject(fence39,143,25);
        addObject(fence40,157,25);
        addObject(fence41,171,25);
        addObject(fence42,185,25);
        addObject(fence43,199,25);
        addObject(fence44,213,25);
        addObject(fence45,227,25);
        addObject(fence46,241,25);
        addObject(fence47,255,25);
        addObject(fence48,269,25);
        addObject(fence49,283,25);
        addObject(fence50,297,25);
        addObject(fence51,311,25);
        addObject(fence52,325,25);
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
        addObject(fence63,506,23);
        addObject(fence64,520,23);
        addObject(fence65,534,23);
        addObject(fence66,548,23);
        addObject(fence67,562,23);
        addObject(fence68,576,23);
        addObject(fence69,590,23);
        addObject(fence70,604,23);
        addObject(fence71,618,23);
        addObject(fence72,632,23);
        addObject(fence73,632,39);
        addObject(fence74,632,54);
        addObject(fence75,633,70);
        addObject(fence76,648,70);
        
        inventory.put("tomato", 0);
        inventory.put("potato", 0);
        inventory.put("strawberry", 0);
        inventory.put("radish", 0);
        inventory.put("corn", 0);
        inventory.put("cucumber", 0);
    }
    
    public void addCropInventory(String crop){
        inventory.put(crop, inventory.get(crop)+1);
    }
    
    public void act()
    {
        cnt++;
        if(cnt%5==0){
            fps.update(cnt,50);
        }
        
        dayTimer = (dayTimer+1)%(24*timeRate); // next moment in time
        boolean afterdusk = dayTimer < 12*timeRate; // determine day or night time
        if ((dayTimer/timeRate)%12 == 11) // check if transition hour
        {
            setBackground(new GreenfootImage(bg)); // set main background image
            int minute = 60*(dayTimer%timeRate)/timeRate; // determine minute in transition hour
            dark.setTransparency(afterdusk ? 3*minute : 180-3*minute); // adjust darkness
            getBackground().drawImage(dark, 0, 0); // add darkness to main background image
        }
    }
}

