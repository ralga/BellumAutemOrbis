/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BellumAutemOrbis.Pathfinding;

class Tas {
  static final int INITIAL_SIZE = 1;
  Elements[] e;
  int nb = 0;
  
  Tas() {
    nb = 0;
    e = new Elements[INITIAL_SIZE];
  }
  
  static int filsGauche(int i) {
    return 2*i+1;
  }
  
  static int frereDroit(int i) {
    return i+1;
  }
  
  static int pere(int i) {
    return (i-1)/2;
  }

  boolean singleton() {
    return nb == 1;
  }
  
  void ajouter(Elements nouveauNoeud) {
    if (nb == e.length) {
      Elements[] nouveauTableau = new Elements[e.length*2];
      System.arraycopy(e,0,nouveauTableau,0,e.length);
      e = nouveauTableau;
    }
    int i;
    for (i=nb;i>0 && e[pere(i)].moinsPriotaireQue(nouveauNoeud);i=pere(i)) {
      e[i] = e[pere(i)];
    }
    e[i] = nouveauNoeud;
    nb++;
  }
  
  Elements retirer() throws TasVideException {
    if (nb == 0) {
      throw new TasVideException();
    }
    nb--;
    Elements noeudMoinsFrequent = e[0];
    Elements noeudAReplacer = e[nb];
    e[nb] = null;
    int i;
    for (i=filsGauche(0); i<nb; i = filsGauche(i)) {
      if (frereDroit(i)< nb && e[frereDroit(i)].plusPrioritaireQue(e[i])) {
        i = frereDroit(i);
      }
      if (noeudAReplacer.plusPrioritaireQue(e[i])) {
        break;
      }
      e[pere(i)] = e[i];
    }
    e[pere(i)] = noeudAReplacer;
    return noeudMoinsFrequent;
  }

    private static class TasVideException extends Exception {

        public TasVideException() {
        }
    }
}

