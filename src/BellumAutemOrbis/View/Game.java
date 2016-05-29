package BellumAutemOrbis.View;

import BellumAutemOrbis.*;
import BellumAutemOrbis.GameObject.Unit;
import BellumAutemOrbis.GraphicObject.*;

public class Game extends View 
{
    public Game()
    {
        BellumAutemOrbis bao = BellumAutemOrbis.bao;
        //tabGrO = new GraphicObject[3];
        tabGrO.add(new World(bao, 0, 0));
        tabGrO.add(new Unit(bao, 3, false, 0, 0));
        tabGrO.add(new UI(bao, 1, bao.H/4 * 3, bao.W, bao.H/4));
        tabGrO.add(new ATH(bao, (int)(bao.W/9. * 8), 0, bao.W/9, bao.H/25));
        //tabGrO[0] = new World(bao, 30, 30);
        //tabGrO[1] = new UI(bao, 0, bao.H/4 * 3, bao.W, bao.H/4);
        //tabGrO[2] = new ATH(bao, (int)(bao.W/9. * 8), 0, bao.W/9, bao.H/25);
    }
}