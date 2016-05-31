package BellumAutemOrbis.GameObject;

import BellumAutemOrbis.BellumAutemOrbis;
import BellumAutemOrbis.GraphicObject.World;
import BellumAutemOrbis.PathFinding.Elements;
import java.util.ArrayList;
import java.util.LinkedList;
import processing.core.PApplet;
import processing.core.PImage;

public class Unit extends GameObject
{
    private static final String IMGPATH = "res/img/unit/";
    private static final String DATPATH = "res/dat/unit/";
    public static final ArrayList<Unit> units = new ArrayList<>();
    public LinkedList<int[]> path = new LinkedList<>();
    public PImage[][] tabSprite;
    public int direc = 2;
    public int anim = 0;
    public long time = 0;
    public int att;
    public int speed;
    public boolean pGold = false;
    public long timeG = 0;
    public boolean pWood = false;
    public long timeW = 0;

    public Unit(BellumAutemOrbis bao, int type, int cx, int cy, boolean team)
    {
        super(bao, type, team, cx, cy, 1, 1, IMGPATH, DATPATH);
        hp = tabDat[1][type][0];
        att = tabDat[1][type][1];
        gold = tabDat[1][type][2];
        speed = tabDat[1][type][3];
//        int[] p1 = {5, 4};
//      int[] p2 = {5, 5};int[] p3 = {6, 5};int[] p4 = {7, 5};int[] p5 = {7,4};
//      int[] p6 = {6,4};int[] p7 = {6,4};int[] p8 = {5,4};int[] p9 = {4,4};
        //path = astar.astar(World.colli, new Elements(0,0,cx,cy,null), new Elements(8,8,30,42,null));
        if(!path.isEmpty())
            getDirection();
        units.add(this);

        init();
        //units.add(this);
    }

    public void changeDirection()
    {
        //System.out.println("vfgvf");
        if(path.isEmpty())
            return;
        /*if(path.size() < 2)
         {
         if(!path.isEmpty())
         path.remove(0);
         return;
         }*/
        //path.remove(0);
        int[] coord = path.remove(0);
        int xc = coord[0] - cx;
        int yc = coord[1] - cy;
        if(xc == 1 && yc == 0)
        {
            direc = 2;
            cx += 1;
        }
        else if(xc == -1 && yc == 0)
        {
            direc = 1;
            cx -= 1;
        }
        else if(yc == 1 && xc == 0)
        {
            direc = 0;
            cy += 1;
        }
        else if(yc == -1 && xc == 0)
        {
            direc = 3;
            cy -= 1;
        }
        else
            System.out.println("fuck");
    }

    private void getDirection()
    {
        if(path.isEmpty())
            return;
        /*if(path.size() < 2)
         {
         if(!path.isEmpty())
         path.remove(0);
         return;
         }*/
        //path.remove(0);
        int[] coord = path.get(0);
        int xc = coord[0] - cx;
        int yc = coord[1] - cy;
        if(xc == 1 && yc == 0)
            direc = 2;
        else if(xc == -1 && yc == 0)
            direc = 1;
        else if(yc == 1 && xc == 0)
            direc = 0;
        else if(yc == -1 && xc == 0)
            direc = 3;
        else
            System.out.println("fuck");
    }

    public void product(int x, int y, boolean gold)
    {
        int[] pos = findCase(x, y);
        if(pos != null)
        {
            path = World.astar.astar(World.colli, new Elements(0,0,cx,cy,null), new Elements(0,0,pos[0],pos[1],null));
            if(gold)
                pGold = true;
            else
                pWood = true;
        }
    }
    
    public int[] findCase(int x, int y)
    {
        int[] res = new int[2];
        if(World.colli[y-1][x])
        {
            res[0] = x;
            res[1] = y-1;
        }
        else if(World.colli[y+1][x])
        {
            res[0] = x;
            res[1] = y+1;
        }
        else if(World.colli[y][x-1])
        {
            res[0] = x-1;
            res[1] = y;
        }
        else if(World.colli[y][x+1])
        {
            res[0] = x+1;
            res[1] = y;
        }
        else return null;
        return res;
    }
    
    @Override
    public void init()
    {
        tabSprite = cut(tabImg[type], tabDat[0][type][0], tabDat[0][type][1]);
    }

     public void draw()
    {
        if(isOutside())
        {
            bao.g.imageMode(PApplet.CORNER);
            if(tabDat[0][type][0] == 40)
                image(tabSprite[direc][anim], -World.posX, -World.posY);
            else
                image(tabSprite[direc][anim], -World.posX - World.C/2, -World.posY - World.C/2);
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
