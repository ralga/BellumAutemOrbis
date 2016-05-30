package BellumAutemOrbis.GameObject;

import BellumAutemOrbis.BellumAutemOrbis;
import BellumAutemOrbis.GraphicObject.World;
import BellumAutemOrbis.Pathfinding.Astar;
import BellumAutemOrbis.Pathfinding.Elements;
import java.util.ArrayList;
import java.util.LinkedList;
import processing.core.PApplet;

public class Unit extends GameObject {

    private static final String IMGPATH = "res/img/unit/";
    private static final String DATPATH = "res/dat/unit/";
    public static ArrayList<Unit> units = new ArrayList<>();
    public static Unit selec = null;
    public LinkedList<int[]> path = new LinkedList<>();
    public int direc = 2;
    public int anim = 0;
    public long time = 0;
    public boolean team;
    public int hp;
    public int att;
    public int gold;
    public int speed;

    public Unit(BellumAutemOrbis bao, int type, boolean team, int cx, int cy) {
        super(bao, type, cx, cy, 0, 0, IMGPATH, DATPATH);
        hp = tabDat[1][type][0];
        att = tabDat[1][type][1];
        gold = tabDat[1][type][2];
        speed = tabDat[1][type][3];
        int[] p1 = {5, 4};
//        int[] p2 = {5, 5};int[] p3 = {6, 5};int[] p4 = {7, 5};int[] p5 = {7,4};
//        int[] p6 = {6,4};int[] p7 = {6,4};int[] p8 = {5,4};int[] p9 = {4,4};
        Astar astar = new Astar();
        path = astar.astar(World.colli, new Elements(0,0,4,4,null), new Elements(0,0,20,20,null));
        if(!path.isEmpty())
            getDirection();
        units.add(this);
    }

    private void getDirection(){
        if (path.isEmpty())
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
        if (xc == 1 && yc == 0) {
            direc = 2;
        }
        else if (xc == -1 && yc == 0) {
            direc = 1;
        }
        else if (yc == 1 && xc == 0) {
            direc = 0;
        }
        else if (yc == -1 && xc == 0) {
            direc = 3;
        }
        else
            System.out.println("fuck");
    }
    
    public void changeDirection() {
        //System.out.println("vfgvf");
        if (path.isEmpty())
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
        if (xc == 1 && yc == 0) {
            direc = 2;
            cx += 1;
        }
        else if (xc == -1 && yc == 0) {
            direc = 1;
            cx -= 1;
        }
        else if (yc == 1 && xc == 0) {
            direc = 0;
            cy += 1;
        }
        else if (yc == -1 && xc == 0) {
            direc = 3;
            cy -= 1;
        }
        else
            System.out.println("fuck");
    }
    
    @Override
    public void draw() {
        if (isOutside()) {
            bao.g.imageMode(PApplet.CENTER);
            image(tabSprite[direc][anim], -World.posX, -World.posY);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
    }

    @Override
    public void mouseMoved(int x, int y) {
    }
}
