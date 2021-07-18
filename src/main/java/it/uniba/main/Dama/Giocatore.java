package it.uniba.main.Dama;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

/**
 *  <<Entity>>
 *  La classe Giocatore serve per rappresentare i due giocatori presenti in Campo.
 *  Controllano Pedine dello stesso colore.
 *  I giocatori sono identificati dagli attributi:
 *  - colore: può essere nero (N) o bianco (B);
 *  - turno: true indica che è il suo turno di gioco, false altrimenti;
 *  - tempoGioco: totale tempo dei turni;
 *  - inizioTurnoCorrente: orario di inizio del turno attuale o l'orario dell'ultimo aggiornamento del tempo di gioco;
 *  - pedinePrese: lista di pedine prese al giocatore avversario.
 */

public class Giocatore {

    private char colore;
    private boolean turno;
    private long tempoGioco;
    private LocalTime inizioTurnoCorrente;
    private ArrayList<Pedina> pedinePrese;

    public Giocatore(final char c) {
        if (c == 'B' || c == 'N') {
            setColore(c);
            setTurno(false);
            tempoGioco = 0;
            inizioTurnoCorrente = LocalTime.MIN;
            pedinePrese = new ArrayList<>();
        }
    }

    public final ArrayList<Pedina> getPedinePrese() {
        return pedinePrese;
    }
    public final void addPedina(final Pedina p) {
        pedinePrese.add(p);
    }
    public final char getColore() {
        return colore;
    }
    public final void setColore(final char pcolore) {
        this.colore = pcolore;
    }
    public final boolean isTurno() {
        return turno;
    }
    public final void setTurno(final boolean pturno) {
        this.turno = pturno;
    }
    public final long getTempoGioco() {
        return tempoGioco;
    }
    public final void aggiornaTempoGioco() {
        // tempo di gioco + ora attuale (in secondi) - l'orario di inizio del turno (in secondi)
        this.tempoGioco = this.tempoGioco + LocalTime.now().toSecondOfDay()
                - getInizioTurnoCorrente().toSecondOfDay();
    }
    public final LocalTime getInizioTurnoCorrente() {
        return inizioTurnoCorrente;
    }
    public final void setInizioTurnoCorrente(final LocalTime pt) {
        this.inizioTurnoCorrente = pt;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Giocatore giocatore = (Giocatore) o;
        return colore == giocatore.colore && turno == giocatore.turno && tempoGioco == giocatore.tempoGioco
                && Objects.equals(inizioTurnoCorrente, giocatore.inizioTurnoCorrente)
                && Objects.equals(pedinePrese, giocatore.pedinePrese);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(colore, turno, tempoGioco, inizioTurnoCorrente, pedinePrese);
    }
}

