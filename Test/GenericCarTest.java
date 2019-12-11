import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GenericCarTest {
    final double THRESHOLD = 0.00001;

    @Test
    void move() {
        TestCar testCar = new TestCar();
        testCar.gas(1);
        testCar.move();
        assertEquals(1, testCar.getX());
        assertEquals(0, testCar.getY());
    }

    @Test
    void turnLeft() {
        TestCar testCar = new TestCar();
        testCar.turnLeft();
        assertTrue(testCar.getDirection() - Math.PI/6 <= THRESHOLD);
    }

    @Test
    void turnRight() {
        TestCar testCar = new TestCar();
        testCar.turnRight();
        assertTrue(testCar.getDirection() + Math.PI/6 < THRESHOLD);
    }

    @Test
    void getNrDoors() {
        TestCar testCar = new TestCar();
        assertEquals(2, testCar.getNrDoors());
    }

    @Test
    void getCurrentSpeed() {
        TestCar testCar = new TestCar();
        assertEquals(0, testCar.getCurrentSpeed());
    }

    @Test
    void getColor() {
        TestCar testCar = new TestCar();
        assertSame(testCar.getColor(), Color.red);
    }

    @Test
    void setColor() {
        TestCar testCar = new TestCar();
        testCar.setColor(Color.black);
        assertSame(testCar.getColor(), Color.black);
    }

    @Test
    void startEngine() {
        TestCar testCar = new TestCar();
        testCar.startEngine();
        assertEquals(0.1, testCar.getCurrentSpeed());
    }

    @Test
    void stopEngine() {
        TestCar testCar = new TestCar();
        testCar.stopEngine();
        assertEquals(0, testCar.getCurrentSpeed());
    }


    @Test
    void gas() {
        TestCar testCar = new TestCar();
        testCar.startEngine();
        testCar.gas(1);
        assertEquals(1.1, testCar.getCurrentSpeed());
    }

    @Test
    void brake() {
        TestCar testCar = new TestCar();
        testCar.startEngine();
        testCar.gas(1);
        testCar.brake(0.5);
        assertTrue(Math.abs(testCar.getCurrentSpeed() - 0.6) <= THRESHOLD);
    }
}