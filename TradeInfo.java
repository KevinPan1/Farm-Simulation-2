import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color; // Need Color and Font for drawing ScoreBar
import java.awt.Font;

public class TradeInfo extends Actor
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
   
   public void update(int cornP,int cucumberP,int potatoP,int strawberryP, int tomatoP, int radishP){
       image.clear();
       image.drawString(zeroAdder(cornP,3) + space + zeroAdder(strawberryP,3),51,26);
       image.drawString(zeroAdder(cucumberP,3) + space + zeroAdder(tomatoP,3),51,61);
       image.drawString(zeroAdder(potatoP,3) + space + zeroAdder(radishP,3),51,97);
       image.drawString(zeroAdder(0,3) + space + zeroAdder(0,3),51,135);
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
