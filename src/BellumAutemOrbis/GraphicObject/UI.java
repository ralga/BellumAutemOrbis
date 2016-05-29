package BellumAutemOrbis.GraphicObject;

import BellumAutemOrbis.BellumAutemOrbis;
import processing.core.PApplet;

public class UI extends GraphicObject
{
    private static final String IMGPATH = "res/img/ui/";
    
    public UI(BellumAutemOrbis bao, int x, int y, int w, int h) 
    {
        super(bao, x, y, w, h, IMGPATH);
    }

    @Override
    public void init() 
    {}

    @Override
    public void draw() 
    {
        //bao.g.fill(255);
        //rect(0, 0, w, h);
        bao.g.imageMode(PApplet.CORNER);
        image(tabImg[0], -1, 0);
    }

    @Override
    public void mousePressed(int x, int y) 
    {}

    @Override
    public void mouseMoved(int x, int y) 
    {}
    
}
