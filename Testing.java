import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class Testing {

    @Test
    public void testVolumen() {
        Radio radio = new Radio(true, Radio.FM, 95.5, 50);
        assertEquals(50, radio.getVolumen());

        radio.setVolumen(75);
        assertEquals(75, radio.getVolumen());

        radio.volUp();
        assertEquals(76, radio.getVolumen());

        radio.volDown();
        assertEquals(75, radio.getVolumen());
    }
    
    @Test
    public void testVolumenLimites() {
        Radio radio = new Radio(true, Radio.FM, 95.5, 50);

        // Aumentar volumen hasta el límite
        for (int i = 50; i <= 100; i++) {
            radio.volUp();
        }
        assertEquals(100, radio.getVolumen());

        // Intentar aumentar más allá del límite
        radio.volUp();
        assertEquals(100, radio.getVolumen());

        // Reducir volumen hasta el límite
        for (int i = 100; i >= 0; i--) {
            radio.volDown();
        }
        assertEquals(0, radio.getVolumen());

        // Intentar reducir más allá del límite
        radio.volDown();
        assertEquals(0, radio.getVolumen());
    }

    @Test
    public void testEncendido() {
        Radio radio = new Radio(false, Radio.AM, 1000.0, 50);
        assertFalse(radio.getEncendido());

        radio.setEncendido(true);
        assertTrue(radio.getEncendido());
    }

    @Test
    public void testEstacionBanda() {
        Radio radio = new Radio(true, Radio.FM, 95.5, 75);
        assertEquals(Radio.FM, radio.getBanda());
        assertEquals(95.5, radio.getEstacion());

        radio.setEstacionBanda(1010.0, Radio.AM);
        assertEquals(Radio.AM, radio.getBanda());
        assertEquals(1010.0, radio.getEstacion());
    }



    @Test
    public void testGuardarRecuperarEstacion() {
        Radio radio = new Radio(true, Radio.FM, 95.5, 50);

        radio.guardarEstacion(98.3, Radio.FM, 1);
        List<Double> emisorasGuardadas = radio.recuperarEstacion(1);

        assertNotNull(emisorasGuardadas);
        assertEquals(1, emisorasGuardadas.size());
        assertEquals(98.3, emisorasGuardadas.get(0));
    }

    @Test
    public void testAproximarNumero() {
        Radio radio = new Radio(true, Radio.AM, 1000.0, 50);

        double frecuenciaAproximada = radio.aproximarNumero(540.25, Radio.AM);
        assertEquals(540.0, frecuenciaAproximada);

        frecuenciaAproximada = radio.aproximarNumero(88.74, Radio.FM);
        assertEquals(88.7, frecuenciaAproximada);
    }

    @Test
    public void testInicializacion() {
        Radio radio = new Radio(true, Radio.AM, 1000.0, 50);

        assertTrue(radio.getEncendido());
        assertEquals(Radio.AM, radio.getBanda());
        assertEquals(1000.0, radio.getEstacion());
        assertEquals(50, radio.getVolumen());
    }

    @Test
    public void testAproximarNumeroInvalido() {
        Radio radio = new Radio(true, Radio.AM, 1000.0, 50);

        // Intentar aproximar un número con una condición no válida
        assertThrows(IllegalArgumentException.class, () -> {
            radio.aproximarNumero(540.25, 2);
        });
    }

}