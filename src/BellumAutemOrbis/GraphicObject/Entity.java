package BellumAutemOrbis.GraphicObject;

import BellumAutemOrbis.BellumAutemOrbis;
import java.util.ArrayList;

public class Entity extends GraphicObject
{
    private final ArrayList tabGO = new ArrayList();
    
    public Entity(BellumAutemOrbis bao, int x, int y, int w, int h)
    {
        super(bao, x, y, w, h);
    }

    @Override
    public void init()
    {}

    @Override
    public void draw()
    {
        
    }

    @Override
    public void mousePressed(int x, int y)
    {}

    @Override
    public void mouseMoved(int x, int y)
    {}
    
}
