package BellumAutemOrbis.View;

import BellumAutemOrbis.BellumAutemOrbis;
import BellumAutemOrbis.GraphicObject.*;

public class Menu extends View {

    public Menu() {
        BellumAutemOrbis bao = BellumAutemOrbis.bao;
        tabGrO.add(new Background(bao, 0));
        tabGrO.add(new Text(bao, bao.W / 2 - 300, bao.H / 2 - 350, 600, 350, 75, "Bellum Autem Orbis", "Dragon_Caps.ttf", 255));
        tabGrO.add(new Button(bao, new Text(bao, bao.W / 2 - 200, bao.H / 2 - 30, 400, 200, 150, "Jouer", "Alice_in_Wonderland_3.ttf", 0), 0));
        tabGrO.add(new Button(bao, new Text(bao, bao.W / 2 - 150, bao.H / 2 + 200, 300, 130, 80, "Quitter", "Alice_in_Wonderland_3.ttf", 0), 1));

    }
}
