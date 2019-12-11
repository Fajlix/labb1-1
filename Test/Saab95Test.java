import Cars.Saab95;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    @Test
    void setTurboOn() {
        Saab95 testCar = new Saab95();
        testCar.setTurboOn();
        assertTrue(testCar.isTurboOn());
    }

    @Test
    void setTurboOff() {
        Saab95 testCar = new Saab95();
        testCar.setTurboOff();
        assertFalse(testCar.isTurboOn());
    }

    @Test
    void speedFactor() {
        Saab95 testCar = new Saab95();
        testCar.setTurboOff();
        assertEquals(1.25, testCar.speedFactor());
        testCar.setTurboOn();
        assertEquals(1.625, testCar.speedFactor());
    }
}