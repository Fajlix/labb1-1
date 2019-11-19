import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    @Test
    void setTurboOn() {
        Saab95 testCar = new Saab95();
        testCar.setTurboOn();
        assertTrue(testCar.isTurboOn() == true);
    }

    @Test
    void setTurboOff() {
        Saab95 testCar = new Saab95();
        testCar.setTurboOff();
        assertTrue(testCar.isTurboOn() == false);
    }

    @Test
    void speedFactor() {
        Saab95 testCar = new Saab95();
        testCar.setTurboOff();
        assertTrue(testCar.speedFactor() == 1.25);
        testCar.setTurboOn();
        assertTrue(testCar.speedFactor() == 1.625);
    }
}