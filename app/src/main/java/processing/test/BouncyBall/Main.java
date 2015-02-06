package processing.test.BouncyBall;

import processing.core.*;

public class Main extends PApplet {
    protected GameView game;

    /**
     * Constructor
     */
    public Main() {
        game = new GameView(this);
    }

    /**
     * Setup for Processing
     */
    public void setup() {
        game.setup();

        // debug
        String[] fontList = PFont.list();
        println(fontList);
    }

    /**
     * Draw for Processing
     */
    public void draw() {
        game.draw();

    }


    public void mousePressed() {
        game.mousePressed();
    }

    public int sketchWidth() {
        System.out.println("Updated width, " + game.display.getDisplayWidth());
        return game.display.getDisplayWidth();
    }

    public int sketchHeight() {
        return game.display.getDisplayHeight();
    }
}