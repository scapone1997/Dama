package it.uniba.main.Dama;

import it.uniba.main.Costanti.Comandi;
import it.uniba.main.InterfacciaUtente.ComunicazioneEsterna;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *  <<Control>>
 *  La classe Gioco contiene il Campo di gioco e tutte le informazioni relative alla partita in corso. Si occupa di
 *  gestire la turnazione, eseguire i comandi richiamando i metodi opportuni e dichiarare un vincitore.
 *  Ha i seguenti attributi:
 *  - c: campo di gioco dove si svolge la partita
 *  - turno: contatore indicante i turni dei giocatori; i turni dispari sono del Giocatore bianco, pari del nero;
 *           si inizia dal turno 1 e il turno avanza solo dopo una mossa valida;
 *  - vincitore: stringa indicante il giocatore vincitore della partita.
 */
public class Gioco {
    private Campo c;
    private int turno;
    private String vincitore;

    //costruttore del campo Gioco
    public Gioco() {
        c = new Campo();
        turno = 1; //i turni dispari sono del Bianco, quelli pari del Nero
        c.getBianco().setTurno(true); //inizia il bianco
        vincitore = "nessuno";
        Mossa.resetRegistroMosse(); //resetto il registro mosse nel caso in cui ci fosse stata una precedente partita
    }

    private Campo leggiCampo() {
        return c; }

    private void incrementaTurno() {
        turno++; }

    public final int leggiTurno() {
        return turno;
    }

    //stabilisce di chi è il turno attuale
    public final void gestisciTurno() {
        if (leggiTurno() % 2 == 0) {
            ComunicazioneEsterna.avvisoTurnoGiocatore("Nero");
            leggiCampo().getNero().setTurno(true);
            leggiCampo().getBianco().setTurno(false);
            leggiCampo().getNero().setInizioTurnoCorrente(LocalTime.now());
        } else {
            ComunicazioneEsterna.avvisoTurnoGiocatore("Bianco");
            leggiCampo().getNero().setTurno(false);
            leggiCampo().getBianco().setTurno(true);
            leggiCampo().getBianco().setInizioTurnoCorrente(LocalTime.now());
        }
    }


    public final String leggiVincitore() {
        return vincitore;
    }

    private void scriviVincitore(final String v) {
        vincitore = v;
    }

    /*
     * metodo rappresentante un turno di gioco. Il comando in input viene interpretato ed elaborato
     * di conseguenza. Se è una mossa, viene eseguita e il turno passa al giocatore avversario.
     * La variabile flag indica l'esito della partita:
     * 1 c'è un vincitore, 0 partita in corso, -1 uscita dalla partita
     */
    public int gioca(final String comando) {
        int flag = 0; //1 c'è un vincitore, -1 uscita dalla partita, 0 partita in corso
        Mossa m = new Mossa(comando, c); //elabora comando del giocatore corrente

        if (comando.compareTo(Comandi.HELP) == 0) {
            ComunicazioneEsterna.help();
        } else if (comando.compareTo(Comandi.NUMERI) == 0) {
            ComunicazioneEsterna.numeri();
        } else if (comando.compareTo(Comandi.DAMIERA) == 0) {
            ComunicazioneEsterna.damiera(leggiCampo().toString());
        } else if (comando.compareTo(Comandi.TEMPO) == 0) {
            tempo();
        } else if (comando.compareTo(Comandi.MOSSE) == 0) {
            mosse(Mossa.getRegistroMosse());
        } else if (comando.compareTo(Comandi.ABBANDONA) == 0) {
            if (ComunicazioneEsterna.confermaAbbandono()) {
                scriviVincitore(abbandono());
                flag = 1;
            }
        } else if (comando.compareTo(Comandi.ESCI) == 0) {
            if (ComunicazioneEsterna.confermaEsci()) {
                flag = -1;
                return flag;
            }
        } else if (comando.compareTo(Comandi.PRESE) == 0) {
            prese(c.getBianco().getPedinePrese(), c.getNero().getPedinePrese());
        } else if (m.isCorretta()) {
            if (m.isValida()) {
                effettuaMossa(m);
                if (m.isPresa()) {
                    ComunicazioneEsterna.avvisoPresa(); //avvisa di una presa
                }
                c.promozione(); //effettua promozioni a dama se necessario
                incrementaTurno();
            } else {
                ComunicazioneEsterna.erroreMossa();
            }
        } else {
            ComunicazioneEsterna.erroreComando();
        }

        //Aggiorna tempo di gioco, non posso usare la variabile turno perchè potrebbe essere stata incrementata
        if (leggiCampo().getNero().isTurno()) {
            leggiCampo().getNero().aggiornaTempoGioco();
        } else {
            leggiCampo().getBianco().aggiornaTempoGioco();
        }

        /* prototipo di controllo fine partita //se pedine prese =12
        vincitore = controlloVincitore()
        if ( vincitore == patta || Bianco || Nero ){
            partitaFinita = true; //ovvero flag = 1
        }
        */
        return flag;
    }

