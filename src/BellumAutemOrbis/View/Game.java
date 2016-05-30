package BellumAutemOrbis.View;

import BellumAutemOrbis.*;
import BellumAutemOrbis.GameObject.Unit;
import BellumAutemOrbis.GraphicObject.*;

public class Game extends View {

    public Game() {
        BellumAutemOrbis bao = BellumAutemOrbis.bao;
        tabGrO.add(new World(bao, 0, 0));
        tabGrO.add(new Unit(bao, 4, false, 4, 4));
        tabGrO.add(new UI(bao, 1, bao.H / 4 * 3, bao.W, bao.H / 4));
        tabGrO.add(new ATH(bao, (int) (bao.W / 9. * 8), 0, bao.W / 9, bao.H / 25));
    }
}
