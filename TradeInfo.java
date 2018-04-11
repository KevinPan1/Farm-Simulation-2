import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color; // Need Color and Font for drawing ScoreBar
import java.awt.Font;

/**
 * Trade Info is a class that displays text for the prices of each item.
 * The text is white and the font is Helvetica size 20.
 * The space in between text is meant to fit on a specific picture used in this simulation
 *
 * @author Kevin Pan Haris Syed
 * @version April 2018
 */
public class TradeInfo extends HUD
{
   private GreenfootImage image = new GreenfootImage(200,150);
   //text color white
   private Color textColor = new Color(255,255,255);
   //set font
   private Font textFont = new Font("Helvetica", Font.PLAIN, 20);
   private String space = "         ";
   
   /**
    * Sets the color and font of the text.
    * Formats the spacing for the text
    */
   public TradeInfo(){
       image.setColor(textColor);
       image.setFont(textFont);
       //spacing for each text
       image.drawString(zeroAdder(0,3) + space + zeroAdder(0,3),51,26);
       image.drawString(zeroAdder(0,3) + space + zeroAdder(0,3),51,61);
       image.drawString(zeroAdder(0,3) + space + zeroAdder(0,3),51,97);
       image.drawString(zeroAdder(0,3) + space + zeroAdder(0,3),51,135);
       setImage(image);
   }
   
   //updat for each item
   /**
	* Method used to update the price of each item
	*
	* @param cornP   	takes price for corn in integer
	* @param cucumberP   takes price for cucumber in integer
	* @param potatoP 	takes price for potato in integer
	* @param strawberryP takes price for strawberry in integer
	* @param tomatoP 	takes price for tomato in integer
	* @param radishP 	takes price for radish in integer
	* @param eggsP   	takes price for egg in integer
	* @param milkP   	takes price for milk in integer
	*/
   public void update(int cornP,int cucumberP,int potatoP,int strawberryP, int tomatoP, int radishP, int eggsP, int milkP){
       image.clear();
       image.drawString(zeroAdder(cornP,3) + space + zeroAdder(strawberryP,3),51,26);
       image.drawString(zeroAdder(cucumberP,3) + space + zeroAdder(tomatoP,3),51,61);
       image.drawString(zeroAdder(potatoP,3) + space + zeroAdder(radishP,3),51,97);
       image.drawString(zeroAdder(eggsP,3) + space + zeroAdder(milkP,3),51,135);
       setImage(image);
   }
}
