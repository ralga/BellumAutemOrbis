package BellumAutemOrbis.GraphicObject;
 
import BellumAutemOrbis.BellumAutemOrbis;
import java.io.File;
import processing.core.*;
import static processing.core.PConstants.ARGB;
 
public abstract class GraphicObject
{   
    private static final String[] IMG_EXT = {".png", ".jpg", ".gif"};      //Extensions d'image autorisées
    protected final BellumAutemOrbis bao;
    public float x;
    public float y;
    protected int w;
    protected int h;
    protected PImage[] tabImg;
    public int[][][] tabDat;
     
    protected GraphicObject(BellumAutemOrbis bao, int x, int y, int w, int h)
    {
        this.bao = bao;
        this.x = (bao.width-bao.W) / 2 + x;
        this.y = (bao.height-bao.H) / 2 + y;
        this.w = w;
        this.h = h;
    }
     
    protected GraphicObject(BellumAutemOrbis bao, int x, int y, int w, int h, String path)
    {
        this(bao, x, y, w, h);
        tabImg = loadImages(path);
    }
    
    protected GraphicObject(BellumAutemOrbis bao, int x, int y, int w, int h, String imgPath, String datPath)
    {
        this(bao, x, y, w, h, imgPath);
        tabDat = loadData(datPath);
    }
     
    private PImage[] loadImages(String path)                                    //Charge un dossier d'image dans un tableau de PImage
    {
        String na;
        File[] files = new File(path).listFiles();
        PImage[] imgs = new PImage[files.length];
        for(int i = 0, ind; i < files.length; i++)
        {
            na = files[i].getName();
            String ext = na.substring(na.lastIndexOf("."));
            for(String a_ext : IMG_EXT)
                if(ext.equals(a_ext))  
                    try
                    {
                        ind = Integer.parseInt(na.substring(0, na.lastIndexOf(".")));
                        imgs[ind] = bao.loadImage(path + na);
                    }
                    catch(Exception e){}
        }
        return imgs;
    }
    
    protected PImage[][]cut(PImage base, int w, int h)
    {
        PImage[][] tfin = new PImage[base.height/w][base.width/h];
        for(int i = 0; i < base.height/w; ++i)
            for(int j = 0; j < base.width/h; ++j)
            {
                tfin[i][j] = bao.createImage(w, h, ARGB);
                tfin[i][j].copy(base, j*w, i*h, w, h, 0, 0, w, h);
            }
        return tfin;
    }
    
    private int[][][] loadData(String path)
    {
        String na;
        File[] files = new File(path).listFiles();
        int[][][] data = new int[files.length][][];
        for(int i = 0, ind; i < files.length; i++)
        {
            na = files[i].getName();
            String ext = na.substring(na.lastIndexOf("."));
            if(ext.equals(".dat"))
            {   
                ind = Integer.parseInt(na.substring(0, na.lastIndexOf(".")));
                data[ind] = matrixTextFile(path + na);
            }
        }
        return data;
    }
    
    public int[][] matrixTextFile(String path)                                  //Charge un fichier texte constitué de nombres et dont la disposition s'effectue en matrice
    {
        String[] tabLine = bao.loadStrings(path);
        int[][] data = new int[tabLine.length][];
        for(int i = 0; i < tabLine.length; i++)
            data[i] = string2Int(tabLine[i]);
        return data;
    }
    
    public int[] string2Int(String ch)                                          //Convertit une chaine de caractère en tableau d'entiers
    {
        String[] tabCh = ch.split(" ");
        int tabI[] = new int[tabCh.length];
        for(int i = 0; i < tabI.length; i++)
            tabI[i] = Integer.parseInt(tabCh[i]);
        return tabI;
    }
 
    protected void image(PImage i, int rx, int ry)
    {
        bao.g.image(i, x + rx, y + ry);
    }
     
    protected void rect(int rx, int ry, int w, int h)
    {
        bao.g.rect(x + rx, y + ry, w, h);
    }
     
    protected void rect(int rx, int ry, int w, int h, int r)
    {
        bao.g.rect(x + rx, y + ry, w, h, r);
    }
    
    protected void ellipse(int rx, int ry, int w, int h)
    {
        bao.g.ellipseMode(PApplet.CENTER);
        bao.g.ellipse(x + rx, y + ry, w, h);
    }
     
    protected void text(String txt, int rx, int ry)
    {
        bao.textAlign(PApplet.CENTER);
        bao.g.text(txt, x + rx, y + ry);
    }
     
    public boolean isOn(int mx, int my)                                         //Renvoie true si le point (mx, my) appartient au GO
    {
        return (mx >= x) && (mx < x+w) && (my >= y) && (my < y+h);
    }
     
    /*Getters*/
    public float getX(){return x;}
    public float getY(){return y;}
    public int getW(){return w;}
    public int getH(){return h;}
    public float getRX(int px){return px - x;}                                    //Position relative en x
    public float getRY(int py){return py - y;}                                    //Position relative en y
     
    /*Abstract methods*/
    public abstract void init();                                                //Gestion de l'initialisation du composant graphique (appelé à chaque changement de View)
    public abstract void draw();                                                //Gestion de l'affichage du composant à l'aide de processing (appelé 60 fois par sec)
    public abstract void mousePressed(int x, int y);                            //Gestion des clics de souris (appelé à chaque clic sur le composant)
    public abstract void mouseMoved(int x, int y);                              //Gestion du mouvement de la souris (appelé à chaque mouvement sur le composant)
}