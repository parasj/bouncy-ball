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

    protected int score;
    protected boolean lost;

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
        p.background(255);

        p.textSize(display.calcScale(20));
        p.text("score = " + score, 10, display.calcScale(20));

        if (ball.xPos > display.getDisplayWidth() - 20 || ball.xPos < 20) {
            doLose();
        }

        for (ProcessingObject obj : world)
            obj.draw();
    }

    public void doLose() {
        p.textSize(display.calcScale(40));
        p.textAlign(p.CENTER);
        p.text("Click to Restart", display.getDisplayWidth()/2, display.getDisplayHeight()/3);
        p.textAlign(p.LEFT);
        p.noLoop(); // pause
        lost = true;
    }

    public void mousePressed() {
        for (ProcessingObject obj : world)
            obj.mousePressed();
    }

    public void reset() {
        score = 0;
        lost = false;
    }
}
