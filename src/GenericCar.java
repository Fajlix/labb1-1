import java.awt.*;
import java.util.Vector;

/**
 * GenericCar class used as a base class for cars
 */
public abstract class GenericCar implements ChangeSpeed, Moveable{


    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private double currentSpeed; // The current speed of the car
    private final String modelName; // The car model name
    private double x; // Current x coordinate
    private double y; // Current y Coordinate
    private double direction; // Current direction

    /**
     * base constructor for a car
     * @param nrDoors Number of doors on a car
     * @param color Color of car
     * @param enginePower The enginePower of a car
     * @param modelName The model name of a car
     */

    public GenericCar(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();
        x = 0;
        y = 0;
        direction = 0;

    }

    /**
     *  Moves car with current speed in a direction
     */
    public void move(){
        x += currentSpeed * Math.cos(direction);
        y += currentSpeed * Math.sin(direction);
    }

    /**
     * turns Car left
     */
    public void turnLeft(){
        direction += Math.PI/6;
    }

    /**
     * turns Car right
     */
    public void turnRight(){
        direction -= Math.PI/6;
    }

    /**
     * get the number of doors on a car
     * @return returns the number of doors on a car
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * get the engine power of a car
     * @return returns engine power
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * get the current speed of a car
     * @return returns the current speed of a car
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * sets current speed of a car
     * @param currentSpeed the new current speed of a car
     */
    public void setCurrentSpeed(double currentSpeed) {
        if (currentSpeed > enginePower)
        {
            setCurrentSpeed(enginePower);
        }
        else if (currentSpeed < 0)
        {
            setCurrentSpeed(0);
        }
        this.currentSpeed = currentSpeed;
    }

    /**
     * get the color of a car
     * @return returns the color of a car
     */
    public Color getColor() {
        return color;
    }

    /**
     * sets color of a car
     * @param color the new color of the car
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * starts a cars engine
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * stops a cars engine, and speed
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * gas the car
     * @param amount the amount which the car should change speed with
     */

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    /**
     * brakes the car
     * @param amount the amount which the car should change speed with
     */

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
    }
}
