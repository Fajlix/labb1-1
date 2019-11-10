import java.awt.*;

/**
 * a car of type Volvo 240
 */
public class Volvo240 extends GenericCar{

    public final static double trimFactor = 1.25; // A constant for the trim factor

    /**
     * creates a new Volvo 240 car
     */
    public Volvo240(){
        super(4, Color.black, 100, "Volvo240");
    }

    /**
     * the speed factor for a Volvo 240
     * @return returns the speed factor of a Volvo 240
     */

    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    /**
     * increments the speed of a Volvo 240
     * @param amount the amount which the car should change speed with
     */

    public void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }

    /**
     * decrements the speed of a Volvo 240
     * @param amount the amount which the car should change speed with
     */

    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }
}
