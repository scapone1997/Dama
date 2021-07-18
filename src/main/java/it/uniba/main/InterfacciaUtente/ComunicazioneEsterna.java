package it.uniba.main.InterfacciaUtente;

import it.uniba.main.Costanti.Colori;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import it.uniba.main.Costanti.Simboli;
import java.util.ArrayList;

/**
 *  <<Boundary>>
 *  Classe contenente tutti i metodi di stampa e metodi che richiedono una interazione con l'utente
 *  diversa dal un comando di gioco. La classe non deve essere istanziata, tutti i metodi sono di tipo static.
 */

public final class ComunicazioneEsterna {
    //costruttore privato, classe non istaziabile
    private ComunicazioneEsterna() { }

    //messaggio iniziale di benvenuto
    public static void benvenuto() {
        System.out.println("Benvenuto nell'applicazione 'Dama italiana' del gruppo vijayashanker.");
        System.out.println("Il regolamento del gioco è disponibile al seguente indirizzo: "
                + "http://www.fid.it/corsi/italiana/regole.htm");
        System.out.println("Usa il comando 'help' per avere ulteriori informazioni sugli altri comandi.");
    }

    //help del programma. Breve descrizione e elenco dei comandi possibili
    public static void help() {
        System.out.println("Benvenuto nell'applicazione 'Dama italiana' del gruppo vijayashanker.");
        System.out.println("Il regolamento del gioco è disponibile al seguente indirizzo: "
                + "http://www.fid.it/corsi/italiana/regole.htm");
        System.out.println("I comandi possibili sono i seguenti:");
        System.out.println("# help          Richiama la descrizione dell'applicazione e l'elenco comandi.");
        System.out.println("# gioca         Avvia una nuova partita se nessun altra partita è in corso.");
        System.out.println("# abbandona     Abbandona la partita in corso;"
                + "la vittoria sarà automaticamente assegnata all'avversario.");
        System.out.println("# esci          Esci dall'applicazione; la partita non verrà salvata.");
        System.out.println("# numeri        Mostra la damiera con i numeri sulle caselle nere.");
        System.out.println("# prese         Mostra a video le prese della partita; se non c'è una partita in corso,"
                + "suggerisce il comando gioca.");
        System.out.println("# damiera       Mostra la damiera con la posizione attuale delle pedine; "
                + "se non c'è una partita in corso, suggerisce il comando gioca.");
        System.out.println("# tempo         Mostra il tempo di gioco dei giocatori;"
                + " se non c'è una partita in corso, suggerisce il comando gioca.");
        System.out.println("# mosse         Mostra tutte le mosse valide effettuate; "
                + "se non c'è una partita in corso, suggerisce il comando gioca.");
        System.out.println("Una volta avviata una partita, è possibile muovere le pedine con la seguente notazione:");
        System.out.println("# <casella>-<casella>               Spostamento semplice (es: 1-5).");
        System.out.println("# <casella>x...x<casella>           Spostamento con presa (es: 1x10 oppure 1x10x19).");
    }

    //stampa percorso directory nella quale l'app è eseguita
    public static void currentWorkingDir() {
        System.out.println("Current working dir: " + System.getProperty("user.dir"));
    }

    //suggerisce i flag -h o --help in caso di flag iniziale errato
    public static void erroreFlag() {
        System.out.println("Flag non riconosciuto. "
                + "Usa i flag '-h' oppure '--help' per visualizzare l'help del programma all'avvio.");
    }

    //suggerisce di digitare 'gioca'
    public static void suggerisciGioca() {
        System.out.println("Nessuna partita in corso. Digitare 'gioca' per iniziare a giocare.");
    }

    // avvisa dell'inserimento di un comando non riconosciuto
    public static void erroreComando() {
        System.out.println("Comando non valido. ");
    }

    // avvisa dell'inserimento di una mossa non riconosciuta
    public static void erroreMossa() {
        System.out.println("Mossa non valida. ");
    }

    // avvisa della promozione di una pedina
    public static void avvisoPromozione() {
        System.out.println("Pedina promossa a Dama! ");
    }

    //stampa un messaggio che indica l'avvio di una nuova partita
    public static void avvioPartita() {
        System.out.println("************* PARTITA AVVIATA *************");
    }

