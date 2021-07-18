package it.uniba.main.Dama.test;

import it.uniba.main.Dama.Mossa;
import it.uniba.main.Dama.Campo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe dei test per la classe Mossa.
 */

public class MossaTest {
    @AfterEach
    final void resetMosse() {
        Mossa.resetRegistroMosse();
    }

    @Test
    public void testGetComando() {
        String comando = "18x11";
        Mossa m = new Mossa(comando, new Campo());
        assertEquals(comando, m.getComando());
    }

    @Test
    public void testGetGiocatoreBianco() {
        String comando = "22-14";
        Campo c = new Campo();
        c.getBianco().setTurno(true);
        Mossa m = new Mossa(comando, c);
        assertEquals('B', m.getGiocatore());
    }

    @Test
    public void testGetGiocatoreNero() {
        String comando = "12-16";
        Campo c = new Campo();
        c.getNero().setTurno(true);
        Mossa m = new Mossa(comando, c);
        assertEquals('N', m.getGiocatore());
    }

    @Test
    public void testGetGiocatoreNull() {
        String comando = "22-14";
        Campo c = new Campo();
        Mossa m = new Mossa(comando, c);
        assertFalse(m.isValida());
    }

    @Test
    public void testIsPresa() {
        String comando = "18x11";
        Campo c = new Campo();
        Mossa m = new Mossa(comando, c);
        assertTrue(m.isPresa());
    }

    @Test
    public void testIsNotPresa() {
        String comando = "18-11";
        Campo c = new Campo();
        Mossa m = new Mossa(comando, c);
        assertFalse(m.isPresa());
    }

    @Test
    public void testIsSpostamento() {
        String comando = "12-16";
        Campo c = new Campo();
        Mossa m = new Mossa(comando, c);
        assertTrue(m.isSpostamento());
    }

    @Test
    public void testIsNotSpostamento() {
        String comando = "18x11";
        Campo c = new Campo();
        Mossa m = new Mossa(comando, c);
        assertFalse(m.isSpostamento());
    }

    @Test
    public void testIsCorretta() {
        String comando = "12-16";
        Campo c = new Campo();
        Mossa m = new Mossa(comando, c);
        assertTrue(m.isCorretta());
    }

    @Test
    public void testIsNotCorretta() {
        String comando = "abc";
        Campo c = new Campo();
        Mossa m = new Mossa(comando, c);
        assertFalse(m.isCorretta());
    }

    @Test
    public void testIsValida() {
        String comando = "12-16";
        Campo c = new Campo();
        c.getNero().setTurno(true);
        Mossa m = new Mossa(comando, c);
        assertTrue(m.isValida());
    }

    @Test
    public void testIsNotValida() {
        String comando = "12-17";
        Campo c = new Campo();
        c.getNero().setTurno(true);
        Mossa m = new Mossa(comando, c);
        assertFalse(m.isValida());
    }

    @Test
    public void testGetCaselleSpostamento() {
        final int c1 = 22;
        final int c2 = 18;
        String comando = "22-18";
        int[] caselle = {c1, c2, 0, 0};
        Campo c = new Campo();
        c.getBianco().setTurno(true);
        Mossa m = new Mossa(comando, c);
        assertTrue(Arrays.equals(m.getCaselle(), caselle));
    }

    @Test
    public void testGetCasellePresa() {
        final int c1 = 21;
        final int c2 = 14;
        final int p = 10;
        final int a = 18;
        String comando = "21x14";
        int[] caselle = {c1, c2, 0, 0};
        Campo c = new Campo();
        c.spostaPedina(p, a);
        c.getBianco().setTurno(true);
        Mossa m = new Mossa(comando, c);
        assertTrue(Arrays.equals(m.getCaselle(), caselle));
    }

    @Test
    public void testGetDaEliminareSpostamento() {
        String comando = "22-18";
        int[] caselle = {0, 0, 0, 0};
        Campo c = new Campo();
        c.getBianco().setTurno(true);
        Mossa m = new Mossa(comando, c);
        assertTrue(Arrays.equals(m.getDaEliminare(), caselle));
    }

    @Test
    public void testGetDaEliminarePresa() {
        final int c1 = 18;
        final int c2 = 10;
        String comando = "21x14";
        int[] caselle = {c1, 0, 0, 0};
        Campo c = new Campo();
        c.spostaPedina(c2, c1);
        c.getBianco().setTurno(true);
        Mossa m = new Mossa(comando, c);
        assertTrue(Arrays.equals(m.getDaEliminare(), caselle));
    }

    @Test
    public void testGetRegistroMosse() {
        String comando = "22-18";
        Campo c = new Campo();
        c.getBianco().setTurno(true);
        Mossa m = new Mossa(comando, c);
        assertTrue(Mossa.getRegistroMosse().contains(m));
    }

    @Test
    public void testGetRegistroMosseNotValid() {
        String comando = "1-18";
        Campo c = new Campo();
        c.getBianco().setTurno(true);
        Mossa m = new Mossa(comando, c);
        assertFalse(Mossa.getRegistroMosse().contains(m));
    }

    @Test
    public void testResetRegistroMosse() {
        String comando = "22-18";
        Campo c = new Campo();
        c.getBianco().setTurno(true);
        Mossa m = new Mossa(comando, c);
        assertTrue(Mossa.getRegistroMosse().contains(m));
        Mossa.resetRegistroMosse();
        assertFalse(Mossa.getRegistroMosse().contains(m));
    }

}
