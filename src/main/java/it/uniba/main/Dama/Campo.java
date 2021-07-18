package it.uniba.main.Dama;

import it.uniba.main.Costanti.Colori;
import it.uniba.main.Costanti.Simboli;
import it.uniba.main.InterfacciaUtente.ComunicazioneEsterna;

/**
 *  <<Entity>>
 *  La classe Campo rappresenta il campo di gioco. Il Campo è composto da:
 *  - matrice: una matrice 8x8 di tipo Casella;
 *  - nero: giocatore di colore nero (N) che controlla pedine nere (N);
 *  - bianco: giocatore di colore bianco (B) che controlla pedine bianche (B);
 *  - MAX_MATRICE: limite caselle orizzontali
 *  - MAX_SCACCHIERA: massimo numero caselle valide
 */
public class Campo {
    private Casella[][] matrice;
    private Giocatore nero;
    private Giocatore bianco;
    private static final int MAX_MATRICE = 8;
    private static final int MAX_SCACCHIERA = 32;

    public Campo() {
        matrice = new Casella[MAX_MATRICE][MAX_MATRICE];
        nero = new Giocatore('N');
        bianco = new Giocatore('B');
        inizializza();
        predispondiPedine();
    }

    public final Casella getCasella(final int i, final int j) {
        //controllo e eccezione
        return matrice[i][j];
    }

    //Restituisce una casella avente il codice preso in input
    public final Casella getCasella(final int codiceCasella) {
        Casella c = new Casella();
        if (codiceCasella >= 1 && codiceCasella <= MAX_SCACCHIERA) {
            for (int i = 0; i < MAX_MATRICE; i++) {
                for (int j = 0; j < MAX_MATRICE; j++) {
                    if (matrice[i][j].getCodice() == codiceCasella) {
                        c = matrice[i][j];
                    }
                }
            }
        }
        return c;
    }

    public final Giocatore getBianco() {
        return bianco;
    }

    public final Giocatore getNero() {
        return nero;
    }

    public final Casella[][] getMatrice() {
        Casella[][] m = matrice;
        return m;
    }





    //Restituisce la coordinata x della casella avente codice preso in input
    public final int coordinataX(final int codiceCasella) {
        int x = 0;
        for (int i = 0; i < MAX_MATRICE; i++) {
            for (int j = 0; j < MAX_MATRICE; j++) {
                if (matrice[i][j].getCodice() == codiceCasella) {
                    x = matrice[i][j].getX();
                }
            }
        }
        return x;
    }

    //Restituisce la coordinata y della casella avente codice preso in input
    public final int coordinataY(final int codiceCasella) {
        int y = 0;
        for (int i = 0; i < MAX_MATRICE; i++) {
            for (int j = 0; j < MAX_MATRICE; j++) {
                if (matrice[i][j].getCodice() == codiceCasella) {
                    y = matrice[i][j].getY();
                }
            }
        }
        return y;
    }

    //Prende in input il codice di una casella ed elimina la pedina sopra se presente.
    //Tale pedina è messa nelle prese del giocatore opposto al colore della pedina
    public final void eliminaPedina(final int codiceCasella) {
        int x = coordinataX(codiceCasella);
        int y = coordinataY(codiceCasella);
        char c;
        if (matrice[x][y].getP() != null) {
            c = matrice[x][y].getP().getColore();
            if (c == 'B') {
                getNero().addPedina(matrice[x][y].getP());
            } else if (c == 'N') {
                getBianco().addPedina(matrice[x][y].getP());
            }

            matrice[x][y].setP(null);
        }
    }

    //Prende in input il codice di due caselle ed effettua lo spostamento della pedina
    //in posizione partenza nella casella di arrivo
    public final void spostaPedina(final int partenza, final int arrivo) {
        int partenzaX = coordinataX(partenza);
        int partenzaY = coordinataY(partenza);
        int arrivoX = coordinataX(arrivo);
        int arrivoY = coordinataY(arrivo);
        sposta(partenzaX, partenzaY, arrivoX, arrivoY);
    }

    private void sposta(final int partenzaX, final int partenzaY, final int arrivoX, final int arrivoY) {
        matrice[arrivoX][arrivoY].setP(matrice[partenzaX][partenzaY].getP());
        matrice[partenzaX][partenzaY].setP(null);
    }

    //metodo che promuove una pedina a dama se si trova sul lato opposto della damiera
    public final void promozione() {
        final int[] casellePromozioneBianco = {1, 2, 3, 4};
        final int[] casellePromozioneNero = {29, 30, 31, 32};
        //le bianche sono promosse se si trovano nelle caselle 1,2,3 o 4
        //le nere sono promosse se si trovano nelle caselle 29,30,31 o 32

        for (int i : casellePromozioneBianco) {
            if (checkPromozioneIdonea(i, 'B')) {
                promuoviPedina(getCasella(i).getP());
                ComunicazioneEsterna.avvisoPromozione();
            }
        }
        for (int i : casellePromozioneNero) {
            if (checkPromozioneIdonea(i, 'N')) {
                promuoviPedina(getCasella(i).getP());
                ComunicazioneEsterna.avvisoPromozione();
            }
        }
    }

    //metodo che controlla se una pedina può diventare dama
    private boolean checkPromozioneIdonea(final int casella, final char colore) {
        if (getCasella(casella).getP() != null) {
            return getCasella(casella).getP().getColore() == colore && !getCasella(casella).getP().isDama();
        } else {
            return false;
        }
    }

