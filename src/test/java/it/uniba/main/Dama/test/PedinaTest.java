package it.uniba.main.Dama.test;

import it.uniba.main.Dama.Pedina;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe dei test per la classe Pedina.
 */

public class PedinaTest {
    @Test
    public void testGetColore() {
        Pedina p = new Pedina('B', "S");
        assertEquals('B', p.getColore());
    }

    @Test
    public void testGetColoreNull() {
        Pedina p = new Pedina(' ', "S");
        assertNotEquals('B', p.getColore());
    }

    @Test
    public void testSetColore() {
        Pedina p = new Pedina('B', "S");
        p.setColore('N');
        assertEquals('N', p.getColore());
    }

    @Test
    public void testSetColoreNull() {
        Pedina p = new Pedina('B', "S");
        p.setColore('N');
        assertNotEquals('B', p.getColore());
    }

    @Test
    public void testIsDama() {
        Pedina p = new Pedina('B', "S");
        assertFalse(p.isDama());
    }

    @Test
    public void testSetDama() {
        Pedina p = new Pedina('B', "S");
        p.setDama(true);
        assertTrue(p.isDama());
    }

    @Test
    public void testGetSimbolo() {
        Pedina p = new Pedina('B', "S");
        assertEquals("S", p.getSimbolo());
    }

    @Test
    public void testGetSimboloNull() {
        Pedina p = new Pedina('B', "S");
        assertNotEquals("X", p.getSimbolo());
    }

    @Test
    public void testSetSimbolo() {
        Pedina p = new Pedina('B', "S");
        p.setSimbolo("X");
        assertEquals("X", p.getSimbolo());
    }

    @Test
    public void testSetSimboloNull() {
        Pedina p = new Pedina('B', "S");
        p.setSimbolo("X");
        assertNotEquals("S", p.getSimbolo());
    }

}
