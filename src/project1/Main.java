package project1;

import processing.core.*;

public class Main extends PApplet {
    
    @Override
    public void setup() {

        // Set size and background color of graph window.
        size(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        smooth();
        background(255);

        // Declare arrays for raw bar height data and normalized bar height
        // data, along with the width of the bars.
        float[] rawBarHeight = new float[args.length - 3];
        float[] normalizedBarHeight = new float[rawBarHeight.length];
        float rectWidth = (width - (5 * rawBarHeight.length + 1))
                / rawBarHeight.length;

        // Transfer and parse user inputs for bar height from args to
        // dataArray, leaving out the height and width of the graph
        // window, as well as the project name.
        float max = 0;
        for(int i = 3; i < args.length; i++) {
            rawBarHeight[i-3] = Float.parseFloat(args[i]);
            if(rawBarHeight[i-3] > max) {
                max = rawBarHeight[i-3];
            }
        }

        // Normalize bar height data to fit neatly in the graph window.
        for(int i = 0; i < rawBarHeight.length; i++) {
            normalizedBarHeight[i] = (rawBarHeight[i] / max) *
                    (height - (float) 20.0);
        }

        // Draw the first bar.
        fill(random(255),random(255),random(255));
        rect((float) 5.0, (height - normalizedBarHeight[0]),
                rectWidth, normalizedBarHeight[0]);

        // Draw the rest of the bars.
        float x = 5;
        for(int i = 1; i < normalizedBarHeight.length; i++) {
            fill(random(255),random(255), random(255));
            x += (rectWidth + 5);
            rect(x, (height - normalizedBarHeight[i]), rectWidth,
                    normalizedBarHeight[i]);
        }
     }

    // Main method - transfer command-line arguments from args to tempArgs,
    // along with the two strings of text that Processing requires.
    public static void main(String[] args) {
        String[] tempArgs = new String[args.length + 2];
        tempArgs[0] = "--bgcolor=#FFFFFF";
        tempArgs[1] = "project1.Main";
        for(int i = 2; i < tempArgs.length; i++) {
            tempArgs[i] = args[i-2];
        }
          PApplet.main(tempArgs);
    }
}
   




