package it.uniba.main.InterfacciaUtente;

import java.util.Scanner;

/**
 *  <<Boundary>>
 *  Classe che si occupa di leggere da uno stream input i comandi di gioco. Ha solo un attributo:
 *  - INPUT: oggetto di tipo Scanner
 */
public final class LettoreComandi {
    private static final Scanner INPUT = new Scanner(System.in, "UTF-8");

    //costruttore privato, classe non istaziabile
    private LettoreComandi() { }

    //metodo che permette la scansione del comando da tastiera
    public static String getComando() {
        System.out.print("Inserire comando: ");
        return INPUT.nextLine();
    }

    public static String getRisposta() {
        System.out.print("Inserire risposta: ");
        return INPUT.nextLine();
    }

}
