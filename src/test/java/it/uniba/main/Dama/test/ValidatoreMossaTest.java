package it.uniba.main.Dama.test;

import it.uniba.main.Dama.ValidatoreMossa;
import it.uniba.main.Dama.Campo;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe dei test per la classe ValidatoreMossa.
 */

public class ValidatoreMossaTest {
    @Test
    public void testCostruttoreNullA() {
        String comando = "ab-c";
        Campo c = new Campo();
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertFalse(vm.isValida());
    }

    @Test
    public void testCostruttoreNullB() {
        String comando = "abxc";
        Campo c = new Campo();
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertFalse(vm.isValida());
    }

    @Test
    public void testCostruttoreNullC() {
        String comando = "-";
        Campo c = new Campo();
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertFalse(vm.isValida());
    }

    @Test
    public void testCostruttoreNullD() {
        String comando = "1x";
        Campo c = new Campo();
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertFalse(vm.isValida());
    }

    @Test
    public void testGetTipoSpostamento() {
        String comando = "22-18";
        Campo c = new Campo();
        c.getBianco().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertEquals('-', vm.getTipo());
    }

    @Test
    public void testGetTipoPresa() {
        String comando = "12x16";
        Campo c = new Campo();
        c.getNero().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertEquals('x', vm.getTipo());
    }

    @Test
    public void testGetTipoNull() {
        String comando = "abc";
        Campo c = new Campo();
        c.getNero().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertEquals('0', vm.getTipo());
    }

    @Test
    public void testIsSpostamento() {
        String comando = "22-18";
        Campo c = new Campo();
        c.getBianco().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertTrue(vm.isSpostamento());
    }

    @Test
    public void testSpostamentoBiancoNull() {
        String comando = "18-14";
        Campo c = new Campo();
        c.getBianco().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertTrue(vm.isSpostamento());
        assertFalse(vm.isValida());
    }

    @Test
    public void testSpostamentoNeroNull() {
        String comando = "13-17";
        Campo c = new Campo();
        c.getNero().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertTrue(vm.isSpostamento());
        assertFalse(vm.isValida());
    }

    @Test
    public void testIsNotSpostamento() {
        String comando = "12x16";
        Campo c = new Campo();
        c.getNero().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertFalse(vm.isSpostamento());
    }

    @Test
    public void testIsPresa() {
        String comando = "12x16";
        Campo c = new Campo();
        c.getNero().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertTrue(vm.isPresa());
    }

    @Test
    public void testIsNotPresa() {
        String comando = "12-16";
        Campo c = new Campo();
        c.getNero().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertFalse(vm.isPresa());
    }

    @Test
    public void testGetCaselle() {
        final int c1 = 12;
        final int c2 = 16;
        String comando = "12-16";
        int[] caselle = {c1, c2, 0, 0};
        Campo c = new Campo();
        c.getNero().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertTrue(Arrays.equals(vm.getCaselle(), caselle));
    }

    @Test
    public void testIsCorretta() {
        String comando = "12-16";
        Campo c = new Campo();
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertTrue(vm.isCorretta());
    }

    @Test
    public void testIsNotCorretta() {
        String comando = "abc";
        Campo c = new Campo();
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertFalse(vm.isCorretta());
    }

    @Test
    public void testIsValida() {
        String comando = "12-16";
        Campo c = new Campo();
        c.getNero().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertTrue(vm.isValida());
    }

    @Test
    public void testIsNotValida() {
        String comando = "12-17";
        Campo c = new Campo();
        c.getNero().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertFalse(vm.isValida());
    }

    @Test
    public void testGetCaselleSpostamentoBiancoDestra() {
        final int c1 = 22;
        final int c2 = 19;
        String comando = "22-19";
        int[] caselle = {c1, c2, 0, 0};
        Campo c = new Campo();
        c.getBianco().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertTrue(Arrays.equals(vm.getCaselle(), caselle));
    }

    @Test
    public void testGetCaselleSpostamentoBiancoSinistra() {
        final int c1 = 22;
        final int c2 = 18;
        String comando = "22-18";
        int[] caselle = {c1, c2, 0, 0};
        Campo c = new Campo();
        c.getBianco().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertTrue(Arrays.equals(vm.getCaselle(), caselle));
    }

    @Test
    public void testGetCaselleSpostamentoNeroSinistra() {
        final int c1 = 10;
        final int c2 = 13;
        String comando = "10-13";
        int[] caselle = {c1, c2, 0, 0};
        Campo c = new Campo();
        c.getNero().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertTrue(Arrays.equals(vm.getCaselle(), caselle));
    }

    @Test
    public void testGetCaselleSpostamentoNeroDestra() {
        final int c1 = 10;
        final int c2 = 14;
        String comando = "10-14";
        int[] caselle = {c1, c2, 0, 0};
        Campo c = new Campo();
        c.getNero().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertTrue(Arrays.equals(vm.getCaselle(), caselle));
    }

