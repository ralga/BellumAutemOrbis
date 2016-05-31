package BellumAutemOrbis;

import BellumAutemOrbis.GameObject.Building;
import BellumAutemOrbis.GameObject.Unit;
import BellumAutemOrbis.GraphicObject.*;
import BellumAutemOrbis.View.*;
import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class BellumAutemOrbis extends PApplet
{
    public final int W = 1280;
    public final int H = 720;
    public static final int FPS = 60;
    private final String TITLE = "Bellum Autem Orbis";
    private final boolean DEBUG = true;                                         //True : affiche des informations de debuggage et de performance
    private Team team;

    
    public static BellumAutemOrbis bao;
    public int view;
    private View[] tabView;
    
    public static void main(String[] args) 
    {
        PApplet.main(new String[]{BellumAutemOrbis.class.getName()});
    }
    
    public void initViews()
    {
        tabView = new View[3];
        tabView[0] = new Menu();
        tabView[1] = new Game();
        tabView[2] = new Menu2();
    }
    
    private void initGraphicObjects()
    {
        for(Object o : tabView[view].getTabGrO())
        {
            GraphicObject grO = (GraphicObject)o;
            grO.init();
        }
    }
    
    private void initGameObjects()
    {
        for(Unit u : Unit.units)
            u.init();
    }
    
    public void startGame(boolean race)
    {
        if(race)
        {
            Unit.units.add(new Unit(bao, 6, 8, 8, false));
            Building.buildings.add(new Building(bao, 1, 10, 8, false));
        }
        else
        {
            Unit.units.add(new Unit(bao, 1, 8, 8, false));
            Building.buildings.add(new Building(bao, 0, 10, 8, false));
        }
        team = new Team(false,race);
        new DynamicEvent((Game) tabView[1]).start();
        UI.ui = race ? 1 : 0;
        UI.font = race ? UI.font2 : UI.font1;
    }
    
    public void reset()
    {
        World.posX = 0;
        World.posY = 0;
        Unit.selec = null;
        Unit.units.removeAll(Unit.units);
        Building.buildings.removeAll(Building.buildings);
    }
    
    @Override
    public void settings()                                                      //Paramétrage (appelé en premier)
    {
        bao = this;
        size(W, H, P2D);                                                             //Taille de la fenêtre
//        fullScreen(P2D);
    }
    
    @Override
    public void setup()
    {
        surface.setTitle(TITLE);
        frameRate(FPS);                                                         //Nombre d'images par seconde max
        
        initViews();
        setView(0);
    }
    
    @Override
    public void draw()
    {
        background(0);
        for(Object o : tabView[view].getTabGrO())
        {
            GraphicObject grO = (GraphicObject)o;
            grO.draw();
        }
        if(DEBUG)                                                               //Si le mode debug est actif
        {
            fill(0);
            rect(0, 0, 100, 200);
            fill(255);
            text((int)(frameRate) + " FPS", 700, 25);
            text("posX = " + (mouseX - (width-W)/2), 15, 45);
            text("posY = " + (mouseY - (height-H)/2), 15, 65);
        }
    }

    @Override
    public void mousePressed(MouseEvent event) 
    {
        System.out.println(event.getButton());
        for(Object o : tabView[view].getTabGrO())
        {
            GraphicObject grO = (GraphicObject)o;
            grO.mousePressed(event.getX(), event.getY(), event.getButton());
        }
    }

    @Override
    public void mouseMoved(MouseEvent event)
    {
        for(Object o : tabView[view].getTabGrO())
        {
            GraphicObject grO = (GraphicObject)o;
            grO.mouseMoved(event.getX(), event.getY());
        }
    }

    @Override
    public void keyPressed(KeyEvent event)
    {
        //System.out.println(event.getKeyCode());
        switch(event.getKeyCode())
        {
            case 8:                                                             //Bouton retour
                DynamicEvent.stop = true;                                       //Arrêt du Thread
                reset();
                setView(0);
                break;
        }
    }
    
    /*Getters*/
    public int getView(){return view;}
    
    public Team getTeam(){return team;}
    
    /*Setters*/
    public void setView(int nView)
    {
        if(nView == 1)
            initGameObjects();
        view = nView;
        initGraphicObjects();
    }
}
