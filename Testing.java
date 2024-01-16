import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Testing {

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
}
