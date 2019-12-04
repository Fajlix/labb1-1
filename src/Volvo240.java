import java.awt.*;

/**
 * a car of type Volvo 240
 */
public class Volvo240 extends GenericCar{

    private final static double trimFactor = 1.25; // A constant for the trim factor

    /**
     * creates a new Volvo 240 car
     */
    public Volvo240(){
        super(4, Color.black, 100, "Volvo240", 5, "pics/Volvo240.jpg", 0,0);
    }
    public Volvo240(int x, int y) {
        super(4, Color.black, 100, "Volvo240", 5, "pics/Volvo240.jpg", x,y);
    }

    /**
     * the speed factor for a Volvo 240
     * @return returns the speed factor of a Volvo 240
     */

    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
