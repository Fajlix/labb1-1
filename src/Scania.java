import java.awt.*;

public class Scania extends GenericCar{
    private double flatbedAngle;
    final double THRESHOLD = 0.01;

    /**
     * creates a new Scania
     */
    public Scania() {
        super(2, Color.black, 220, "Scania", 11, "pics/Scania.jpg",0,0);
    }
    public Scania(int x, int y)  {
        super(2, Color.black, 220, "Scania", 11, "pics/Scania.jpg",x,y);
    }

    /**
     * the speed factor for a Scania
     * @return returns the speed factor of a Scania
     */
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
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

    /**
     * gets the current flatbedAngle
     * @return returns a double angle
     */

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
