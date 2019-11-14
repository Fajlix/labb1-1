import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GenericCarTest {
    final double THRESHOLD = 0.0000001;

    @Test
    void move() {
        TestCar testCar = new TestCar();
        testCar.gas(1);
        testCar.move();
        assertTrue(testCar.getX() == 1);
        assertTrue(testCar.getY() == 0);
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
        assertTrue(testCar.getNrDoors() == 2);
    }

    @Test
    void getEnginePower() {
        TestCar testCar = new TestCar();
        assertTrue(testCar.getEnginePower() == 100);
    }

    @Test
    void getCurrentSpeed() {
        TestCar testCar = new TestCar();
        assertTrue(testCar.getCurrentSpeed() == 0);
    }

    @Test
    void getColor() {
        TestCar testCar = new TestCar();
        assertTrue(testCar.getColor() == Color.red);
    }

    @Test
    void setColor() {
        TestCar testCar = new TestCar();
        testCar.setColor(Color.black);
        assertTrue(testCar.getColor() == Color.black);
    }

    @Test
    void startEngine() {
        TestCar testCar = new TestCar();
        testCar.startEngine();
        assertTrue(testCar.getCurrentSpeed() == 0.1);
    }

    @Test
    void stopEngine() {
        TestCar testCar = new TestCar();
        testCar.stopEngine();
        assertTrue(testCar.getCurrentSpeed() == 0);
    }


    @Test
    void gas() {
        TestCar testCar = new TestCar();
        testCar.startEngine();
        testCar.gas(1);
        assertTrue(testCar.getCurrentSpeed() == 1.1);
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