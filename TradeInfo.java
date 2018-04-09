import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color; // Need Color and Font for drawing ScoreBar
import java.awt.Font;

public class TradeInfo extends HUD
{
   private GreenfootImage image = new GreenfootImage(200,150);
   private Color textColor = new Color(255,255,255);
   private Font textFont = new Font("Helvetica", Font.PLAIN, 20);
   private String space = "         ";
   
   public TradeInfo(){
       image.setColor(textColor);
       image.setFont(textFont);
       image.drawString(zeroAdder(0,3) + space + zeroAdder(0,3),51,26);
       image.drawString(zeroAdder(0,3) + space + zeroAdder(0,3),51,61);
       image.drawString(zeroAdder(0,3) + space + zeroAdder(0,3),51,97);
       image.drawString(zeroAdder(0,3) + space + zeroAdder(0,3),51,135);
       setImage(image);
   }
   
   public void update(int cornP,int cucumberP,int potatoP,int strawberryP, int tomatoP, int radishP, int eggsP, int milkP){
       image.clear();
       image.drawString(zeroAdder(cornP,3) + space + zeroAdder(strawberryP,3),51,26);
       image.drawString(zeroAdder(cucumberP,3) + space + zeroAdder(tomatoP,3),51,61);
       image.drawString(zeroAdder(potatoP,3) + space + zeroAdder(radishP,3),51,97);
       image.drawString(zeroAdder(eggsP,3) + space + zeroAdder(milkP,3),51,135);
       setImage(image);
   }
}
