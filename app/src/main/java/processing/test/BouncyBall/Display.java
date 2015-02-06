package processing.test.BouncyBall;

class Display extends ProcessingObject {
    private int width;
    private int height;
    private static final int baseWidth = 400;

    public Display(GameView p) {
        super(p);
        width = baseWidth;
        height = baseWidth;
    }

    public int getDisplayWidth() {
        width = game.p.displayWidth;
        return width;
    }

    public int getDisplayHeight() {
        height = game.p.displayHeight;
        return height;
    }

    public double getScaleFactor() {
        return width / ((double) baseWidth);
    }

    public int calcScale(int a) {
        return (int) (a * getScaleFactor());
    }

    public void updateSize() {
        width = game.p.displayWidth;
        height = game.p.displayHeight;
    }
}
