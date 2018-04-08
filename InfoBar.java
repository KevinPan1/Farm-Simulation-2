import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color; // Need Color and Font for drawing ScoreBar
import java.awt.Font;

public class InfoBar extends Actor
{
   private GreenfootImage image = new GreenfootImage(960,50);
   private Color textColor = new Color(255,255,255);
   private Font textFont = new Font("Helvetica", Font.PLAIN, 20);
   private String space = "        ";
   private String space1 = "       ";
   
   public InfoBar(){
       image.setColor(textColor);
       image.setFont(textFont);
       image.drawString(zeroAdder(0,6) + space + zeroAdder(0,6)+ space1 +zeroAdder(0,6) + space + zeroAdder(0,6)+ space +zeroAdder(0,6)+ space +zeroAdder(0,6),40,30);
       setImage(image);
   }
   
   public void update(int corn,int cucumber,int potato,int strawberry, int tomato, int radish){
       image.clear();
       image.drawString(zeroAdder(corn,6) + space + zeroAdder(cucumber,6)+ space1 +zeroAdder(potato,6) + space + zeroAdder(strawberry,6)+ space +zeroAdder(tomato,6)+ space +zeroAdder(radish,6),40,30);
       setImage(image);
   }
   
    // mr cohen's shit 
   /**
     * Method that aids in the appearance of the scoreboard by generating
     * Strings that fill in zeros before the score. For example:
     * 
     * 27 ===> to 5 digits ===> 00027
     * 
     * @param   value   integer value to use for score output
     * @param   digits   number of zeros desired in the return String
     * @return  String  built score, ready for display
     */
    public static String zeroAdder (int value, int digits)
    {
        // Figure out how many digits the number is
        int numDigits = digitCounter(value);

        // If not extra digits are needed
        if (numDigits >= digits)
            return Integer.toString(value);

        else // Build the number with zeroes for extra place values:
        {
            String zeroes = "";
            for (int i = 0; i < (digits - numDigits); i++)
            {
                zeroes += "0";
            }
            return (zeroes + value);
        }

    }
    
    /**
     * Useful private method that counts the digit in any integer.
     * 
     * @param number    The number whose digits you want to count
     * @return  int     The number of digits in the given number
     */
    private static int digitCounter (int number)
    {
        if (number < 10) {
            return 1;
        }
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }
}
