import greenfoot.*;
import java.awt.Color;
import java.awt.Font;

/**
 * An actor which displays the amount of acts or frames per second the greenfoot program is displaying at.
 * This class must be provided the act number that the current simulation greenfoot is on in order to work.
 * A Greenfoot World class that uses this actor should have a counter within their act method and increment by 1 every act. 
 * Whenever, the fps wants to be updated, call one of the update functions providing the act number which is necessary to calculate fps.
 * This actor relies on an internal java system clock to calculate the time.
 * Automatically scales the graph based on the range of values.
 * <p>
 * Warning: the frames per second is extremely unstable when the speed slider is increased. 
 * Do not set the foreground color to null, it will cause a null pointer exception because I get RGB values from the foreground color.
 * It is also recommended not to update the fpsmeter every single act as the meter may change numbers too rapidly, decreasing readibility
 * <p>
 * Useful for debugging, checking the optimization of your code or if you love looking at statistics and graphs.
 * My inspiration is from the windows task manager.
 * 
 * @author Kevin Pan
 * @version 1.0
 */
public class KPWidget extends Actor
{
    private GreenfootImage fps;
    private Color textColor;
    private Color background;
    private Color foreground;
    private Color transFore;
    private Font font;
    private String text;
    private int[] yPoints;
    private int lastact;
    private int counter;
    private int width;
    private int height;
    private int minFrames;
    private int maxFrames;
    private double lastTime;
    private double duration;
    private boolean hasGraph;
    private boolean hasBorder;
    
    /**
     * Constructs an FPS display with a user specified width.
     * The Height of this actor is locked with respect to the width of the actor.
     * User can select if a line graph of the FPS will be displayed through the hasGraph parameter.
     * @param width Determines the width of the actor in pixels.
     * @param hasGraph Displays the graph if true, otherwise hides the graph if false.
     */
    public KPWidget(int width, boolean hasGraph){
        this(width,255,Color.BLACK,new Color(0,0,0,0),Color.BLACK,false,true); // call the main constructor with some default values
    }
    
    /**
     * Constructs an FPS display with a user specified width with additonal apperance options.
     * @param width Determines the width of the actor in pixels
     * @param transparency Sets the transparency of the meter. Accepts a value in the range 0 to 255. 0 is completely transparent (invisible) and 255 is completely opaque.
     * @param fore Sets the font and border color to the fore Color.
     * @param back Sets the background color to the back Color.
     * @param hasGraph Displays the graph if true, otherwise hides the graph if false.
     */
    public KPWidget(int width, int transparency, Color fore, Color back, boolean hasGraph){
        this(width,transparency,fore,back,fore,hasGraph,true); // call the main constructor with some default values
    }
    
     /**
     * Constructs an FPS display with a user specified width with maximum apperance options.
     * @param width Determines the width of the actor in pixels
     * @param transparency Sets the transparency of the meter. Accepts a value in the range 0 to 255. 0 is completely transparent (invisible) and 255 is completely opaque.
     * @param fore Sets the font and border color to the fore Color.
     * @param back Sets the background color to the back Color.
     * @param textColor Sets the color of the text.
     * @param hasGraph Displays the graph if true, otherwise hides the graph if false.
     * @param hasBorder Creates an rectangular outline of the border if true. Actor is borderless if false.
     */
    public KPWidget(int width, int transparency, Color fore, Color back, Color textColor, boolean hasGraph, boolean hasBorder){
        this.hasGraph = hasGraph;
        this.hasBorder = hasBorder;
        this.width = width; // set the size of the image
        if(hasGraph){
            height = width; // set the graph actor shape as a square
        }else{
            height = width/2; // rectangle shape without the graph
        }
        fps = new GreenfootImage(width,height); // create the greenfoot image
        background = back; // set the background color 
        foreground = fore; // set the foreground color
        this.textColor = textColor; // set the text color
        font = new Font("Times New Roman",Font.PLAIN,width/4); // set the font to Times New Roman
        fps.setFont(font); // change the font
        fps.setColor(background); // change the color to the background color
        fps.fill(); // fill the greenfoot image
        fps.setColor(textColor); // change the color to the text color
        fps.drawString("FPS: 0", width/16+2, width/3); // display the text
        fps.setColor(foreground); // change the color to foreground color
        if(hasBorder){
            fps.drawRect(0,0,width-1,height-1); // draw a border
        }
        fps.setTransparency(transparency); // change the transparency
        this.setImage(fps); // change the image
        lastTime = System.nanoTime(); // record the first snapshot of system time
        if(hasGraph)
            yPoints = new int[2000]; // create an data array for the yvalues of the graph
    }
    
