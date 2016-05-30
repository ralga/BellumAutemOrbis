package BellumAutemOrbis.GraphicObject;

import BellumAutemOrbis.BellumAutemOrbis;
import BellumAutemOrbis.GameObject.Unit;
import processing.core.PApplet;
import processing.core.PFont;

public class UI extends GraphicObject {

    private static final String IMGPATH = "res/img/ui/";
    private static final String FONTPATH = "res/font/";
    private PFont font;

    public UI(BellumAutemOrbis bao, int x, int y, int w, int h) {
        super(bao, x, y, w, h, IMGPATH);
    }

    @Override
    public void init() {
        this.font = bao.createFont(FONTPATH + "OldLondon.ttf", 35);
    }

    @Override
    public void draw() {
        bao.g.imageMode(PApplet.CORNER);
        image(tabImg[1], -1, 0);
        bao.textFont(font);
        bao.g.fill(0);
        if (Unit.selec != null) {
            text("Vie : " + Unit.selec.hp + " / " + Unit.selec.tabDat[1][Unit.selec.type][0], bao.W / 2 - 20, 90);
            text("Attaque : " + Unit.selec.att, bao.W / 2 - 20, 130);
            image(Unit.selec.tabSprite[0][0], 190, 70);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
    }

    @Override
    public void mouseMoved(int x, int y) {
    }

}
