import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {
    final double THRESHOLD = 0.00001;

    @Test
    void speedFactor() {
        Scania testCar = new Scania();
        assertTrue(testCar.speedFactor() == 2.2);
    }

    @Test
    void incrementAngle() {
        Scania testCar = new Scania();
        testCar.incrementAngle();
        assertTrue(testCar.getFlatbedAngle() == 0.1);
    }

    @Test
    void decrementAngle() {
        Scania testCar = new Scania();
        testCar.incrementAngle();
        testCar.incrementAngle();
        testCar.decrementAngle();
        assertTrue(testCar.getFlatbedAngle() == 0.1);
    }

    @Test
    void getFlatbedAngle() {
        Scania testCar = new Scania();
        assertTrue(testCar.getFlatbedAngle() == 0);
    }

    @Test
    void gas() {
        Scania testCar = new Scania();
        testCar.startEngine();
        testCar.gas(1);
        assertTrue(Math.abs(testCar.getCurrentSpeed() - 2.3) <= THRESHOLD);
    }

}