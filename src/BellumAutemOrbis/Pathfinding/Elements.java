package BellumAutemOrbis.Pathfinding;

public class Elements/*<T>*/ {

//    private final T elt;
    private final int x, y;
    private int prio;
    private int heuristique;
    private Elements pred;

    public Elements(/*T elt, */int prio, int heuristique, int x, int y,Elements q) {
//        this.elt = elt;
        this.prio = prio;
        this.x = x;
        this.y = y;
        this.heuristique = heuristique;
        this.pred=q;
    }

    //Getters 
    public int getHeuristique() {
        return this.heuristique;
    }
//    public T getElt() {return elt;}

    public int getCout() {
        return prio;
    }

    public int getX() {
        return x;
    }

    public Elements getPred(){
        return this.pred;
    }
    
    public int getY() {
        return y;
    }

    //Setters
    public void setCout(int prio) {
        this.prio = prio;
    }

    public void setPred(Elements n){
        this.pred=n;
    }
    
    public void setHeuristique(int heur) {
        this.heuristique = heur;
    }
}