    /**
     * Updates the text of the fpsmeter based on the given an act number by the user.
     * Calls updateGraph if the hasGraph variable is true
     * @param act The act number that the greenfoot simulation is on.
     */
    public void update(int act){ // call the main update function
        update(act,50); 
    }
    
    /**
     * Updates the text of the fpsmeter based on the given an act number by the user.
     * Calls updateGraph if the hasGraph variable is true
     * Allows user to select the transparency of the filled in graph.
     * @param act The act number that the greenfoot simulation is on.
     * @param transparency The alpha value of the color that the graph should be filled in with
     */
    public void update(int act,int transparency){
        transFore=new Color(foreground.getRed(),foreground.getGreen(),foreground.getBlue(),transparency); // retrieve the current RGB values of the foreground and create a new color with an user selected alpha
        duration=(System.nanoTime()-lastTime)/1000000000; // duration passed since last call of update
        lastTime=System.nanoTime(); // reset the lastTime 
        fps.clear(); // clear the greenfoot image
        fps.setColor(background); // change the color to background color
        fps.fill(); // fill the greenfoot image
        fps.setColor(textColor); // change the color to the text color
        fps.drawString("FPS: " + Integer.toString((int)((act-lastact)/duration)), width/16+2, width/3); // display the string with FPS:
        fps.setColor(foreground); // change the color to the foreground color
        if(hasBorder){
            fps.drawRect(0,0,width-1,height-1); // draw the border
        }
        if(hasGraph){ // if this actor includes a graph, update the graph
            updateGraph(act);
        }
        lastact=act; // record the last act number
    } 

    /**
     * Updates the graph of the fpsmeter with new values and draws the graph on the image of the actor
     * @param act The act number that the greenfoot simulation is on.
     */
    private void updateGraph(int act){
        counter++; // add one to the number of data points
        if(counter<=width){ // if the number of data points is less than the width, add another data point 
            yPoints[counter]=(int)((act-lastact)/duration);
        }else{  // if the number of data points exceed the width of the graph
            for(int i=0;i<width;++i){ // replace each space in the array with the data point to the right of it
                yPoints[i]=yPoints[i+1]; // this gives the graphs moving effect
            }
            yPoints[width]=(int)((act-lastact)/duration); // replace the last data point with the current y value
        }
        minFrames=0x3f3f3f3f; // reset minimum frames
        maxFrames=0; // reset maximum frames
        for(int i=0;i<Math.min(width,counter);++i){ // get minimum and maximum frames per second, can be optimized in O(1) time with a data structure 
            minFrames=Math.min(yPoints[i], minFrames);
            maxFrames=Math.max(yPoints[i], maxFrames);
        }
        if(maxFrames-minFrames==0) // do not allow division by zero
            return;
        for(int i=0;i<Math.min(width,counter);++i){ // draws the graph
            fps.setColor(foreground); // the top line is set to the full color
            fps.drawLine(i,height-((yPoints[i]-minFrames)*width/2/(maxFrames-minFrames)),i+1,height-((yPoints[i+1]-minFrames)*width/2/(maxFrames-minFrames))); // graph is scaled (max-min)
            fps.setColor(transFore); // the rest of the graph is filled in with a more transparent color
            fps.drawLine(i,height,i,height-((yPoints[i]-minFrames)*width/2/(maxFrames-minFrames))-1);
        }
    }
}
    