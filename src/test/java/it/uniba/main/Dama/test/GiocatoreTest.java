package it.uniba.main.Dama.test;

import it.uniba.main.Dama.Giocatore;
import it.uniba.main.Dama.Pedina;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe dei test per la classe Giocatore.
 */

public class GiocatoreTest {
    @Test
    public void testCostruttoreNull() {
        Giocatore g = new Giocatore('Z');
        assertTrue(g.getColore() != 'Z');
        assertTrue(g.getColore() != 'B');
        assertTrue(g.getColore() != 'N');
        assertEquals(g.getTempoGioco(), 0);
        assertNull(g.getInizioTurnoCorrente());
        assertNull(g.getPedinePrese());
    }

    @Test
    public void testGetPedinePrese() {
        Giocatore g = new Giocatore('B');
        assertEquals(g.getPedinePrese(), new ArrayList<Pedina>());
    }

    @Test
    public void testAddPedina() {
        Giocatore g = new Giocatore('B');
        Pedina p = new Pedina('B', "S");
        g.addPedina(p);
        assertTrue(g.getPedinePrese().contains(p));
    }

    @Test
    public void testGetColore() {
        Giocatore g = new Giocatore('B');
        assertEquals('B', g.getColore());
    }

    @Test
    public void testSetColore() {
        Giocatore g = new Giocatore('B');
        g.setColore('N');
        assertEquals('N', g.getColore());
    }

    @Test
    public void testSetColoreNull() {
        Giocatore g = new Giocatore('B');
        g.setColore('N');
        assertNotEquals('B', g.getColore());
    }

    @Test
    public void testIsTurno() {
        Giocatore g = new Giocatore('B');
        assertFalse(g.isTurno());
    }

    @Test
    public void testSetTurno() {
        Giocatore g = new Giocatore('B');
        g.setTurno(true);
        assertTrue(g.isTurno());
    }

    @Test
    public void testGetTempoGioco() {
        Giocatore g = new Giocatore('B');
        assertEquals(0, g.getTempoGioco());
    }

    @Test
    public void testAggiornaTempoGioco() {
        Giocatore g = new Giocatore('B');
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            g.aggiornaTempoGioco();
        }
        g.aggiornaTempoGioco();
        assertNotEquals(0, g.getTempoGioco());
    }

    @Test
    public void testGetInizioTurnoCorrente() {
        Giocatore g = new Giocatore('B');
        assertNotNull(g.getInizioTurnoCorrente());
    }

    @Test
    public void testGetInizioTurnoCorrenteDelay() {
        Giocatore g = new Giocatore('B');
        g.setInizioTurnoCorrente(LocalTime.now());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            g.aggiornaTempoGioco();
        }
        g.aggiornaTempoGioco();
        assertNotNull(g.getInizioTurnoCorrente());
    }

    @Test
    public void testSetInizioTurnoCorrente() {
        Giocatore g = new Giocatore('B');
        LocalTime t = LocalTime.now();
        g.setInizioTurnoCorrente(t);
        assertEquals(t, g.getInizioTurnoCorrente());
    }

    @Test
    public void testHash() {
        Giocatore g1 = new Giocatore('B');
        assertTrue(
                g1.hashCode()
                        == Objects.hash(g1.getColore(), g1.isTurno(), g1.getTempoGioco(),
                        g1.getInizioTurnoCorrente(), g1.getPedinePrese())
        );
    }

    @Test
    public void testEqual() {
        Giocatore g1 = new Giocatore('B');
        Giocatore g2 = new Giocatore('B');
        assertTrue(g1.equals(g2));
    }

    @Test
    public void testEqualSelf() {
        Giocatore g1 = new Giocatore('N');
        assertTrue(g1.equals(g1));
    }

    @Test
    public void testNotEqual() {
        Giocatore g1 = new Giocatore('B');
        Giocatore g2 = new Giocatore('N');
        assertFalse(g1.equals(g2));
    }

    @Test
    public void testNotEqualAttributesA() {
        Giocatore g1 = new Giocatore('B');
        Giocatore g2 = new Giocatore('B');
        g2.setTurno(true);
        g2.setInizioTurnoCorrente(LocalTime.now());
        g2.aggiornaTempoGioco();
        g2.addPedina(new Pedina('B', "S"));
        assertFalse(g2.equals(g1));
    }

    @Test
    public void testNotEqualAttributesB() {
        Giocatore g1 = new Giocatore('B');
        Giocatore g2 = new Giocatore('B');
        g1.setInizioTurnoCorrente(LocalTime.now());
        g1.addPedina(new Pedina('B', "S"));
        assertFalse(g1.equals(g2));
    }

    @Test
    public void testEqualNull() {
        Giocatore g1 = new Giocatore('B');
        assertFalse(g1.equals(null));
    }

    @Test
    public void testEqualWrongClass() {
        Giocatore g1 = new Giocatore('B');
        Object o = new Object();
        assertFalse(g1.equals(o));
    }

}
