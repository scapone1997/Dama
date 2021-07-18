package it.uniba.main.Dama;

import java.util.LinkedList;

/**
 *  <<Control>>
 *  Classe rappresentante il validatore di una mossa di gioco. Si occupa di stabilire se la mossa effettuata è valida.
 *  Ha i seguenti attributi:
 *  - corretta: vero solo se lo stato dell'istanza descrive una mossa del tipo "nx ...x n" o "n-n" con 1 <= n <= 32
 *  - valida: vero solo se il controllore ValidatoreMossa accetta comando come conforme alle regole della Dama Italiana;
 *  - caselle: indica le caselle coinvolte nella mossa di gioco;
 *  - tipo: il tipo di mossa effettuata; valido solo se '-' o 'x' (spostamento o presa);
 *  - daEliminare: caselle dalle quali rimuovere una pedina.
 */
public class ValidatoreMossa {

    private int[] caselle;
    private char tipo;
    private boolean corretta;
    private boolean valida;
    private int[] daEliminare;

    public ValidatoreMossa(final String comando, final Campo c) {
        traduciMossa(comando);
        convalidaMossa(c);
    }

    public final boolean isPresa() {
        return tipo == 'x';
    }

    public final boolean isSpostamento() {
        return tipo == '-';
    }

    public final char getTipo() {
        return tipo;
    }

    public final int[] getCaselle() {
        int[] c = caselle;
        return c;
    }

    public final int[] getDaEliminare() {
        int[] e = daEliminare;
        return e;
    }

    public final boolean isCorretta() {
        return corretta;
    }

    public final boolean isValida() {
        return valida;
    }

    //Inizializza la mossa di default:
    // caselle = {0, 0, ..., 0}, corretta = false, tipo = '0'
    private void inizializza() {
        final int maxCaselle = 4;
        corretta = false;
        tipo = '0';
        caselle = new int[maxCaselle];
        daEliminare = new int[maxCaselle];
        for (int i = 0; i < maxCaselle; i++) {
            caselle[i] = 0;
        }
        for (int i = 0; i < maxCaselle; i++) {
            daEliminare[i] = 0;
        }
    }

    //Controlla che la stringa modificata dallo split sia effettivamente un numero intero
    //compreso nell'intervallo [1, 32] e non un qualsiasi altro carattere
    private boolean range(final String input) {
        final int maxRange = 32;
        LinkedList<String> rangeCaselle = new LinkedList<>();
        for (int i = 1; i <= maxRange; i++) {
            rangeCaselle.add(Integer.toString(i));
        }
        return rangeCaselle.contains(input);
    }


    //Traduce una qualsiasi stringa in una mossa del tipo "-" o "x". Per essere valida deve rispettare il formato
    //'numero-numero' o 'numero x numero..x numero'. Effettua dunque un controllo sintattico.
    private void traduciMossa(final String input) {
        String[] parts;
        inizializza();

        if (input.contains("-")) {
            parts = input.split("-");
            tipo = '-';
            corretta = true;
            if (parts.length == 2 && input.charAt(input.length() - 1) != '-') {
                for (int i = 0; i < parts.length && corretta; i++) {  //ergo: corretta==true
                    if (range(parts[i])) {
                        caselle[i] = Integer.parseInt(parts[i]);
                    } else {
                        inizializza();
                    }
                }
            } else {
                inizializza();
            }
        }

        if (input.contains("x")) {
            parts = input.split("x");
            tipo = 'x';
            corretta = true;
            for (int i = 0; i < parts.length && corretta; i++) {
                if (input.charAt(input.length() - 1) != 'x') {
                    if (range(parts[i])) { //ergo: if(range(parts[i])==true)
                        caselle[i] = Integer.parseInt(parts[i]);
                    } else {
                        inizializza();
                    }
                } else {
                    inizializza();
                }
            }
        }

    }

    //Legge in input il tipo di mossa (presa o spostamento) e chiama il metodo per la verifica dello spostamento/presa
    private void convalidaMossa(final Campo c) {
        valida = false;
        if (isCorretta()) { //ergo: if(isCorretta()==true)
            if (tipo == '-') {
                valida = isSpostamentoValido(c);
            } else if (tipo == 'x') {
                valida = isPresaValida(c);
            }
        }
    }

    //restituisce true la mossa spostamento in input è valida all'interno del campo c e ad un determinato turno
    private boolean isSpostamentoValido(final Campo c) {
        boolean valido = false;

        int codicePartenza = getCaselle()[0];
        int codiceArrivo = getCaselle()[1];
        int partenzaX = c.coordinataX(getCaselle()[0]);
        int partenzaY = c.coordinataY(getCaselle()[0]);
        int arrivoX = c.coordinataX(getCaselle()[1]);
        int arrivoY = c.coordinataY(getCaselle()[1]);

        if (c.getNero().isTurno() && c.getCasella(codicePartenza).getP()
                != null && c.getCasella(codicePartenza).getP().getColore() == 'N') {
            if (c.getCasella(codiceArrivo).getCodice() != 0 && c.getCasella(codiceArrivo).getP() == null) {
                if (((partenzaX + 1 == arrivoX) && ((partenzaY + 1 == arrivoY)))
                        || ((partenzaX + 1 == arrivoX) && ((partenzaY - 1 == arrivoY)))) {
                    valido = true;
                }
            }
        } else {
            if (c.getBianco().isTurno() && c.getCasella(codicePartenza).getP()
                    != null && c.getCasella(codicePartenza).getP().getColore() == 'B') {
                if (c.getCasella(codiceArrivo).getCodice() != 0 && c.getCasella(codiceArrivo).getP() == null) {
                    if (((partenzaX - 1 == arrivoX) && ((partenzaY + 1 == arrivoY)))
                            || ((partenzaX - 1 == arrivoX) && ((partenzaY - 1 == arrivoY)))) {
                        valido = true;
                    }
                }
            }
        }
        return valido;
    }

