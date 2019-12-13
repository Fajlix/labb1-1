package Cars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {
    final double THRESHOLD = 0.00001;

    @Test
    void speedFactor() {
        Scania testCar = new Scania();
        assertEquals(2.2, testCar.speedFactor());
    }

    @Test
    void incrementAngle() {
        Scania testCar = new Scania();
        testCar.incrementAngle();
        assertEquals(0.1, testCar.getFlatbedAngle());
    }

    @Test
    void decrementAngle() {
        Scania testCar = new Scania();
        testCar.incrementAngle();
        testCar.incrementAngle();
        testCar.decrementAngle();
        assertEquals(0.1, testCar.getFlatbedAngle());
    }

    @Test
    void getFlatbedAngle() {
        Scania testCar = new Scania();
        assertEquals(0, testCar.getFlatbedAngle());
    }

    @Test
    void gas() {
        Scania testCar = new Scania();
        testCar.startEngine();
        testCar.gas(1);
        assertTrue(Math.abs(testCar.getCurrentSpeed() - 2.3) <= THRESHOLD);
    }

}