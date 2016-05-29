package BellumAutemOrbis.View;

import BellumAutemOrbis.BellumAutemOrbis;
import BellumAutemOrbis.GraphicObject.GraphicObject;
import processing.core.PApplet;

public class Button extends GraphicObject {

    private static final String IMGPATH = "res/img/button/";

    private final int ID;
    private int OPA1 = 80;
    private final int OPA2 = 190;
    private int IMG1, IMG2;
    private Text t = null;
    private int img;
    private int opacity = OPA1;

    public Button(BellumAutemOrbis bao, Text t, int id) {
        super(bao, (int) (t.getX()) - (bao.width - bao.W) / 2, (int) (t.getY()) - 2 * (bao.height - bao.H) / 3, t.getW(), t.getH());
        this.t = t;
        this.ID = id;
    }

    public Button(BellumAutemOrbis bao, int x, int y, int img1, int img2, int id) {
        super(bao, x, y, 0, 0, IMGPATH);
        this.IMG1 = this.img = img1;
        this.IMG2 = img2;
        this.w = tabImg[img1].width;
        this.h = tabImg[img1].height;
        this.ID = id;
    }

    public Button(BellumAutemOrbis bao, int x, int y, int w, int h, int id, int op) {
        super(bao, x, y, w, h);
        this.ID = id;
        OPA1 = op;
    }

    private void changeState(boolean state) //state : false : bouton inactif, true : bouton actif
    {
        if (t != null)
            if (state)
                opacity = OPA2;
            else
                opacity = OPA1;
        else if (state)
            img = IMG2;
        else
            img = IMG1;
    }

    @Override
    public void init() {
    }

    @Override
    public void draw() {
        bao.g.imageMode(PApplet.CORNER);
        if (t != null) {
            bao.fill(255, opacity);
            rect(0, 0, w, h, 80);
            t.draw();
        }
        else {
            bao.tint(255, 200);
            image(tabImg[img], 0, 0);
            bao.noTint();
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        changeState(false);
        switch (ID) {
            case 0:                                                             //Actions lors d'un clic de souris sur le bouton jouer
                if (isOn(x, y))
                    bao.setView(1);
                break;
            case 1:                                                             //Actions lors d'un clic de souris sur le bouton quitter
                if (isOn(x, y))
                    BellumAutemOrbis.bao.exit();
                break;
            case 2:                                                             //Actions lors d'un clic de souris sur le bouton annuler
                break;
            case 3:                                                             //Actions lors d'un clic de souris sur le bouton en ligne : normale
                break;
            case 4:                                                             //Actions lors d'un clic de souris sur le bouton en ligne : classique
                break;
            case 5:                                                             //Actions lors d'un clic de souris sur le bouton local : normale
                break;
            case 6:                                                             //Actions lors d'un clic de souris sur le bouton local : classique
                break;
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        changeState(isOn(x, y));

        /*if(se.getViews()[0].getGO()[2].isOn(x, y) || se.getViews()[0].getGO()[4].isOn(x, y))
         se.getSurface().setCursor(12);                                      //Modification de l'apparence du curseur de la souris lorsque l'on est au-dessus d'un bouton
         else
         se.getSurface().setCursor(0);*/
    }
}
