package processing.test.BouncyBall;

import processing.core.*;

public class Main extends PApplet {
    private DisplayScale displayScale;

    /**
     * Constructor
     */
    public Main() {
        displayScale = new DisplayScale(this);
    }

    /**
     * Setup for Processing
     */
    public void setup() {
        displayScale.setup();
    }

    /**
     * Draw for Processing
     */
    public void draw() {
        displayScale.draw();

    }


    public void mousePressed() {

    }

    public int sketchWidth() {
        return displayScale.getDisplayWidth();
    }

    public int sketchHeight() {
        return displayScale.getDisplayHeight();
    }
}