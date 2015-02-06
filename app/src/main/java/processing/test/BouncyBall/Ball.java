package processing.test.BouncyBall;

/**
 * Created by parasjain on 2/5/15.
 */
class Ball extends ProcessingObject {
    private int ballColor;

    protected int xPos;
    protected int yPos;

    protected int taps;
    protected double speed;
    protected double dSpeed;

    // 0 = still, 1 = positive direction, 2 = negative direction
    protected int xDir = 1;
    protected int yDir = 0;

    public Ball(GameView p) {
        super(p);
        speed = 0;
        dSpeed = 0;
        taps = 0;
    }

    @Override
    public void setup() {
        xPos = game.display.getDisplayWidth() / 2;
        yPos = game.display.getDisplayHeight() / 2;

        ballColor = game.p.color(0, 0, 0);

        speed = 0;
        dSpeed = Math.max(game.display.calcScale(1), 1);
    }

    @Override
    public void draw() {
        game.p.ellipse(xPos, yPos, game.display.calcScale(60),
                game.display.calcScale(60));

        xPos += (dSpeed * xDir);
        yPos += (dSpeed * yDir);


    }

    @Override
    public void mousePressed() {
        taps++;
        speed += dSpeed;

        xDir = -1*xDir;
        yDir = -1*yDir;

        if (game.lost) //If we lost the game, reset now and start over
        {
            setup();
            game.reset();
            game.p.loop(); // unpause
        }
    }
}
