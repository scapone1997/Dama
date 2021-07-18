package it.uniba.main.Costanti.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import it.uniba.main.Costanti.Colori;

/**
 * Classe dei test per la classe Colori.
 */

public class ColoriTest {
    @Test
    public void testColoriCorrettiBlack() {
        String ansiColor = "\u001b[30m";
        assertEquals(Colori.ANSI_BLACK, ansiColor);
    }

    @Test
    public void testColoriCorrettiReset() {
        String ansiColor = "\u001B[0m";
        assertEquals(Colori.ANSI_RESET, ansiColor);
    }

    @Test
    public void testColoriCorrettiWhite() {
        String ansiColor = "\u001b[37m";
        assertEquals(Colori.ANSI_WHITE, ansiColor);
    }

    @Test
    public void testColoriCorrettiWhiteBackground() {
        String ansiColor = "\u001B[47m";
        assertEquals(Colori.ANSI_WHITE_BACKGROUND, ansiColor);
    }

    @Test
    public void testColoriCorrettiBlackBackground() {
        String ansiColor = "\u001B[40m";
        assertEquals(Colori.ANSI_BLACK_BACKGROUND, ansiColor);
    }

    @Test
    public void testColoriCorrettiRedBackground() {
        String ansiColor = "\u001b[41m";
        assertEquals(Colori.ANSI_RED_BACKGROUND, ansiColor);
    }

}