    @Test
    public void testGetCasellePresaBianco() {
        final int p = 10;
        final int a = 18;
        final int c1 = 21;
        final int c2 = 14;
        String comando = "21x14";
        int[] caselle = {c1, c2, 0, 0};
        Campo c = new Campo();
        c.spostaPedina(p, a);
        c.getBianco().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertTrue(Arrays.equals(vm.getCaselle(), caselle));
    }

    @Test
    public void testGetCasellePresaNero() {
        final int c1 = 10;
        final int c2 = 17;
        final int p = 21;
        final int a = 13;
        String comando = "10x17";
        int[] caselle = {c1, c2, 0, 0};
        Campo c = new Campo();
        c.spostaPedina(p, a);
        c.getNero().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertTrue(Arrays.equals(vm.getCaselle(), caselle));
    }

    @Test
    public void testGetCasellePresaMultiplaNeroA() {
        final int c1 = 10;
        final int c2 = 19;
        final int c3 = 26;
        final int p1 = 22;
        final int a1 = 14;
        final int p2 = 26;
        final int a2 = 18;
        String comando = "10x19x26";
        int[] caselle = {c1, c2, c3, 0};
        Campo c = new Campo();
        c.spostaPedina(p1, a1);
        c.spostaPedina(p2, a2);
        c.getNero().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertTrue(Arrays.equals(vm.getCaselle(), caselle));
    }

    @Test
    public void testGetCasellePresaMultiplaNeroB() {
        final int c1 = 10;
        final int c2 = 19;
        final int c3 = 28;
        final int p1 = 22;
        final int a1 = 14;
        final int p2 = 28;
        final int a2 = 20;
        String comando = "10x19x28";
        int[] caselle = {c1, c2, c3, 0};
        Campo c = new Campo();
        c.spostaPedina(p1, a1);
        c.spostaPedina(p2, a2);
        c.getNero().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertTrue(Arrays.equals(vm.getCaselle(), caselle));
    }

    @Test
    public void testGetCasellePresaMultiplaBiancoA() {
        final int c1 = 21;
        final int c2 = 14;
        final int c3 = 7;
        final int p1 = 10;
        final int a1 = 18;
        final int p2 = 7;
        final int a2 = 15;
        String comando = "21x14x7";
        int[] caselle = {c1, c2, c3, 0};
        Campo c = new Campo();
        c.spostaPedina(p1, a1);
        c.spostaPedina(p2, a2);
        c.getBianco().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertTrue(Arrays.equals(vm.getCaselle(), caselle));
    }

    @Test
    public void testGetCasellePresaMultiplaBiancoB() {
        final int c1 = 21;
        final int c2 = 14;
        final int c3 = 6;
        final int p1 = 10;
        final int a1 = 18;
        final int p2 = 6;
        final int a2 = 15;
        String comando = "21x14x6";
        int[] caselle = {c1, c2, c3, 0};
        Campo c = new Campo();
        c.spostaPedina(p1, a1);
        c.spostaPedina(p2, a2);
        c.getBianco().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertTrue(Arrays.equals(vm.getCaselle(), caselle));
    }

    @Test
    public void testGetCasellePresaMultiplaBiancoC() {
        final int c1 = 23;
        final int c2 = 14;
        final int c3 = 5;
        final int p1 = 11;
        final int a1 = 19;
        final int p2 = 5;
        final int a2 = 15;
        String comando = "23x14x5";
        int[] caselle = {c1, c2, c3, 0};
        Campo c = new Campo();
        c.spostaPedina(p1, a1);
        c.spostaPedina(p1, a2);
        c.getBianco().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertTrue(Arrays.equals(vm.getCaselle(), caselle));
    }

    @Test
    public void testGetDaEliminareSpostamento() {
        String comando = "22-18";
        int[] caselle = {0, 0, 0, 0};
        Campo c = new Campo();
        c.getBianco().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertTrue(Arrays.equals(vm.getDaEliminare(), caselle));
    }

    @Test
    public void testGetDaEliminarePresa() {
        String comando = "21x14";
        final int c1 = 18;
        final int p = 10;
        final int a = 18;
        int[] caselle = {c1, 0, 0, 0};
        Campo c = new Campo();
        c.spostaPedina(p, a);
        c.getBianco().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        assertTrue(Arrays.equals(vm.getDaEliminare(), caselle));
    }

    @Test
    public void testToString() {
        String comando = "22-18";
        Campo c = new Campo();
        c.getBianco().setTurno(true);
        ValidatoreMossa vm = new ValidatoreMossa(comando, c);
        String descrizione = vm.toString();
        String descrizioneAttesa = "ValidatoreMossa: " + "-" + "\n" + "22 18 0 0 " + "\nCorretta: " + "true" + "\n";
        assertEquals(descrizione, descrizioneAttesa);
    }

}
