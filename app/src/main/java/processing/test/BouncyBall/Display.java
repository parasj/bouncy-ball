package processing.test.BouncyBall;

class Display extends ProcessingObject {
    private int width;
    private int height;
    private static final int baseWidth = 400;

    public Display(GameView p) {
        super(p);
        width = 500;
        height = 500;
    }

    public int getDisplayWidth() {
        updateSize();
        return width;
    }

    public int getDisplayHeight() {
        updateSize();
        return height;
    }

    public double getScaleFactor() {
        return width / ((double) baseWidth);
    }

;    public int calcScale(int a) {
        return (int) (a * width / ((double) baseWidth));
    }

    private void updateSize() {
        width = game.p.displayWidth;
        height = game.p.displayHeight;
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
