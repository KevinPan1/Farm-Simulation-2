import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color; // Need Color and Font for drawing ScoreBar
import java.awt.Font;

public class InventoryInfo extends HUD
{
   private GreenfootImage image = new GreenfootImage(960,50);
   private String space = "        ";
   private String space1 = "         ";
   
   public InventoryInfo(){
       image.setColor(textColor);
       image.setFont(textFont);
       image.drawString(zeroAdder(0,6) + space + zeroAdder(0,6)+ space1 +zeroAdder(0,6) + space + zeroAdder(0,6)+ space1 +zeroAdder(0,6)+ space1 +zeroAdder(0,6) + space + zeroAdder(0,6)+ space1 + zeroAdder(0,6),50,30);
       setImage(image);
   }
   
   public void update(int corn,int cucumber,int potato,int strawberry, int tomato, int radish, int eggs, int milk){
       image.clear();
       image.drawString(zeroAdder(corn,6) + space + zeroAdder(cucumber,6)+ space1 +zeroAdder(potato,6) + space + zeroAdder(strawberry,6)+ space1 +zeroAdder(tomato,6)+ space1 +zeroAdder(radish,6) + space + zeroAdder(0,6)+ space1 + zeroAdder(0,6), 50,30);
       setImage(image);
   }
}
