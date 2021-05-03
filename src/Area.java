import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Area extends JPanel {
    //Creating random object
    Random r = new Random();

    StringCutter SC;

    //Points for the start and end-point
    Point start;
    Point End;

    public Area(){
        try {
            SC = new StringCutter("area1.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
    //Variable to see if the game is paused
    public boolean paused = false;


    //This method is the heart of the program.
    //It loops through each frame to update simulation and calls the redraw function
    public void gameloop(){
        //Constants
        final int TICKSPERSECONDS = 64;
        final int SKIPTICK = 1000 / TICKSPERSECONDS;
        final int MAXFRAMESKIP = 10;

        //Getting the current time in milliseconds
        double ngt = System.currentTimeMillis();

        //Amount of iterations
        int iterations;

        //Infinity loop
        while (true) {
            iterations = 0;
            //Checks so the time is running forward and checks so the iteration is lower than the frameskip
            while (System.currentTimeMillis() > ngt && iterations < MAXFRAMESKIP) {
                //Skips to redraw if the simulation is paused
                if(paused){
                    continue;
                }
                else{
                    //Checking collision

                    //Repaints
                    this.repaint();

                }
                //Adding the SkipTicks
                ngt += SKIPTICK;

                //Count +1 on iteration
                iterations++;
            }
        }
    }
*/

    //The paint component to draw the panel and calling the paint function on the balls
    @Override
    public void paint(Graphics g) {

        //Getting the properties from the original paint class so
        //so we just adding our code to it and don't re writes it
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;

        this.setBackground(Color.WHITE);

        //Enabling antialias to get a smoother experience
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.BLACK);

        for(Polygon a : SC.polys){
            g2d.fillPolygon(a.xarray,a.yarray,8);

        }


        //g2d.fillP

        //Drawing the contour
        //g2d.fillOval(998,950,1,1);
    }
}
