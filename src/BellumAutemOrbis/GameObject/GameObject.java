package BellumAutemOrbis.GameObject;

import BellumAutemOrbis.BellumAutemOrbis;
import BellumAutemOrbis.GraphicObject.GraphicObject;
import BellumAutemOrbis.GraphicObject.World;
import processing.core.PImage;

public abstract class GameObject extends GraphicObject
{
    public int type;
    protected PImage[][] tabSprite;
    public int cx, cy;
    
    public GameObject(BellumAutemOrbis bao, int type, int cx, int cy, int cw, int ch, String imgPath, String datPath)
    {
        super(bao, cx*World.C + World.C/2, cy*World.C + World.C/2, World.C, World.C, imgPath, datPath);
        this.type = type;
        this.cx = cx;
        this.cy = cy;
    }
    
    @Override
    public void init()
    {
        tabSprite = cut(tabImg[type], tabDat[0][type][0], tabDat[0][type][1]);
    }
    
    public boolean isOutside()
    {
        return x-World.posX > (bao.width-bao.W)/2 && x-World.posX < (bao.width+bao.W)/2
            && y-World.posY > (bao.height-bao.H)/2 && y-World.posY < (bao.height+bao.H)/2;
    }
    
    //public void setX(int nx){x = (bao.width-bao.W) / 2 + cx*World.C + World.C/2 + nx;}
    
    //public void setY(int ny){y = (bao.height-bao.H) / 2 + ny;}
}
