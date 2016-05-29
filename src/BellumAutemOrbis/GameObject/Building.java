package BellumAutemOrbis.GameObject;

import BellumAutemOrbis.BellumAutemOrbis;

public class Building extends GameObject
{
    private static final String IMGPATH = "res/img/buil/";
    private static final String DATPATH = "res/dat/buil/";
    private int hp;
    private int gold;
    
    public Building(BellumAutemOrbis bao, int type, int cx, int cy, int cw, int ch)
    {
        super(bao, type, cx, cy, cw, ch, IMGPATH, DATPATH);
        hp=tabDat[0][type][0];
        gold=tabDat[0][type][1];
    }

    @Override
    public void init(){}

    @Override
    public void draw()
    {
        //image(tabImg[])
    }

    @Override
    public void mousePressed(int x, int y)
    {
        
    }

    @Override
    public void mouseMoved(int x, int y)
    {
        
    }
}
