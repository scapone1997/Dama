package it.uniba.main.Costanti.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import it.uniba.main.Costanti.Simboli;

/**
 * Classe dei test per la classe Simboli.
 */

public class SimboliTest {
    @Test
    public void testSimboliCorrettiPedinaBianca() {
        String symbol = "\u26C0";
        assertEquals(Simboli.PEDINA_BIANCA, symbol);
    }

    @Test
    public void testSimboliCorrettiDamaBianca() {
        String symbol = "\u26C1";
        assertEquals(Simboli.DAMA_BIANCA, symbol);
    }

    @Test
    public void testSimboliCorrettiPedinaNera() {
        String symbol = "\u26C2";
        assertEquals(Simboli.PEDINA_NERA, symbol);
    }

    @Test
    public void testSimboliCorrettiDamaNera() {
        String symbol = "\u26C3";
        assertEquals(Simboli.DAMA_NERA, symbol);
    }

}