    //stampa un messaggio che indica la fine di una partita, annunciando il vincitore
    public static void finePartita(final String vincitore) {
        System.out.println("Partita terminata. Il vincitore è il giocatore: " + vincitore);
        System.out.println("************* PARTITA TERMINATA *************");
    }

    //stampa un messaggio indicante di chi è il turno corrente nel gioco
    public static void avvisoTurnoGiocatore(final String giocatore) {
        System.out.println("E' il turno del giocatore " + giocatore + ": ");
    }

    //stampa la damiera numerata
    public static void numeri() {
        System.out.println("┌─────┬─────┬─────┬─────┬──"
                + "───┬─────┬─────┬─────┬");
        System.out.println("│ " + Colori.ANSI_BLACK_BACKGROUND + " 1 " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_WHITE_BACKGROUND
                + "   " + Colori.ANSI_RESET + " | " + Colori.ANSI_BLACK_BACKGROUND + " 2 " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_WHITE_BACKGROUND + "   " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_BLACK_BACKGROUND
                + " 3 " + Colori.ANSI_RESET + " | " + Colori.ANSI_WHITE_BACKGROUND + "   " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_BLACK_BACKGROUND + " 4 " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_WHITE_BACKGROUND
                + "   " + Colori.ANSI_RESET + " | ");
        System.out.println("├─────┼─────┼─────┼────"
                + "─┼─────┼─────┼─────┼─────┤");
        System.out.println("│ " + Colori.ANSI_WHITE_BACKGROUND + "   " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_BLACK_BACKGROUND
                + " 5 " + Colori.ANSI_RESET + " | " + Colori.ANSI_WHITE_BACKGROUND + "   " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_BLACK_BACKGROUND + " 6 " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_WHITE_BACKGROUND
                + "   " + Colori.ANSI_RESET + " | " + Colori.ANSI_BLACK_BACKGROUND + " 7 " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_WHITE_BACKGROUND + "   " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_BLACK_BACKGROUND
                + " 8 " + Colori.ANSI_RESET + " | ");
        System.out.println("├─────┼─────┼─────┼─────┼──"
                + "───┼─────┼─────┼─────┤");
        System.out.println("│ " + Colori.ANSI_BLACK_BACKGROUND + " 9 " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_WHITE_BACKGROUND
                + "  " + Colori.ANSI_RESET + "  | " + Colori.ANSI_BLACK_BACKGROUND + " 10 " + Colori.ANSI_RESET
                + "| " + Colori.ANSI_WHITE_BACKGROUND + "   " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_BLACK_BACKGROUND
                + " 11 " + Colori.ANSI_RESET + "| " + Colori.ANSI_WHITE_BACKGROUND + "   " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_BLACK_BACKGROUND + " 12 " + Colori.ANSI_RESET
                + "| " + Colori.ANSI_WHITE_BACKGROUND
                + "   " + Colori.ANSI_RESET + " | ");
        System.out.println("├─────┼─────┼─────┼────"
                + "─┼─────┼─────┼─────┼─────┤");
        System.out.println("│ " + Colori.ANSI_WHITE_BACKGROUND + "   " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_BLACK_BACKGROUND
                + " 13 " + Colori.ANSI_RESET + "| " + Colori.ANSI_WHITE_BACKGROUND + "   " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_BLACK_BACKGROUND + " 14 " + Colori.ANSI_RESET
                + "| " + Colori.ANSI_WHITE_BACKGROUND
                + "   " + Colori.ANSI_RESET + " | " + Colori.ANSI_BLACK_BACKGROUND + " 15 " + Colori.ANSI_RESET
                + "| " + Colori.ANSI_WHITE_BACKGROUND + "   " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_BLACK_BACKGROUND
                + " 16 " + Colori.ANSI_RESET + "| ");
        System.out.println("├─────┼─────┼─────┼────"
                + "─┼─────┼─────┼─────┼─────┤");
        System.out.println("│ " + Colori.ANSI_BLACK_BACKGROUND + " 17 " + Colori.ANSI_RESET
                + "| " + Colori.ANSI_WHITE_BACKGROUND
                + "   " + Colori.ANSI_RESET + " | " + Colori.ANSI_BLACK_BACKGROUND + " 18 " + Colori.ANSI_RESET
                + "| " + Colori.ANSI_WHITE_BACKGROUND + "   " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_BLACK_BACKGROUND
                + " 19 " + Colori.ANSI_RESET + "| " + Colori.ANSI_WHITE_BACKGROUND + "   " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_BLACK_BACKGROUND + " 20 " + Colori.ANSI_RESET
                + "| " + Colori.ANSI_WHITE_BACKGROUND
                + "   " + Colori.ANSI_RESET + " | ");
        System.out.println("├─────┼─────┼─────┼───"
                + "──┼─────┼─────┼─────┼─────┤");
        System.out.println("│ " + Colori.ANSI_WHITE_BACKGROUND + "   " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_BLACK_BACKGROUND
                + " 21 " + Colori.ANSI_RESET + "| " + Colori.ANSI_WHITE_BACKGROUND + "   " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_BLACK_BACKGROUND + " 22 " + Colori.ANSI_RESET
                + "| " + Colori.ANSI_WHITE_BACKGROUND
                + "   " + Colori.ANSI_RESET + " | " + Colori.ANSI_BLACK_BACKGROUND + " 23 " + Colori.ANSI_RESET
                + "| " + Colori.ANSI_WHITE_BACKGROUND + "   " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_BLACK_BACKGROUND
                + " 24 " + Colori.ANSI_RESET + "| ");
        System.out.println("├─────┼─────┼─────┼───"
                + "──┼─────┼─────┼─────┼─────┤");
        System.out.println("│ " + Colori.ANSI_BLACK_BACKGROUND + " 25 " + Colori.ANSI_RESET
                + "| " + Colori.ANSI_WHITE_BACKGROUND
                + "   " + Colori.ANSI_RESET + " | " + Colori.ANSI_BLACK_BACKGROUND + " 26 " + Colori.ANSI_RESET
                + "| " + Colori.ANSI_WHITE_BACKGROUND + "   " + Colori.ANSI_RESET + " | " + Colori.ANSI_BLACK_BACKGROUND
                + " 27 " + Colori.ANSI_RESET + "| " + Colori.ANSI_WHITE_BACKGROUND + "   " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_BLACK_BACKGROUND + " 28 " + Colori.ANSI_RESET
                + "| " + Colori.ANSI_WHITE_BACKGROUND
                + "   " + Colori.ANSI_RESET + " | ");
        System.out.println("├─────┼─────┼─────┼──"
                + "───┼─────┼─────┼─────┼─────┤");
        System.out.println("│ " + Colori.ANSI_WHITE_BACKGROUND + "   " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_BLACK_BACKGROUND
                + " 29 " + Colori.ANSI_RESET + "| " + Colori.ANSI_WHITE_BACKGROUND + "   " + Colori.ANSI_RESET
                + " | " + Colori.ANSI_BLACK_BACKGROUND + " 30 " + Colori.ANSI_RESET
                + "| " + Colori.ANSI_WHITE_BACKGROUND
                + "   " + Colori.ANSI_RESET + " | " + Colori.ANSI_BLACK_BACKGROUND + " 31 " + Colori.ANSI_RESET
                + "| " + Colori.ANSI_WHITE_BACKGROUND + "   " + Colori.ANSI_RESET + " | " + Colori.ANSI_BLACK_BACKGROUND
                + " 32 " + Colori.ANSI_RESET + "| ");
        System.out.println("└─────┴─────┴─────┴───"
                + "──┴─────┴─────┴─────┴─────┘");

    }

