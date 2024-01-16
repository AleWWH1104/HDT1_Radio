package test;

import org.junit.jupiter.api.Test;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testing {

    @Test
    public void testSetVolWithinRange() {
        Radio radio = new Radio();
        radio.setVol(50);

        int volumen = radio.getVol();

        assertEquals(50, volumen);
    }

    @Test
    public void testSetVolBelowRange() {
        Radio radio = new Radio();
        radio.setVol(-5);

        int volumen = radio.getVol();

        assertEquals(0, volumen); // Debería ajustarse al límite inferior
    }

    @Test
    public void testSetVolAboveRange() {
        Radio radio = new Radio();
        radio.setVol(120);

        int volumen = radio.getVol();

        assertEquals(100, volumen); // Debería ajustarse al límite superior
    }

    @Test
    public void testVolUpWithinRange() {
        Radio radio = new Radio();
        radio.setVol(80);

        radio.volUp();

        int volumen = radio.getVol();

        assertEquals(81, volumen);
    }

    @Test
    public void testVolUpAtMax() {
        Radio radio = new Radio();
        radio.setVol(100);

        radio.volUp();

        int volumen = radio.getVol();

        assertEquals(100, volumen); // No debería exceder el límite máximo
    }

    @Test
    public void testVolDownWithinRange() {
        Radio radio = new Radio();
        radio.setVol(30);

        radio.volDown();

        int volumen = radio.getVol();

        assertEquals(29, volumen);
    }

    @Test
    public void testVolDownAtMin() {
        Radio radio = new Radio();
        radio.setVol(0);

        radio.volDown();

        int volumen = radio.getVol();

        assertEquals(0, volumen); // No debería caer por debajo del límite mínimo
    }
}

