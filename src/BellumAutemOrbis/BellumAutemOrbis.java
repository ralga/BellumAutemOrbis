package BellumAutemOrbis;

import BellumAutemOrbis.GraphicObject.*;
import BellumAutemOrbis.View.*;
import processing.core.PApplet;
import processing.event.MouseEvent;

public class BellumAutemOrbis extends PApplet {

    public final int W = 1280;
    public final int H = 720;
    public static final int FPS = 60;
    private final String TITLE = "Bellum Autem Orbis";
    private final boolean DEBUG = false;                                         //True : affiche des informations de debuggage et de performance

    public static BellumAutemOrbis bao;
    private int view;
    private View[] tabView;

    public static void main(String[] args) {
        PApplet.main(new String[]{BellumAutemOrbis.class.getName()});
    }

    public void initViews() {
        tabView = new View[3];
        tabView[0] = new Menu();
        
        tabView[2] = new Menu2();
    }

    public void initGame(){
        tabView[1] = new Game();
    }
    
    public void initGraphicObjects() {
        for (Object o : tabView[view].getTabGrO()) {
            GraphicObject grO = (GraphicObject) o;
            grO.init();
        }
    }

    @Override
    public void settings() //Paramétrage (appelé en premier)
    {
        bao = this;
        size(W, H, P2D);                                                        //Taille de la fenêtre
        //fullScreen(P2D);
    }

    @Override
    public void setup() {
        surface.setTitle(TITLE);
        frameRate(FPS);                                                         //Nombre d'images par seconde max

        initViews();
        setView(0);
//        new DynamicEvent((Game) tabView[1]).start();
    }

    @Override
    public void draw() {
        background(0);
        for (Object o : tabView[view].getTabGrO()) {
            GraphicObject grO = (GraphicObject) o;
            grO.draw();
        }
        if (DEBUG) //Si le mode debug est actif
        {
            fill(0);
            rect(0, 0, 100, 200);
            fill(255);
            text((int) (frameRate) + " FPS", 15, 25);
            text("posX = " + (mouseX - (width - W) / 2), 15, 45);
            text("posY = " + (mouseY - (height - H) / 2), 15, 65);
        }
    }

    @Override
    public void mousePressed(MouseEvent event) {
        for (Object o : tabView[view].getTabGrO()) {
            GraphicObject grO = (GraphicObject) o;
            grO.mousePressed(event.getX(), event.getY());
        }
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        for (Object o : tabView[view].getTabGrO()) {
            GraphicObject grO = (GraphicObject) o;
            grO.mouseMoved(event.getX(), event.getY());
        }
    }

    /*Getters*/
    public int getView() {
        return view;
    }

    /*Setters*/
    public void setView(int nView) {
        view = nView;
        initGraphicObjects();
    }
    
    public void tStart(){
        new DynamicEvent((Game) tabView[1]).start();
    }
}
