package it.uniba.main.Dama;

import java.util.ArrayList;

/**
 *  <<Entity>>
 *  Classe rappresentante una mossa di gioco.
 *  Ha i seguenti attributi:
 *  - corretta: vero solo se il controllore ValidatoreMossa accetta comando come semanticamente corretta;
 *  - valida: vero solo se il controllore ValidatoreMossa accetta comando come conforme alle regole della Dama Italiana;
 *  - comando: ultima mossa effettuata, in formato String, che deve essere interpretata dal validatore;
 *  - giocatore: colore del giocatore che effettua la mossa;
 *  - tipo: il tipo di mossa effettuata;
 *  - caselle: indica le caselle coinvolte nella mossa di gioco;
 *  - daEliminare: caselle dalle quali rimuovere una pedina;
 *  - registroMosse: lista contenente tutte le mosse valide effettuate, in formato String.
 */
public class Mossa {
    private static ArrayList<Mossa> registroMosse = new ArrayList<>();
    private String comando;
    private String tipo; //tipo mossa
    private char giocatore; //giocatore che effettua la mossa
    private boolean corretta;
    private boolean valida;
    private int[] daEliminare; //caselle dalle quali rimuovere una pedina
    private int[] caselle; //indica le caselle coinvolte nella mossa di gioco

    public Mossa(final String mossaLetta, final Campo c) {
        comando = mossaLetta;
        avvalora(new ValidatoreMossa(comando, c));
        if (c.getBianco().isTurno()) {
            giocatore = c.getBianco().getColore();
        } else if (c.getNero().isTurno()) {
            giocatore = c.getNero().getColore();
        } else {
            valida = false;
        }
        if (valida) {
            registraMossa();
        }
    }

    public final String getComando() {
        return comando; }
    public final char getGiocatore() {
        return giocatore; }
    public final boolean isPresa() {
        return tipo.equals("presa"); }
    public final boolean isSpostamento() {
        return tipo.equals("spostamento"); }
    public final boolean isCorretta() {
        return corretta; }
    public final boolean isValida() {
        return valida; }
    public final int[] getCaselle() {
        int[] c = caselle;
        return c;
    } //indica le caselle coinvolte nella mossa di gioco
    public final int[] getDaEliminare() {
        int[] e = daEliminare;
        return e;
    } //caselle dalle quali rimuovere una pedina

    //convalida e avvalora Mossa tramite un controllore ValidatoreMossa
    private void avvalora(final ValidatoreMossa vm) {
        corretta = vm.isCorretta();
        valida = vm.isValida();
        daEliminare = vm.getDaEliminare();
        caselle = vm.getCaselle();
        if (vm.isPresa()) {
            tipo = "presa";
        } else if (vm.isSpostamento()) {
            tipo = "spostamento";
        }
    }

    //metodo che registra le mosse effettuate dai giocatori all'interno di registroMosse
    private void registraMossa() {
        registroMosse.add(this); }
    public static ArrayList<Mossa> getRegistroMosse() {
        return registroMosse; }
    public static void resetRegistroMosse() {
        registroMosse.clear(); }
}
