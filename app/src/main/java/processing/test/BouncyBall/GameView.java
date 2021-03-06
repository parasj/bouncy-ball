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
        p.smooth();
        p.noStroke();

        display.setup();
        ball.setup();
    }

    public void draw() {
        p.background(255);

        p.textSize(display.calcScale(20));
        p.text("score = " + score, 10, display.calcScale(20));

        debugInfo();

        if (ball.xPos > display.getDisplayWidth() - 20 || ball.xPos < 20) {
            doLose();
        }

        ball.draw();
    }

    private void debugInfo() {
        p.textSize(display.calcScale(12));
        p.text("framerate = " + p.frameRate, 10, display.getDisplayHeight() - display.calcScale(40));
        p.text("framecount = " + p.frameCount, 10, display.getDisplayHeight() - display.calcScale(50));
    }

    public void doLose() {
        p.textSize(display.calcScale(40));
        p.textAlign(p.CENTER);
        p.fill(0);
        p.text("Click to Restart", display.getDisplayWidth()/2, display.getDisplayHeight()/3);
        p.textAlign(p.LEFT);
        p.noLoop(); // pause
        lost = true;
    }

    public void mousePressed() {
        if (lost) {
            ball.setup();
            reset();
            p.loop(); // unpause
        } else {
            ball.mousePressed();
        }
    }

    public void reset() {
        score = 0;
        lost = false;
    }
}
