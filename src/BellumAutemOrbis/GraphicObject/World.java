package BellumAutemOrbis.GraphicObject;

import BellumAutemOrbis.BellumAutemOrbis;
import BellumAutemOrbis.GameObject.*;
import BellumAutemOrbis.PathFinding.Astar;
import BellumAutemOrbis.PathFinding.Elements;
import processing.core.PGraphics;

public class World extends GraphicObject {

    private static final String IMGPATH = "res/img/world/";
    private static final String DATPATH = "res/dat/world/";
    public static final int C = 40;
    public final int SCALE = 3;
    public final int W = 50 * C;
    public final int H = 50 * C;
    public static int posX;
    public static int posY;
    public static boolean[][] colli = new boolean[50][50];
    public int moveX;
    public int moveY;
    private PGraphics img;
    public static World world;
    public static Astar astar = new Astar();

    public World(BellumAutemOrbis bao, int x, int y) {
        super(bao, 0, 0, bao.W, bao.H, IMGPATH, DATPATH);
        posX = x;
        posY = y;
        world = this;
        initCollision();
    }

    public static void initCollision() {
        colli = new boolean[50][50];
        for (int i = 0; i < colli.length; i++)
            for (int j = 0; j < colli[i].length; j++)
                if (world.tabDat[1][0][world.tabDat[0][i][j]] == 1)
                    colli[i][j] = true;
    }

    @Override
    public void init() {
        img = bao.createGraphics(W, H);
        img.beginDraw();
        int[][] world = tabDat[0];
        for (int i = 0; i < world.length; i++)
            for (int j = 0; j < world[i].length; j++)
                img.image(tabImg[world[i][j]], j * C, i * C);
        img.endDraw();
    }

    @Override
    public void draw() {
        bao.g.copy(img, posX, posY, w, h, (int) x, (int) y, w, h);
    }

    @Override
    public void mousePressed(int x, int y, int type) {
        if (!isOn(x, y) || y > (bao.height - bao.H) / 2 + 3 * bao.H / 4)
            return;
        int cx = (posX + x - (bao.width - bao.W) / 2) / C;
        int cy = (posY + y - (bao.height - bao.H) / 2) / C;
        //System.out.println(cx + "; " + cy + " : " + colli[cy][cx]);
        switch (type) {
            case 37:
                synchronized (Unit.units) {
                    for (Unit u : Unit.units)
                        if (!u.team && u.isOn(x + posX, y + posY)) {
                            GameObject.selec = u;
                            return;
                        }
                }
                synchronized (Building.buildings) {
                    for (Building b : Building.buildings)
                        if (!b.team && b.isOn(x + posX, y + posY)) {
                            GameObject.selec = b;
                            return;
                        }
                }
                GameObject.selec = null;
                break;
            case 39:
                if (GameObject.selec != null && GameObject.selec.cw == 1) {
                    Unit u = (Unit) GameObject.selec;
                    if (colli[cy][cx]) {
                        u.path = astar.astar(World.colli, new Elements(0, 0, u.cx, u.cy, null), new Elements(0, 0, cx, cy, null));
                        u.pGold = false;
                        u.pWood = false;
                    }
                    else
                        switch (tabDat[0][cy][cx]) {
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                                u.product(cx, cy, true);
                                break;
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                                u.product(cx, cy, false);
                                break;
                        }
                }
                break;
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        x = (int) getRX(x);
        y = (int) getRY(y);
        if (x <= 0)
            moveX = -1;
        else if (x >= w - 1)
            moveX = +1;
        else
            moveX = 0;
        if (y <= 0)
            moveY = -1;
        else if (y >= h - 1)
            moveY = +1;
        else
            moveY = 0;
    }
}
