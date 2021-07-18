package it.uniba.main.Dama;

/**
 *  <<Entity>>
 *  La classe Casella rappresenta una generica cella della matrice che rappresenterà il Campo.
 *  Ha i seguenti attributi:
 *  - codice: 0 per le caselle non valide, da 1 a 32 per le valide;
 *  - x: coordinata di riga della Casella nel Campo
 *  - y: coordinata di colonna della Casella nel Campo
 *  - p: Pedina presente nella Casella, null se non è presente
 */

public class Casella {

    private int codice;
    private int x;
    private int y;
    private Pedina p;

    public Casella() {
        codice = 0;
        p = null;
    }

    public final int getCodice() {
        return codice;
    }
    public final void setCodice(final int pcodice) {
        this.codice = pcodice;
    }
    public final int getX() {
        return x;
    }
    public final int getY() {
        return y;
    }
    public final void setX(final int px) {
        this.x = px;
    }
    public final void setY(final int py) {
        this.y = py;
    }
    public final  Pedina getP() {
        return p;
    }
    public final void setP(final Pedina pp) {
        this.p = pp;
    }
//nota[CHECKSTYLE]: per evitare shadowing, si aggiunge un prefisso al parametro formale.
//per convenzione si aggiunge la 'p'
}
