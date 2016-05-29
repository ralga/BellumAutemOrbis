package BellumAutemOrbis.Pathfinding;

import java.util.LinkedList;

public class Astar {

    private LinkedList<Elements> closedList;
    private PriorityQueue openList;

    public LinkedList<Elements> astar(boolean[][] tab, Elements dep, Elements arr) {
        closedList = new LinkedList();
        openList = new PriorityQueue();
        openList.add(dep);
        while(!openList.isEmpty()){
            Elements u = openList.popOut();
            if(u.getX()==arr.getX() && u.getY()==arr.getY()){
                closedList.add(u);
                return closedList;
            }
            Elements v = new Elements(u.getCout()+1,u.getCout()+1+distance(u.getX(), u.getY()+1,arr),u.getX(), u.getY()+1);
               if(!((contains(closedList,v)&&v.getCout()< openList.getElt(v.getX(),v.getY()).getCout())||
                       (openList.exist(v.getX(), v.getY())&&v.getCout()< openList.getElt(v.getX(), v.getY()).getCout()))
                       && tab[v.getX()][v.getY()])
                    openList.add(v);
               v=new Elements(u.getCout()+1,u.getCout()+1+distance(u.getX(), u.getY()-1,arr),u.getX(), u.getY()-1);
               if(!((contains(closedList,v)&&v.getCout()< openList.getElt(v.getX(),v.getY()).getCout())||
                       (openList.exist(v.getX(), v.getY())&&v.getCout()< openList.getElt(v.getX(), v.getY()).getCout()))
                       && tab[v.getX()][v.getY()])
                    openList.add(v);
               v=new Elements(u.getCout()+1,u.getCout()+1+distance(u.getX()+1, u.getY(),arr),u.getX()+1, u.getY());
               if(!((contains(closedList,v)&&v.getCout()< openList.getElt(v.getX(),v.getY()).getCout())||
                       (openList.exist(v.getX(), v.getY())&&v.getCout()< openList.getElt(v.getX(), v.getY()).getCout()))
                       && tab[v.getX()][v.getY()])
                    openList.add(v);
               v=new Elements(u.getCout()+1,u.getCout()+1+distance(u.getX()-1, u.getY(),arr),u.getX()-1, u.getY());
               if(!((contains(closedList,v)&&v.getCout()< openList.getElt(v.getX(),v.getY()).getCout())||
                       (openList.exist(v.getX(), v.getY())&&v.getCout()< openList.getElt(v.getX(), v.getY()).getCout()))
                       && tab[v.getX()][v.getY()])
                    openList.add(v);
               closedList.add(u);
        }
        return null;
    }
    
    private int distance(int x, int y, Elements arr){
        return (int)Math.sqrt((double) (Math.pow(arr.getX()-x,2)+ Math.pow(arr.getY()-y,2)));
    }

    private boolean contains(LinkedList<Elements> l, Elements n){
        for(Elements p : l)
            if(p.getX()==n.getX() && p.getY()==n.getY())
                return true;
        return false;
    }
    
    
    
}
