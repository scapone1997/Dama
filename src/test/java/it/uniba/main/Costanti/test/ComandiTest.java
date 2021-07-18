package it.uniba.main.Costanti.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import it.uniba.main.Costanti.Comandi;

/**
 * Classe dei test per la classe Comandi.
 */

public class ComandiTest {
    @Test
    public void testComandiCorrettiHelp() {
        String comando = "help";
        assertEquals(Comandi.HELP, comando);
    }

    @Test
    public void testComandiCorrettiNumeri() {
        String comando = "numeri";
        assertEquals(Comandi.NUMERI, comando);
    }

    @Test
    public void testComandiCorrettiDamiera() {
        String comando = "damiera";
        assertEquals(Comandi.DAMIERA, comando);
    }

    @Test
    public void testComandiCorrettiTempo() {
        String comando = "tempo";
        assertEquals(Comandi.TEMPO, comando);
    }

    @Test
    public void testComandiCorrettiGioca() {
        String comando = "gioca";
        assertEquals(Comandi.GIOCA, comando);
    }

    @Test
    public void testComandiCorrettiMosse() {
        String comando = "mosse";
        assertEquals(Comandi.MOSSE, comando);
    }

    @Test
    public void testComandiCorrettiPrese() {
        String comando = "prese";
        assertEquals(Comandi.PRESE, comando);
    }

    @Test
    public void testComandiCorrettiAbbandona() {
        String comando = "abbandona";
        assertEquals(Comandi.ABBANDONA, comando);
    }

    @Test
    public void testComandiCorrettiEsci() {
        String comando = "esci";
        assertEquals(Comandi.ESCI, comando);
    }

}
