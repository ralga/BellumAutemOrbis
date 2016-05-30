package BellumAutemOrbis.GraphicObject;

import BellumAutemOrbis.BellumAutemOrbis;
import BellumAutemOrbis.GameObject.Unit;
import processing.core.PGraphics;

public class World extends GraphicObject {

    public static World world;
    public static boolean[][] colli = new boolean[50][50];
    private static final String IMGPATH = "res/img/world/";
    private static final String DATPATH = "res/dat/world/";
    public static final int C = 40;
    public final int SCALE = 3;
    public final int W = 50 * C;
    public final int H = 50 * C;
    public static int posX;
    public static int posY;
    public int moveX;
    public int moveY;
    private PGraphics img;

    public World(BellumAutemOrbis bao, int x, int y) {
        super(bao, 0, 0, bao.W, bao.H, IMGPATH, DATPATH);
        posX = x;
        posY = y;
        world = this;
        initCollision();
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
    public void mousePressed(int x, int y) {
        if (!isOn(x, y) || y > (bao.height - bao.H) / 2 + 3 * bao.H / 4)
            return;
        int cx = (posX + x - (bao.width - bao.W) / 2) / C;
        int cy = (posY + y - (bao.height - bao.H) / 2) / C;
        System.out.println(cx + "; " + cy);
        for (Unit u : Unit.units)
            if (!u.team && u.cx == cx && u.cy == cy) {
                Unit.selec = u;
                return;
            }
        Unit.selec = null;
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
    
    public static void initCollision()
    {
        for(int i = 0; i < colli.length; i++)
            for(int j = 0; j < colli[i].length; j++)
                if(world.tabDat[1][0][world.tabDat[0][i][j]] == 1)
                    colli[i][j] = true;
    }
}
