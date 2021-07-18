package it.uniba.main.Dama.test;

import it.uniba.main.Dama.Pedina;
import org.junit.jupiter.api.Test;
import it.uniba.main.Dama.Casella;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Classe dei test per la classe Casella.
 */

public class CasellaTest {
    @Test
    public void testGetCodice() {
        Casella c = new Casella();
        assertTrue(c.getCodice() == 0);
    }

    @Test
    public void testGetPedina() {
        Casella c = new Casella();
        assertNull(c.getP());
    }

    @Test
    public void testSetPedina() {
        Casella c = new Casella();
        Pedina p = new Pedina('B', "S");
        c.setP(p);
        assertSame(c.getP(), p);
    }

    @Test
    public void testSetCodice() {
        final int sc = 5;
        Casella c = new Casella();
        c.setCodice(sc);
        assertEquals(sc, c.getCodice());
    }

    @Test
    public void testSetXandGetX() {
        final int sx = 5;
        Casella c = new Casella();
        c.setX(sx);
        assertEquals(sx, c.getX());
    }

    @Test
    public void testSetYandGetY() {
        final int sy = 5;
        Casella c = new Casella();
        c.setY(sy);
        assertEquals(sy, c.getY());
    }



}
