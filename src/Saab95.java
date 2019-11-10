import java.awt.*;

/**
 * A car of type Saab 95
 */
public class Saab95 extends GenericCar{

    /**
     * Says if the turbo is on or off
     */
    public boolean turboOn; // Says if the turbo is on or off

    /**
     * creates a new Saab 95 car
     */
    public Saab95(){
        super(2, Color.red, 125, "Saab95");
    }

    /**
     * turns turbo on
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * turns turbo off
     */

    public void setTurboOff(){
        turboOn = false;
    }

    /**
     * the speed factor for a Saab 95
     * @return returns the speed factor of a Saab 95
     */

    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    /**
     * increments the speed of a saab95
     * @param amount the amount which the car should change speed with
     */

    public void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    /**
     * decrements the speed of a saab95
     * @param amount the amount which the car should change speed with
     */

    public void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }
}
