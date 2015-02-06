package processing.test.BouncyBall;

import processing.core.*;

/**
 * Created by parasjain on 2/5/15.
 */
public abstract class ProcessingObject {
    protected PApplet p;

    public ProcessingObject(PApplet p) {
        this.p = p;
    }

    public abstract void setup();

    public abstract void draw();
}
