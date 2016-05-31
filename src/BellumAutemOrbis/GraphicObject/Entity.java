package BellumAutemOrbis.GraphicObject;

import BellumAutemOrbis.BellumAutemOrbis;
import BellumAutemOrbis.GameObject.Building;
import BellumAutemOrbis.GameObject.Unit;
import java.util.ArrayList;

public class Entity extends GraphicObject
{
    private final ArrayList tabGO = new ArrayList();
    
    public Entity(BellumAutemOrbis bao)
    {
        super(bao, 0, 0, 0, 0);
    }

    @Override
    public void init()
    {}

    @Override
    public void draw()
    {
        if(bao.view == 1)
        {
            synchronized(Unit.units)
            {    
                for(Unit u : Unit.units)
                    u.draw();
            }
            synchronized(Building.buildings)
            {    
                for(Building b : Building.buildings)
                    b.draw();
            }
        }
    }

    @Override
    public void mousePressed(int x, int y, int type)
    {}

    @Override
    public void mouseMoved(int x, int y)
    {}
    
}