    //metodo che legge le mosse registrate all'interno di registroMosse
    public static void letturaRegistroMosse(final ArrayList<String> registroMosse) {
        int i = 0;
        if (registroMosse.size() != 0) {
            System.out.println("Ecco lo storico delle mosse valide effetuate:");
            while (i != registroMosse.size()) {
                System.out.println(registroMosse.get(i));
                i++;
            }
        } else {
            System.out.println("Non sono ancora state effetuate mosse.");
        }
    }

    //stampa la damiera
    public static void damiera(final String damieraToString) {
        System.out.println(damieraToString);
    }

    //metodo di uscita dall'applicazione
    public static boolean confermaEsci() {

        System.out.println("Sicuro di voler chiudere l'applicazione? Tutti i progressi verranno persi!");
        System.out.print("Digita 'si' per uscire, 'no' per annullare. ");
        String risposta = LettoreComandi.getRisposta().toLowerCase(Locale.ROOT);
        while (risposta.compareTo("no") != 0) {
            if (risposta.compareTo("si") == 0) {
                System.out.println("Chiusura del programma... Alla prossima!");
                return true;
            } else if (risposta.compareTo("no") == 0) {
                System.out.println("Uscita annullata.");
            } else {
                System.out.print("Risposta non valida. ");
                System.out.print("Digita 'si' per uscire, 'no' per annullare. ");
                risposta = LettoreComandi.getRisposta().toLowerCase(Locale.ROOT);
            }
        }
        return false;
    }

