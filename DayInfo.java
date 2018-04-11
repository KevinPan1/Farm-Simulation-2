import greenfoot.*;
import java.awt.Color;
import java.awt.Font;

/**
 * Class that creates and displays the amount of days that has passed
 * since the beginning of the simulation.
 * The dimension is 200,45.
 * Text color is white, font is Helvetica size 20
 *
 * @author Kevin Pan Haris Syed
 * @version April 2018
 */

public class DayInfo extends HUD
{
    private GreenfootImage image = new GreenfootImage(200,45);
    private Color textColor = new Color(255,255,255);
    private Font textFont = new Font("Helvetica", Font.PLAIN, 20);
    private String space = "        ";
    private String space1 = "         ";

    /**
 	* Color and font is set for text
 	* text is properly positioned
 	*/
    public DayInfo(){
        image.setColor(textColor);
        image.setFont(textFont);
        //text proper placement
        image.drawString(zeroAdder(0,3),100,30);
        setImage(image);
    }
    
    /**
 	* Method used for updating the amount of days
 	*
 	* @param day  days takes in the amount of days in integers
 	*/
    public void update(int day){
        image.clear();
        image.drawString(zeroAdder(day,3), 100,30);
        setImage(image);
    }
}
