package it.uniba.main.Dama.test;

import it.uniba.main.Dama.Giocatore;
import it.uniba.main.Dama.Pedina;
import org.junit.jupiter.api.Test;
import it.uniba.main.Dama.Campo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe dei test per la classe Campo.
 */

public class CampoTest {
    @Test
    public void testGetMatrice() {
        Campo c = new Campo();
        assertNotNull(c.getMatrice());
    }

    @Test
    public void testGetCasellaCoordinate() {
        Campo c = new Campo();
        assertEquals(1, c.getCasella(0, 0).getCodice());
    }

    @Test
    public void testGetCasellaCoordinateNull() {
        Campo c = new Campo();
        assertEquals(0, c.getCasella(0, 1).getCodice());
    }

    @Test
    public void testGetCasellaCodice() {
        Campo c = new Campo();
        assertEquals(c.getCasella(1), c.getCasella(0, 0));
    }

    @Test
    public void testGetCasellaCodiceNull() {
        Campo c = new Campo();
        assertNotEquals(null, c.getCasella(0, 1));
    }

    @Test
    public void testGetCasellaCodiceOutOfBoundA() {
        final int cc = 33;
        Campo c = new Campo();
        assertEquals(c.getCasella(cc).getCodice(), c.getCasella(0, 1).getCodice());
    }

    @Test
    public void testGetCasellaCodiceOutOfBoundB() {
        Campo c = new Campo();
        assertEquals(c.getCasella(0).getCodice(), c.getCasella(0, 1).getCodice());
    }

    @Test
    public void testGetBianco() {
        Campo c = new Campo();
        assertEquals(c.getBianco(), new Giocatore('B'));
    }

    @Test
    public void testGetNero() {
        Campo c = new Campo();
        assertEquals(c.getNero(), new Giocatore('N'));
    }

    @Test
    public void testGetCoordinataX() {
        Campo c = new Campo();
        assertEquals(0, c.coordinataX(1));
    }

    @Test
    public void testGetCoordinataY() {
        Campo c = new Campo();
        assertEquals(0, c.coordinataX(1));
    }

    @Test
    public void testEliminaPedinaNero() {
        Campo c = new Campo();
        c.eliminaPedina(1);
        assertNull(c.getCasella(1).getP());
    }

    @Test
    public void testEliminaPedinaNotPresent() {
        final int p = 18;
        Campo c = new Campo();
        c.eliminaPedina(p);
        assertNull(c.getCasella(p).getP());
    }

    @Test
    public void testEliminaPedinaNull() {
        final int cs = 18;
        Campo c = new Campo();
        Pedina p = new Pedina('Z', "S");
        c.getCasella(cs).setP(p);
        c.eliminaPedina(cs);
        assertNull(c.getCasella(cs).getP());
    }

    @Test
    public void testEliminaPedinaBianco() {
        final int cc = 32;
        Campo c = new Campo();
        c.eliminaPedina(cc);
        assertNull(c.getCasella(cc).getP());
    }

    @Test
    public void testSpostaPedina() {
        final int p = 22;
        final int a = 18;
        Campo c = new Campo();
        c.spostaPedina(p, a);
        assertNull(c.getCasella(p).getP());
        assertNotNull(c.getCasella(a).getP());
    }

    @Test
    public void testPromozioneBianco() {
        final int cc = 1;
        final int p = 32;
        final int a = 1;
        Campo c = new Campo();
        assertFalse(c.getCasella(cc).getP().isDama());
        c.spostaPedina(p, a);
        c.promozione();
        assertTrue(c.getCasella(cc).getP().isDama());
    }

    @Test
    public void testPromozioneNero() {
        final int cc = 32;
        final int p = 1;
        final int a = 32;
        Campo c = new Campo();
        assertFalse(c.getCasella(cc).getP().isDama());
        c.spostaPedina(p, a);
        c.promozione();
        assertTrue(c.getCasella(cc).getP().isDama());
    }

    @Test
    public void testPromozioneDamaPresente() {
        final int cc1 = 32;
        final int cc2 = 31;
        final int p1 = 1;
        final int p2 = 2;
        Campo c = new Campo();
        assertFalse(c.getCasella(cc1).getP().isDama());
        c.spostaPedina(p1, cc1);
        c.promozione();
        assertTrue(c.getCasella(cc1).getP().isDama());
        c.spostaPedina(p2, cc2);
        assertFalse(c.getCasella(cc2).getP().isDama());
        c.promozione();
        assertTrue(c.getCasella(cc2).getP().isDama());
    }

    @Test
    public void testPromozioneNull() {
        Campo c = new Campo();
        assertFalse(c.getCasella(1).getP().isDama());
        c.promozione();
        assertFalse(c.getCasella(1).getP().isDama());
    }

    @Test
    public void testToString() { //rivedi
        Campo c = new Campo();
        assertNotNull(c.toString());
    }

}
