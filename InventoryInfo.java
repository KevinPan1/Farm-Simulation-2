import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color; // Need Color and Font for drawing ScoreBar
import java.awt.Font;

/**
 * Class that displays text for the amount of items the farmer has.
 * The size of the inventory bar is 960,50.
 *
 * @author Kevin Pan Haris Syed
 * @version April 2018
 */
public class InventoryInfo extends HUD
{
   private GreenfootImage image = new GreenfootImage(960,50);
   private String space = "        ";
   private String space1 = "         ";
   
   /**
    * text colors and font is taken from the parent class.
    * Formats the text used for each item.
    */
   public InventoryInfo(){
       image.setColor(textColor);
       image.setFont(textFont);
       //spacing in between each text
       image.drawString(zeroAdder(0,6) + space + zeroAdder(0,6)+ space1 +zeroAdder(0,6) + space + zeroAdder(0,6)+ space1 +zeroAdder(0,6)+ space1 +zeroAdder(0,6) + space + zeroAdder(0,6)+ space1 + zeroAdder(0,6),50,30);
       setImage(image);
   }
   
   //method for updating the text for each item
   /**
	* method for updating the inventory for each item when it is harvested
	*
	* @param corn   	takes amount in inventory for corn in integer
	* @param cucumber   takes amount in inventory for cucumber in integer
	* @param potato 	takes amount in inventory for potato in integer
	* @param strawberry takes amount in inventory for strawberry in integer
	* @param tomato 	takes amount in inventory for tomato in integer
	* @param radish 	takes amount in inventory for radish in integer
	* @param eggs   	takes amount in inventory for egg in integer
	* @param milk   	takes amount in inventory for milk in integer
	*/
   public void update(int corn,int cucumber,int potato,int strawberry, int tomato, int radish, int eggs, int milk){
       image.clear();
       image.drawString(zeroAdder(corn,6) + space + zeroAdder(cucumber,6)+ space1 +zeroAdder(potato,6) + space + zeroAdder(strawberry,6)+ space1 +zeroAdder(tomato,6)+ space1 +zeroAdder(radish,6) + space + zeroAdder(eggs,6)+ space1 + zeroAdder(milk,6), 50,30);
       setImage(image);
   }
}
