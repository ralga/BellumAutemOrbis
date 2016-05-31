package BellumAutemOrbis.View;

import BellumAutemOrbis.BellumAutemOrbis;
import BellumAutemOrbis.GraphicObject.*;

public class Menu2 extends View
{
    public Menu2()
    {
        BellumAutemOrbis bao = BellumAutemOrbis.bao;
        tabGrO.add(new Background(bao, 1));
        tabGrO.add(new Text(bao, bao.W / 2 - 300, bao.H / 2 - 350, 600, 350, 75, "Equipe", "Dragon_Caps.ttf", 255));
        tabGrO.add(new Button(bao, new Text(bao, bao.W / 2 - 150, bao.H / 2 - 50, 300, 160, 100, "Elfe", "Alice_in_Wonderland_3.ttf", 0), 2));
        tabGrO.add(new Button(bao, new Text(bao, bao.W / 2 - 150, bao.H / 2 + 180, 300, 160, 100, "Orc", "Alice_in_Wonderland_3.ttf", 0), 3));
    }
}