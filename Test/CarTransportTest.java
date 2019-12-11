import Cars.CarTransport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTransportTest {
    final double THRESHOLD = 0.00001;

    @Test
    void speedFactor() {
        CarTransport testCar = new CarTransport(5);
        assertEquals(2.2, testCar.speedFactor());
    }

    @Test
    void getFlatbedPos() {
        CarTransport testCar = new CarTransport(5);
        assertSame(testCar.getFlatbedPos(), CarTransport.FlatbedPos.UP);
    }

    @Test
    void liftFlatbed() {
        CarTransport testCar = new CarTransport(5);
        testCar.liftFlatbed();
        assertSame(testCar.getFlatbedPos(), CarTransport.FlatbedPos.UP);
    }

    @Test
    void lowerFlatbed() {
        CarTransport testCar = new CarTransport(5);
        testCar.lowerFlatbed();
        assertSame(testCar.getFlatbedPos(), CarTransport.FlatbedPos.DOWN);
    }

    @Test
    void addCar() {
        CarTransport testCar = new CarTransport(5);
        TestCar testCar1 = new TestCar();
        testCar.lowerFlatbed();
        testCar.addCar(testCar1);
        assertEquals(1, testCar.getCarsList().size());
    }

    @Test
    void removeNextCar() {
        CarTransport testCar = new CarTransport(5);
        TestCar testCar1 = new TestCar();
        testCar.addCar(testCar1);
        testCar.removeNextCar();
        assertEquals(0, testCar.getCarsList().size());
    }

    @Test
    void gas() {
        CarTransport testCar = new CarTransport(5);
        testCar.startEngine();
        testCar.gas(1);
        assertTrue(Math.abs(testCar.getCurrentSpeed() - 2.3) <= THRESHOLD);
    }
}