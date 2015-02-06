package processing.test.BouncyBall;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parasjain on 2/5/15.
 */
class GameView {
    protected Main p;

    protected Display display;
    protected Ball ball;

    protected List<ProcessingObject> world;

    public GameView(Main processing) {
        p = processing;

        world = new ArrayList<ProcessingObject>();

        // create world objects
        display = new Display(this);
        ball = new Ball(this);

        world.add(display);
        world.add(ball);
    }

    public void setup() {
        for (ProcessingObject obj : world)
            obj.setup();
    }

    public void draw() {
        for (ProcessingObject obj : world)
            obj.draw();
    }

    public void mousePressed() {
        for (ProcessingObject obj : world)
            obj.mousePressed();
    }
}
