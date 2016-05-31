package BellumAutemOrbis.GameObject;

import BellumAutemOrbis.BellumAutemOrbis;
import BellumAutemOrbis.GraphicObject.World;
import java.util.ArrayList;
import processing.core.PApplet;

public class Building extends GameObject
{
    private static final String IMGPATH = "res/img/buil/";
    private static final String DATPATH = "res/dat/buil/";
    public static final ArrayList<Building> buildings = new ArrayList<>();
    
    public Building(BellumAutemOrbis bao, int type, int cx, int cy, boolean team)
    {
        super(bao, type, team, cx, cy, 2, 2, IMGPATH, DATPATH);
        hp = tabDat[1][type][0];
        gold = tabDat[1][type][1];
        costG = tabDat[1][type][2];
        costW = tabDat[1][type][3];
        typeGO = tabDat[1][type][4];
    }

    @Override
    public void init(){}

    @Override
    public void draw()
    {
        if(isOutside())
        {
            bao.g.imageMode(PApplet.CORNER);
            image(tabImg[type], -World.posX, -World.posY);
        }
    }

    @Override
    public void mousePressed(int x, int y, int type)
    {
        
    }

    @Override
    public void mouseMoved(int x, int y)
    {
        
    }
}