    //se nella diagonale (a, b) è presente la pedina dell'avversario allora aggiorna il vettore di validità
    //mettendo "true" inserendo inoltre la pedina dell'avversario nel vettore delle pedine da eliminare
    private void analizza(final Campo c, final int a, final int b, final int i,
                          final char color, final boolean[] vettValida) {
        if (c.getCasella(a, b).getP() != null && c.getCasella(a, b).getP().getColore() == color) {
            vettValida[i] = true;
            daEliminare[i] = c.getCasella(a, b).getCodice();
        }
    }

    private boolean isPresaValida(final Campo c) {
        boolean valido = false;
        int numero = 0;
        for (int i = 0; i < getCaselle().length; i++) {
            if (getCaselle()[i] != 0) {
                numero++;
            }
        }

        boolean[] vettPreseValide = new boolean[numero - 1];

        for (int j = 0; j < vettPreseValide.length; j++) {
            vettPreseValide[j] = false;
        }

        for (int i = 0; i < vettPreseValide.length; i++) {
            int codicePartenza = getCaselle()[i];
            int codiceArrivo = getCaselle()[i + 1];
            int partenzaX = c.coordinataX(getCaselle()[i]);
            int partenzaY = c.coordinataY(getCaselle()[i]);
            int arrivoX = c.coordinataX(getCaselle()[i + 1]);
            int arrivoY = c.coordinataY(getCaselle()[i + 1]);

            if (i == 0) {
                if (c.getNero().isTurno() && c.getCasella(codicePartenza).getP() != null
                        && c.getCasella(codicePartenza).getP().getColore() == 'N') {
                    if (c.getCasella(codiceArrivo).getCodice() != 0 && c.getCasella(codiceArrivo).getP() == null) {
                        if (partenzaX + 2 == arrivoX && partenzaY + 2 == arrivoY) {
                            analizza(c, partenzaX + 1, partenzaY + 1,  i, 'B', vettPreseValide);
                        } else if (partenzaX + 2 == arrivoX && partenzaY - 2 == arrivoY) {
                            analizza(c, partenzaX + 1, partenzaY - 1, i, 'B', vettPreseValide);
                        }
                    }
                }
                if (c.getBianco().isTurno() && c.getCasella(codicePartenza).getP()
                        != null && c.getCasella(codicePartenza).getP().getColore() == 'B') {
                    if (c.getCasella(codiceArrivo).getCodice() != 0 && c.getCasella(codiceArrivo).getP() == null) {
                        if (partenzaX - 2 == arrivoX && partenzaY + 2 == arrivoY) {
                            analizza(c, partenzaX - 1, partenzaY + 1, i, 'N', vettPreseValide);
                        } else if (partenzaX - 2 == arrivoX && partenzaY - 2 == arrivoY) {
                            analizza(c, partenzaX - 1, partenzaY - 1, i, 'N', vettPreseValide);
                        }
                    }
                }
            } else {
                if (c.getNero().isTurno() && vettPreseValide[i - 1]) {
                    if (c.getCasella(codiceArrivo).getCodice() != 0 && c.getCasella(codiceArrivo).getP() == null) {
                        if (partenzaX + 2 == arrivoX && partenzaY + 2 == arrivoY) {
                            analizza(c, partenzaX + 1, partenzaY + 1, i, 'B', vettPreseValide);
                        } else if (partenzaX + 2 == arrivoX && partenzaY - 2 == arrivoY) {
                            analizza(c, partenzaX + 1, partenzaY - 1, i, 'B', vettPreseValide);
                        }
                    }
                }
                if (c.getBianco().isTurno() && vettPreseValide[i - 1]) {
                    if (c.getCasella(codiceArrivo).getCodice() != 0 && c.getCasella(codiceArrivo).getP() == null) {
                        if (partenzaX - 2 == arrivoX && partenzaY + 2 == arrivoY) {
                            analizza(c, partenzaX - 1, partenzaY + 1,  i, 'N', vettPreseValide);
                        } else if (partenzaX - 2 == arrivoX && partenzaY - 2 == arrivoY) {
                            analizza(c, partenzaX - 1, partenzaY - 1,  i, 'N',  vettPreseValide);
                        }
                    }
                }
            }
        }
        valido = vettoreValido(vettPreseValide);
        return valido;
    }

    //verifica che l'array letto è valido o se contiene errori (o non contiene - o x)
    private boolean vettoreValido(final boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            if (!array[i]) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        StringBuilder sbResult = new StringBuilder();
        sbResult.append("ValidatoreMossa: " + tipo + "\n");
        for (int i = 0; i < caselle.length; i++) {
            sbResult.append(caselle[i] + " ");
        }
        sbResult.append("\nCorretta: " + corretta + "\n");
        return sbResult.toString();
    }
}
