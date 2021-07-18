package it.uniba.main.Dama;

/**
 *  <<Entity>>
 *  La classe Pedina rappresenta un oggetto che si muove sulla scacchiera solo in avanti. Ogni pedina ha:
 *  - colore: lo stesso del giocatore che controlla la pedina;
 *  - simbolo: un simbolo rappresentante la pedina;
 *  - attributo booleano dama: settato inizialmente a false,
 *      dama diventa true se la pedina raggiunge la base avversaria.
 */

public class Pedina {
    private char colore;
    private String simbolo;
    private boolean dama;

    public Pedina(final char c, final String s) {
        setColore(c);
        setDama(false);
        setSimbolo(s);
    }

    public final char getColore() {
        return colore; }

    public final void setColore(final char c) {
        this.colore = c;
    }

    public final boolean isDama() {
        return dama;
    }

    public final void setDama(final boolean d) {
        this.dama = d; }

    public final String getSimbolo() {
        return simbolo;
    }

    public final void setSimbolo(final String s) {
        this.simbolo = s;
    }

}
