package BellumAutemOrbis.GameObject;

import BellumAutemOrbis.BellumAutemOrbis;

public class Building extends GameObject {

    private static final String IMGPATH = "res/img/buil/";
    private static final String DATPATH = "res/dat/buil/";

    public Building(BellumAutemOrbis bao, int type, int cx, int cy, int cw, int ch) {
        super(bao, type, cx, cy, cw, ch, IMGPATH, DATPATH);
    }

    @Override
    public void init() {
    }

    @Override
    public void draw() {
        //image(tabImg[])
    }

    @Override
    public void mousePressed(int x, int y) {

    }

    @Override
    public void mouseMoved(int x, int y) {

    }
}
