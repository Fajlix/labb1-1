package Cars;

import java.awt.*;

/**
 * Class for a Scania
 */
public class Scania extends GenericCar {
    private double flatbedAngle;

    public Scania() {
        super(2, Color.black, 220, "Scania", 11,0,0);
    }
    public Scania(int x, int y)  {
        super(2, Color.black, 220, "Scania", 11, x,y);
    }

    /**
     * the speed factor for a Cars.Scania
     * @return returns the speed factor of a Cars.Scania
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * starts the car engine, but the flatbed must be down
     */
    @Override
    public void startEngine() {
        if (flatbedAngle == 0)
            super.startEngine();
    }

    /**
     * increases the angle of the flatbed
     */
    public void incrementAngle () {
        if (getCurrentSpeed() == 0) {
           flatbedAngle = Math.min(Math.round((flatbedAngle += 0.1)* 100.0) / 100.0 , 0.7);
        }
    }

    /**
     * decreases the angle of the flatbed
     */
    public void decrementAngle () {
        flatbedAngle = Math.max(Math.round((flatbedAngle -= 0.1) * 100.0) / 100.0, 0);
    }

    public double getFlatbedAngle() {
        return flatbedAngle;
    }

    /**
     * Extra term that the flatbed should be flat
     * @param amount the amount which the car should change speed with
     */
    @Override
    public void gas(double amount) {
        if (flatbedAngle == 0)
            super.gas(amount);
    }
}
