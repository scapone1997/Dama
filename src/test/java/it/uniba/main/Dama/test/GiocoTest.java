package it.uniba.main.Dama.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import it.uniba.main.Dama.Gioco;
import it.uniba.main.InterfacciaUtente.ComunicazioneEsterna;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Classe dei test per la classe Gioco.
 */
public class GiocoTest {

    @Test
    public void testGiocaComandoNull() {
        Gioco g = new Gioco();
        int flag = g.gioca("abc");
        assertEquals(0, flag);
    }

    @Test
    public void testGiocaComandoHelp() {
        Gioco g = new Gioco();
        int flag = g.gioca("help");
        assertEquals(0, flag);
    }

    @Test
    public void testGiocaComandoNumeri() {
        Gioco g = new Gioco();
        int flag = g.gioca("numeri");
        assertEquals(0, flag);
    }

    @Test
    public void testGiocaComandoDamiera() {
        Gioco g = new Gioco();
        int flag = g.gioca("damiera");
        assertEquals(0, flag);
    }

    @Test
    public void testGiocaComandoMosseVuote() {
        Gioco g = new Gioco();
        int flag = g.gioca("mosse");
        assertEquals(0, flag);
    }

    @Test
    public void testGiocaComandoMosseNonVuote() {
        Gioco g = new Gioco();
        g.gestisciTurno();
        g.gioca("21-18");
        g.gestisciTurno();
        int flag = g.gioca("mosse");
        assertEquals(0, flag);
    }

    @Test
    public void testGiocaComandoPreseVuote() {
        Gioco g = new Gioco();
        int flag = g.gioca("prese");
        assertEquals(0, flag);
    }

    @Test
    public void testGiocaComandoPreseNonVuote() {
        Gioco g = new Gioco();
        g.gestisciTurno();
        g.gioca("21-18");
        g.gestisciTurno();
        g.gioca("11-14");
        g.gestisciTurno();
        g.gioca("18x11");
        g.gestisciTurno();
        g.gioca("7x14");
        int flag = g.gioca("prese");
        assertEquals(0, flag);
    }

    @Test
    public void testGiocaComandoMossaNonValida() {
        Gioco g = new Gioco();
        g.gioca("21-1");
        assertEquals(1, g.leggiTurno());
    }

    @Test
    public void testGiocaComandoMossaSpostamento() {
        Gioco g = new Gioco();
        g.gioca("21-17");
        assertEquals(2, g.leggiTurno());
    }

    @Test
    public void testGiocaComandoMossaPresa() {
        final int e = 5;
        Gioco g = new Gioco();
        g.gestisciTurno();
        g.gioca("21-18");
        g.gestisciTurno();
        g.gioca("11-14");
        g.gestisciTurno();
        g.gioca("18x11");
        g.gestisciTurno();
        g.gioca("7x14");
        assertEquals(e, g.leggiTurno());
    }

    @Test
    public void testGiocaComandoTempoBianco() {
        Gioco g = new Gioco();
        g.gioca("tempo");
        assertEquals(1, g.leggiTurno());
    }

    @Test
    public void testGiocaComandoTempoNero() {
        Gioco g = new Gioco();
        g.gestisciTurno();
        g.gioca("21-17");
        g.gestisciTurno();
        g.gioca("tempo");
        assertEquals(2, g.leggiTurno());
    }


    /*
     * non posso testare tutti i casi di abbandono e uscita perchè richiedono una conferma da tastiera
     * e gli InputStream non funzionano bene con i test junit. Pur funzionando singolarmente, se avviati insieme
     * non funzionano, di conseguenza li ho disabilitati tutti tranne uno.
     */

    @Test
    public void testGiocaComandoAbbandonoSi() {
        InputStream std = System.in;
        Gioco g = new Gioco();
        System.setIn(new ByteArrayInputStream("abc\nsi".getBytes(StandardCharsets.UTF_8)));
        int flag = g.gioca("abbandona");
        ComunicazioneEsterna.finePartita(g.leggiVincitore());
        assertEquals(1, flag);
        System.setIn(std);
    }

    @Disabled
    @Test
    public void testGiocaComandoAbbandonoNo() {
        InputStream std = System.in;
        Gioco g = new Gioco();
        System.setIn(new ByteArrayInputStream("no".getBytes(StandardCharsets.UTF_8)));
        assertEquals(0, g.gioca("abbandona"));
        System.setIn(std);
    }

    @Disabled
    @Test
    public void testGiocaComandoEsciSi() {
        InputStream std = System.in;
        Gioco g = new Gioco();
        System.setIn(new ByteArrayInputStream("si".getBytes(StandardCharsets.UTF_8)));
        assertEquals(-1, g.gioca("esci"));
        System.setIn(std);
    }

    @Disabled
    @Test
    public void testGiocaComandoEsciNo() {
        InputStream std = System.in;
        Gioco g = new Gioco();
        System.setIn(new ByteArrayInputStream("no".getBytes(StandardCharsets.UTF_8)));
        assertEquals(0, g.gioca("esci"));
        System.setIn(std);
    }

}
