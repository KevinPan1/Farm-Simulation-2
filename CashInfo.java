import greenfoot.*;
import java.awt.Color;
import java.awt.Font;

/**
 * Class that displays the amount of cash the farmer has.
 * text color is white and font is Helvetica size 20
 *
 * @author Kevin Pan Haris Syed
 * @version April 2018
 */

public class CashInfo extends HUD
{
    private GreenfootImage image = new GreenfootImage(200,45);
    private Color textColor = new Color(255,255,255);
    private Font textFont = new Font("Helvetica", Font.PLAIN, 20);
    private String space = "        ";
    private String space1 = "         ";

     /**
 	* Color and font is set on the text.
 	* text is formatted
 	*/
    public CashInfo(){
        image.setColor(textColor);
        image.setFont(textFont);
        //text proper placement
        image.drawString(zeroAdder(0,8),85,30);
        setImage(image);
    }
    
    //update cash when items are sold
    /**
 	* method for updating cash when items are sold.
 	*
 	* @param cash  text is updated for cash in integers
 	*/
    public void update(int cash){
        image.clear();
        image.drawString(zeroAdder(cash,8), 85,30);
        setImage(image);
    }
}
