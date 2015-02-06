package processing.test.BouncyBall;

import processing.core.*;

public class DisplayScale extends ProcessingObject {
    private int width;
    private int height;
    private static final int baseWidth = 400;

    public DisplayScale(PApplet p) {
        super(p);
    }

    public int getDisplayWidth() {
        return width;
    }

    public int getDisplayHeight() {
        return height;
    }

    public double getScaleFactor() {
        return width / ((double) baseWidth);
    }

    private void updateSize() {
        this.width = p.displayWidth;
        this.height = p.displayHeight;
    }

    @Override
    public void setup() {
        updateSize();
    }

    @Override
    public void draw() {
        updateSize();
    }
}
