package it.uniba.main.InterfacciaUtente.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import it.uniba.main.InterfacciaUtente.LettoreComandi;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Classe dei test per la classe LettoreComandi.
 */
public class LettoreComandiTest {
    //non funzionano in parallelo agli altri test, ma singolarmente si. Forse errore sullo stream file.
    @Disabled
    @Test
    public void testGetComando() {
        try {
            FileInputStream f = open();
            System.setIn(f);
            assertEquals("abc", LettoreComandi.getComando());
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setIn(System.in);
    }

    @Disabled
    @Test
    public void testGetRisposta() {
        try {
            FileInputStream f = open();
            System.setIn(f);
            assertEquals("abc", LettoreComandi.getRisposta());
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setIn(System.in);
    }

    private FileInputStream open() throws FileNotFoundException {
        return new FileInputStream(
                "src/test/java/it/uniba/main/InterfacciaUtente/test/ComunicazioneEsternaTestInputA"
        );
    }
}
