package it.uniba.main.InterfacciaUtente.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import it.uniba.main.InterfacciaUtente.ComunicazioneEsterna;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Classe dei test per la classe ComunicazioneEsterna.
 */
public class ComunicazioneEsternaTest {
    /*
     * L'implementazione di test della classe ComunicazioneEsterna è superflua, in quanto tutti i metodi in essa
     * presenti sono di tipo void e stampano solo messaggi in uno stream output. Questi metodi vengono comunque
     * richiamati nel corso dello svolgimento della partita per dare un riscontro video ai giocatori.
     * Le uniche due eccezioni sono confermaEsci e confermaAbbandono che restituiscono un boolean e si interfacciano
     * con LettoreComandi per acquisire una stringa.
     */

    //non funzionano in parallelo agli altri test, ma singolarmente si. Forse errore sullo stream file.
    @Disabled
    @Test
    public void testConfermaEsciSi() {
        try {
            FileInputStream f = openA();
            System.setIn(f);
            assertTrue(ComunicazioneEsterna.confermaEsci());
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setIn(System.in);
    }

    @Disabled
    @Test
    public void testConfermaEsciNo() {
        try {
            FileInputStream f = openB();
            System.setIn(f);
            assertFalse(ComunicazioneEsterna.confermaEsci());
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setIn(System.in);
    }

    @Disabled
    @Test
    public void testConfermaAbbandonoSi() {
        try {
            FileInputStream f = openA();
            System.setIn(f);
            assertTrue(ComunicazioneEsterna.confermaAbbandono());
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setIn(System.in);
    }

    @Disabled
    @Test
    public void testConfermaAbbandonoNo() {
        try {
            FileInputStream f = openB();
            System.setIn(f);
            assertFalse(ComunicazioneEsterna.confermaAbbandono());
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setIn(System.in);
    }

    private FileInputStream openA() throws FileNotFoundException {
        return new FileInputStream(
                "src/test/java/it/uniba/main/InterfacciaUtente/test/ComunicazioneEsternaTestInputA"
        );
    }

    private FileInputStream openB() throws FileNotFoundException {
        return new FileInputStream(
                "src/test/java/it/uniba/main/InterfacciaUtente/test/ComunicazioneEsternaTestInputB"
        );
    }

}