    //promuove una pedina a dama
    private void promuoviPedina(final Pedina p) {
        p.setDama(true);
        if (p.getColore() == 'B') {
            p.setSimbolo(Simboli.DAMA_BIANCA);
        } else {
            p.setSimbolo(Simboli.DAMA_NERA);
        }

    }

    //Inizializza le caselle delle matrici. Ad ogni casella bianca "non valida" viene assegnato il valore 0.
    //Ad ogni casella nera (valida) viene assegnato un codice che varia da 1 a 32.
    private void inizializza() {
        int codice;
        codice = 0;
        for (int i = 0; i < MAX_MATRICE; i++) {
            for (int j = 0; j < MAX_MATRICE; j++) {
                matrice[i][j] = new Casella();
                matrice[i][j].setX(i);
                matrice[i][j].setY(j);
                if (i % 2 == 0 && j % 2 == 0) {
                    matrice[i][j].setCodice(codice + 1);
                    codice++;
                }
                if (i % 2 != 0 && j % 2 != 0) {
                    matrice[i][j].setCodice(codice + 1);
                    codice++;
                }
            }
        }
    }

    //Predispone le pedine sulla damiera. Dalla riga 0 alla riga 2 inserisce nelle caselle nere le pedine del
    //giocatore nero. Dalla riga 5 alla riga 7 inserisce le pedine del giocatore bianco. Incrementa ad ogni inserimento
    //il numero delle pedine sul campo.
    private void predispondiPedine() {
        for (int i = 0; i < MAX_MATRICE; i++) {
            for (int j = 0; j < MAX_MATRICE; j++) {
                final int latoNero = 3; //fino alla terza riga, si posizoinano pedine nere
                final int latoBianco = 4; //a partire dalla quinta riga, si posizionano pedine bianche
                if (i < latoNero) {
                    if (i % 2 == 0 && j % 2 == 0) {
                        matrice[i][j].setP(new Pedina('N', Simboli.PEDINA_NERA));

                    }
                    if (i % 2 != 0 && j % 2 != 0) {
                        matrice[i][j].setP(new Pedina('N', Simboli.PEDINA_NERA));

                    }
                }

                if (i > latoBianco) {
                    if (i % 2 != 0 && j % 2 != 0) {
                        matrice[i][j].setP(new Pedina('B', Simboli.PEDINA_BIANCA));

                    }
                    if (i % 2 == 0 && j % 2 == 0) {
                        matrice[i][j].setP(new Pedina('B', Simboli.PEDINA_BIANCA));
                    }
                }
            }
        }
    }

    //Overriding
    public final String toString() {
        StringBuilder s = new StringBuilder();
        s.append(stampaBordoAlto());
        final int limiteStampa = 7;
        for (int i = 0; i < MAX_MATRICE; i++) {
            s.append("\n");
            s.append(stampaRigaDamieraConPedine(i));
            s.append("\n");
            if (i < limiteStampa) {
                s.append(stampaBordoCentrale());
            }
        }
        s.append(stampaBordoBasso());
        return s.toString();

    }

    private String stampaBordoAlto() {
        final int limiteStampa = 7;
        StringBuilder s = new StringBuilder();
        s.append("┌─────");
        for (int i = 0; i < limiteStampa; i++) {
            s.append("┬─────");
        }
        s.append("┬");
        return s.toString();
    }

    private String stampaRigaDamieraConPedine(final int riga) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < MAX_MATRICE; i++) {
            if (matrice[riga][i].getCodice() != 0 && matrice[riga][i].getP() != null) {
                if (matrice[riga][i].getP().getColore() == 'N') {
                    s.append("│ " + Colori.ANSI_BLACK + Colori.ANSI_RED_BACKGROUND + " "
                            + matrice[riga][i].getP().getSimbolo() + " "
                            + Colori.ANSI_RESET + " ");
                } else {
                    s.append("│ " + Colori.ANSI_WHITE + Colori.ANSI_RED_BACKGROUND + " "
                            + matrice[riga][i].getP().getSimbolo() + " "
                            + Colori.ANSI_RESET + " ");
                }
            } else {
                if (riga % 2 == 0  &&   i % 2 != 0) {
                    s.append("│ " + Colori.ANSI_WHITE_BACKGROUND + "   " + Colori.ANSI_RESET + " ");
                } else if (riga % 2 != 0  &&  i % 2 == 0) {
                    s.append("│ " + Colori.ANSI_WHITE_BACKGROUND + "   " + Colori.ANSI_RESET + " ");
                } else {
                    s.append("│ " + Colori.ANSI_RED_BACKGROUND + "   " + Colori.ANSI_RESET + " ");
                }
            }
        }
        s.append("│");
        return s.toString();
    }

    private String stampaBordoCentrale() {
        final int limiteStampa = 7;
        StringBuilder s = new StringBuilder();
        s.append("├─────");
        for (int i = 0; i < limiteStampa; i++) {
            s.append("┼─────");
        }
        s.append("┤");
        return s.toString();
    }

    private String stampaBordoBasso() {
        final int limiteStampa = 7;
        StringBuilder s = new StringBuilder();
        s.append("└─────");
        for (int i = 0; i < limiteStampa; i++) {
            s.append("┴─────");
        }
        s.append("┘");
        return s.toString();
    }

}
