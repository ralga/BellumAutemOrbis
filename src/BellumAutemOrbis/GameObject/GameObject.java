package BellumAutemOrbis.GameObject;

import BellumAutemOrbis.BellumAutemOrbis;
import BellumAutemOrbis.GraphicObject.GraphicObject;
import BellumAutemOrbis.GraphicObject.World;

public abstract class GameObject extends GraphicObject
{
    public int type;
    public int cx, cy;
    public final int cw, ch;
    public boolean team;
    public int hp;
    public int gold;
    public int costG, costW;
    public int typeGO;
    public static GameObject selec = null;
    
    public GameObject(BellumAutemOrbis bao, int type, boolean team, int cx, int cy, int cw, int ch, String imgPath, String datPath)
    {
        super(bao, cx*World.C /*+ cw*World.C/2*/, cy*World.C /*+ ch*World.C/2*/, cw*World.C, ch*World.C, imgPath, datPath);
        this.team = team;
        this.type = type;
        this.cx = cx;
        this.cy = cy;
        this.cw = cw;
        this.ch = ch;
    }
    
    public boolean isOutside()
    {
        return x-World.posX > (bao.width-bao.W)/2 && x-World.posX < (bao.width+bao.W)/2
            && y-World.posY > (bao.height-bao.H)/2 && y-World.posY < (bao.height+bao.H)/2;
    }
}
