import greenfoot.*;
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class CashInfo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DayInfo extends HUD
{
    private GreenfootImage image = new GreenfootImage(200,45);
    private Color textColor = new Color(255,255,255);
    private Font textFont = new Font("Helvetica", Font.PLAIN, 20);
    private String space = "        ";
    private String space1 = "         ";

    public DayInfo(){
        image.setColor(textColor);
        image.setFont(textFont);
        //text proper placement
        image.drawString(zeroAdder(0,3),100,30);
        setImage(image);
    }
    
    public void update(int day){
        image.clear();
        image.drawString(zeroAdder(day,3), 100,30);
        setImage(image);
    }
}
