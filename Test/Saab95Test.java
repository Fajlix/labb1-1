import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    @Test
    void setTurboOn() {
        Saab95 testcar = new Saab95();
        testcar.setTurboOn();
        assertTrue(testcar.isTurboOn() == true);
    }

    @Test
    void setTurboOff() {
        Saab95 testcar = new Saab95();
        testcar.setTurboOff();
        assertTrue(testcar.isTurboOn() == false);
    }

    @Test
    void speedFactor() {
        Saab95 testcar = new Saab95();
        testcar.setTurboOff();
        assertTrue(testcar.speedFactor() == 1.25);
        testcar.setTurboOn();
        assertTrue(testcar.speedFactor() == 1.625);
    }
}