    //metodo che stampa le prese dei relativi giocatori in formato stringa
    private void prese(final ArrayList<Pedina> pedineNere, final ArrayList<Pedina> pedineBianche) {
        ArrayList<String> simboliNeri = new ArrayList<>();
        ArrayList<String> simboliBianchi = new ArrayList<>();
        for (Pedina pedina : pedineNere) {
            simboliNeri.add(pedina.getSimbolo());
        }
        ComunicazioneEsterna.stampaPreseDelBianco(simboliNeri);
        for (Pedina pedina : pedineBianche) {
            simboliBianchi.add(pedina.getSimbolo());
        }
        ComunicazioneEsterna.stampaPreseDelNero(simboliBianchi);
    }

    //metodo che stampa le mosse di gioco in formato stringa
    private void mosse(final ArrayList<Mossa> registroMosse) {
        ArrayList<String> registroMosseString = new ArrayList<>();
        for (Mossa m : registroMosse) {
            registroMosseString.add(m.getGiocatore() + " " + m.getComando());
        }
        ComunicazioneEsterna.letturaRegistroMosse(registroMosseString);
    }

    //metodo che assegna la vincita di una partita ad un giocatore dopo che l'avversario ha abbandonato
    private String abbandono() {
        if (c.getNero().isTurno()) {
            ComunicazioneEsterna.perdente("Nero");
            vincitore = "Bianco";
        } else {
            ComunicazioneEsterna.perdente("Bianco");
            vincitore = "Nero";
        }
        return vincitore;
    }

    //metodo che setta il tempo del giocatore chiamante
    //al turno corrente e stampa a video il tempo di entrambi i giocatori
    private void tempo() {
        if (leggiCampo().getNero().isTurno()) {
            leggiCampo().getNero().aggiornaTempoGioco();
            leggiCampo().getNero().setInizioTurnoCorrente(LocalTime.now());
            //se non lo aggiorno, se continuo a chiedere il tempo nello stesso turno faccio somme esponenziali
        } else {
            leggiCampo().getBianco().aggiornaTempoGioco();
            leggiCampo().getBianco().setInizioTurnoCorrente(LocalTime.now()); //idem
        }
        ComunicazioneEsterna.stampaTempoGioco(leggiCampo().getNero().getTempoGioco(),
                leggiCampo().getBianco().getTempoGioco());
    }

    //metodo che effettua una mossa valida
    private void effettuaMossa(final Mossa m) {
        if (m.isSpostamento()) {
            int[] coordinate = m.getCaselle();
            c.spostaPedina(coordinate[0], coordinate[1]);
        } else if (m.isPresa()) {
            int[] coordinate = m.getCaselle();
            int[] eliminate = m.getDaEliminare();
            for (int i = 0; i < eliminate.length - 1; i++) {
                if (eliminate[i] != 0) {
                    c.eliminaPedina(eliminate[i]);
                }
            }
            for (int i = 0; i < coordinate.length - 1; i++) {
                if (coordinate[i + 1] != 0) {
                    c.spostaPedina(coordinate[i], coordinate[i + 1]);
                }
            }
        }
    }



}
