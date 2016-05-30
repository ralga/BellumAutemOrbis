package BellumAutemOrbis.GraphicObject;

import BellumAutemOrbis.BellumAutemOrbis;

public class Background extends GraphicObject {

    private static final String IMGPATH = "res/img/background/";
    private final int img;

    public Background(BellumAutemOrbis bao, int img) {
        super(bao, 0, 0, bao.W, bao.H, IMGPATH);
        this.img = img;
    }

    @Override
    public void init() {
    }

    @Override
    public void draw() {
        image(tabImg[img], 0, 0);
    }

    @Override
    public void mousePressed(int x, int y) {
    }

    @Override
    public void mouseMoved(int x, int y) {
    }
}
