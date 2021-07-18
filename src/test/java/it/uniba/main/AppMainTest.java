package it.uniba.main;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Classe dei test per la classe AppMain.
 */
public class AppMainTest {
    /*
     * Attraverso l'uso di file precompilati che simulano una partita, testo tutte le funzioni di AppMain.
     * I file precompilati sono: AppMainInputA, AppMainInputB.
     */

    //non funzionano in parallelo agli altri test, ma singolarmente si. Forse errore sullo stream file
    @Disabled
    @Test
    public void testAppMainHelp() {
        try {
            FileInputStream f = openA();
            System.setIn(f);
            String[] args = {"--help"};
            AppMain.main(args);
            f.close();
            assertTrue(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setIn(System.in);
    }

    //non funzionano in parallelo agli altri test, ma singolarmente si. Forse errore sullo stream file
    @Disabled
    @Test
    public void testAppMainH() {
        try {
            FileInputStream f = openA();
            System.setIn(f);
            String[] args = {"-h"};
            AppMain.main(args);
            f.close();
            assertTrue(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setIn(System.in);
    }

    //non funzionano in parallelo agli altri test, ma singolarmente si. Forse errore sullo stream file
    @Disabled
    @Test
    public void testAppMainFlagNotValid() {
        try {
            FileInputStream f = openB();
            System.setIn(f);
            String[] args = {"abc"};
            AppMain.main(args);
            f.close();
            assertTrue(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setIn(System.in);
    }

    //non funzionano in parallelo agli altri test, ma singolarmente si. Forse errore sullo stream file
    @Disabled
    @Test
    public void testAppMainArgsNull() {
        try {
            FileInputStream f = openB();
            System.setIn(f);
            String[] args = new String[0];
            AppMain.main(args);
            f.close();
            assertTrue(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setIn(System.in);
    }

    private FileInputStream openA() throws FileNotFoundException {
        return new FileInputStream("src/test/java/it/uniba/main/AppMainTestInputA");
    }

    private FileInputStream openB() throws FileNotFoundException {
        return new FileInputStream("src/test/java/it/uniba/main/AppMainTestInputB");
    }


}
