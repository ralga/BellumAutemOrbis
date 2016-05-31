package BellumAutemOrbis.PathFinding;

import java.util.LinkedList;

public class Astar {

    private LinkedList<Elements> closedList;
    private PriorityQueue openList;

    public LinkedList<int[]> astar(boolean[][] tab, Elements dep, Elements arr) {
        closedList = new LinkedList();
        openList = new PriorityQueue();
        openList.add(dep);
        while (!openList.isEmpty()) {
            Elements u = openList.popOut();
            if (u.getX() == arr.getX() && u.getY() == arr.getY()) {
                closedList.add(u);
                arr.setPred(u);
                return toArray(closedList, arr);
            }

            Elements v = new Elements(u.getCout() + 1, u.getCout() + 1 + 2*distance(u.getX(), u.getY() + 1, arr), u.getX(), u.getY() + 1, u);
//            testing(u,v);
            try {
                if (tab[v.getY()][v.getX()] && (((!contains(closedList, v) || getX(v)/*!(getX(v)||getY(v)))*/))
                        || (!openList.exist(v.getX(), v.getY()) || getY(v))))
                    openList.add(v);
            v = new Elements(u.getCout() + 1, u.getCout() + 1 + 2*distance(u.getX(), u.getY() - 1, arr), u.getX(), u.getY() - 1, u);
                if (tab[v.getY()][v.getX()] && (((!contains(closedList, v) || getX(v)/*!(getX(v)||getY(v)))*/))
                        || (!openList.exist(v.getX(), v.getY()) || getY(v))))
                    openList.add(v);
//            
            v = new Elements(u.getCout() + 1, u.getCout() + 1 + 2*distance(u.getX() + 1, u.getY(), arr), u.getX() + 1, u.getY(), u);
                if (tab[v.getY()][v.getX()] && (((!contains(closedList, v) || getX(v)/*!(getX(v)||getY(v)))*/))
                        || (!openList.exist(v.getX(), v.getY()) || getY(v))))
                    openList.add(v);
//            
            v = new Elements(u.getCout() + 1, u.getCout() + 1 + 2*distance(u.getX() - 1, u.getY(), arr), u.getX() - 1, u.getY(), u);
                if (tab[v.getY()][v.getX()] && (((!contains(closedList, v) || getX(v)/*!(getX(v)||getY(v)))*/))
                        || (!openList.exist(v.getX(), v.getY()) || getY(v))))
                    openList.add(v);
            }
            catch (ArrayIndexOutOfBoundsException e) {
//                System.out.println("out of bound");
            }

            closedList.add(u);
        }
        return toArray(closedList, arr);
    }

    private void testing(Elements u, Elements v) {
        if (!contains(closedList, v))
            if (!openList.exist(v.getX(), v.getY()))
                openList.add(v);
            else if (openList.get(v.getX(), v.getY()).getHeuristique()> v.getHeuristique())
                v.setPred(u);

    }

    private boolean getX(Elements v) {
        return (contains(closedList, v) && (v.getHeuristique() < getElt(closedList, v.getX(), v.getY()).getHeuristique()));

    }

    private boolean getY(Elements v) {
        return (openList.exist(v.getX(), v.getY()) && v.getHeuristique() < openList.getElt(v.getX(), v.getY()).getHeuristique());
    }

    private Elements getElt(LinkedList<Elements> list, int x, int y) {
        for (Elements e : list)
            if (e.getX() == x && e.getY() == y)
                return e;
        return null;
    }

    private int distance(int x, int y, Elements arr) {
//        return (int) Math.sqrt((double) (Math.pow(arr.getX() - x, 2) + Math.pow(arr.getY() - y, 2)));
        return Math.abs(x - arr.getX()) + Math.abs(y - arr.getY());
    }

    private boolean contains(LinkedList<Elements> l, Elements n) {
        for (Elements p : l)
            if (p.getX() == n.getX() && p.getY() == n.getY())
                return true;
        return false;
    }

    private LinkedList<int[]> toArray(LinkedList<Elements> closedList, Elements arr) {
        LinkedList<int[]> tab = new LinkedList<>();
        Elements e = arr;
        while (e.getPred() != null) {
            int[] poney = {e.getX(), e.getY()};
            tab.addFirst(poney);
            e = e.getPred();
        }
        int[] poney = {arr.getX(), arr.getY()};
        tab.add(poney);
        return tab;
    }

}