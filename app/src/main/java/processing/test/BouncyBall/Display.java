package processing.test.BouncyBall;

class Display extends ProcessingObject {
    private int width;
    private int height;
    private static final int baseWidth = 400;

    public Display(GameView p) {
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
        this.width = game.p.displayWidth;
        this.height = game.p.displayHeight;
    }

    @Override
    public void setup() {
        game.p.smooth();
        updateSize();
    }

    @Override
    public void draw() {
        updateSize();
    }
}