    //metodo che permette l'abbandono della partita
    public static boolean confermaAbbandono() {
        boolean partitaFinita = false;
        System.out.println("Sei sicuro di voler abbandonare la partita? "
                + "La vittoria sarà assegnata al tuo avversario!");
        System.out.print("Digita 'si' per uscire, 'no' per annullare. ");
        String risposta = LettoreComandi.getRisposta().toLowerCase(Locale.ROOT);
        while (risposta.compareTo("si") != 0 && risposta.compareTo("no") != 0) {
            System.out.print("Risposta non valida. ");
            System.out.print("Digita 'si' per uscire, 'no' per annullare. ");
            risposta = LettoreComandi.getRisposta().toLowerCase(Locale.ROOT);
        }
        if (risposta.compareTo("si") == 0) {
            partitaFinita = true;
        } else {
            System.out.println("Abbandono annullato.");
        }
        return partitaFinita;
    }

    // stampa a schermo quale dei due giocatori ha abbandonato
    public static void perdente(final String p) {
        System.out.println("Giocatore " + p + " ha abbandonato la partita.");
    }

    //metodo che stampa il tempo di gioco dei giocatori in formato h:m:s
    public static void stampaTempoGioco(final long tempoTrascorsoNeroInput, final long tempoTrascorsoBiancoInput) {
        long oreT, minutiT;
        long tempoTrascorsoNero = tempoTrascorsoNeroInput;
        long tempoTrascorsoBianco = tempoTrascorsoBiancoInput;

        //tempo gioco bianco
        oreT = TimeUnit.SECONDS.toHours(tempoTrascorsoBianco); //prima estraggo le ore
        //sottraggo le ore(ritrasformate in secondi) a tempotrascorso
        tempoTrascorsoBianco -= TimeUnit.HOURS.toSeconds(oreT);
        minutiT = TimeUnit.SECONDS.toMinutes(tempoTrascorsoBianco); //poi estraggo i minuti
        //sottraggo i minuti (ritrasformati in secondi) a tempotrascorso
        tempoTrascorsoBianco -= TimeUnit.MINUTES.toSeconds(minutiT);
        //il rimanente saranno soltanto secondi
        System.out.print("Tempo trascorso per il giocatore Bianco");
        System.out.print(" " + oreT + ":" + minutiT + ":" + tempoTrascorsoBianco + "\n");

        //tempo gioco nero
        oreT = TimeUnit.SECONDS.toHours(tempoTrascorsoNero);
        tempoTrascorsoNero -= TimeUnit.HOURS.toSeconds(oreT);
        minutiT = TimeUnit.SECONDS.toMinutes(tempoTrascorsoNero);
        tempoTrascorsoNero -= TimeUnit.MINUTES.toSeconds(minutiT);
        System.out.print("Tempo trascorso per il giocatore Nero");
        System.out.print(" " + oreT + ":" + minutiT + ":" + tempoTrascorsoNero + "\n");

    }

    //controlla il numero di prese del bianco e per ognuna stampa un carattere
    public static void stampaPreseDelBianco(final ArrayList<String> simboli) {
        System.out.print("Prese del giocatore Bianco: " + Colori.ANSI_BLACK);
        for (int i = 0; i < simboli.size(); i++) {
            System.out.print(Colori.ANSI_RED_BACKGROUND + Simboli.PEDINA_NERA + " ");
        }
        System.out.println(Colori.ANSI_RESET);
    }
    //controlla il numero di prese del nero e per ognuna stampa un carattere
    public static void stampaPreseDelNero(final ArrayList<String> simboli) {
        System.out.print("Prese del giocatore Nero:   " + Colori.ANSI_WHITE);
        for (int i = 0; i < simboli.size(); i++) {
            System.out.print(Colori.ANSI_RED_BACKGROUND + Simboli.PEDINA_BIANCA + " ");
        }
        System.out.println(Colori.ANSI_RESET);
    }

    public static void avvisoPresa() {
        System.out.println("Presa effettuata! ");
    }

}
