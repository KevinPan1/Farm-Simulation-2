import greenfoot.*;
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class CashInfo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CashInfo extends HUD
{
    private GreenfootImage image = new GreenfootImage(200,45);
    private Color textColor = new Color(255,255,255);
    private Font textFont = new Font("Helvetica", Font.PLAIN, 20);
    private String space = "        ";
    private String space1 = "         ";

    public CashInfo(){
        image.setColor(textColor);
        image.setFont(textFont);
        image.drawString(zeroAdder(0,8),85,30);
        setImage(image);
    }

    public void update(int cash){
        image.clear();
        image.drawString(zeroAdder(cash,8), 85,30);
        setImage(image);
    }
}
