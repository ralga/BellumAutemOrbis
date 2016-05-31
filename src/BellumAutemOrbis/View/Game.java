package BellumAutemOrbis.View;

import BellumAutemOrbis.*;
import BellumAutemOrbis.GraphicObject.*;

public class Game extends View 
{
    public Game()
    {
        BellumAutemOrbis bao = BellumAutemOrbis.bao;
        tabGrO.add(new World(bao, 0, 0));
        tabGrO.add(new Entity(bao));
        tabGrO.add(new UI(bao, 1, bao.H/4 * 3, bao.W, bao.H/4));
        tabGrO.add(new ATH(bao, bao.W - 300, 0, 300, 30));
    }
}