package processing.test.BouncyBall;

/**
 * Created by parasjain on 2/5/15.
 */
class Ball extends ProcessingObject {
    private int ballColor;

    private int xPos;
    private int yPos;

    private int taps;
    private double speed = 0;
    private double dSpeed= game.p.game.display.getScaleFactor(); // dv/dt

    // 0 = still, 1 = positive direction, 2 = negative direction
    private int xDir = 1;
    private int yDir = 0;

    public Ball(GameView p) {
        super(p);
    }

    @Override
    public void setup() {
        xPos = game.display.getDisplayWidth() / 2;
        yPos = game.display.getDisplayHeight() / 2;

        ballColor = game.p.color(255, 255, 255);

        dSpeed = Math.max(game.display.getScaleFactor() * 1, 1);
    }

    @Override
    public void draw() {
        
    }

    @Override
    public void mousePressed() {
        taps++;
        speed += dSpeed;

        xDir = -1*xDir;
        yDir = -1*yDir;
    }
}
