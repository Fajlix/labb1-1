import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.channels.Pipe;
import java.util.Vector;

/**
 * GenericCar class used as a base class for cars
 */
public abstract class GenericCar implements Movable{

    private int size; // Size of car (for transport)
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private double currentSpeed; // The current speed of the car
    private final String modelName; // The car model name
    private double x; // Current x coordinate
    private double y; // Current y Coordinate
    private double direction; // Current direction
    private boolean isLoaded; // If the car is loaded somewhere


    /**
     * base constructor for a car
     * @param nrDoors Number of doors on a car
     * @param color Color of car
     * @param enginePower The enginePower of a car
     * @param modelName The model name of a car
     */

    public GenericCar(int nrDoors, Color color, double enginePower, String modelName, int size, int x, int y) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.size = size;
        this.x = x;
        this.y = y;
        direction = 2 * Math.PI;
        isLoaded = false;
        stopEngine();
    }
    public GenericCar(int nrDoors, Color color, double enginePower, String modelName, int size) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.size = size;
        x = 0;
        y = 0;
        direction = 2 * Math.PI;
        stopEngine();
    }

    public double getDirection() {
        return direction;
    }

    public String getModelName() {
        return modelName;
    }

    /**
     *  Moves car with current speed in a direction
     */
    public void move(){
        if (!isLoaded) {
            x += currentSpeed * Math.cos(direction);
            y += currentSpeed * Math.sin(direction);
        }
    }

    /**
     * turns Car left
     */
    public void turnLeft(){
        if (!isLoaded)
            direction += Math.PI/6;
    }

    /**
     * turns Car right
     */
    public void turnRight(){
        if (!isLoaded)
            direction -= Math.PI/6;
    }

    public void turnAround() {
        if (currentSpeed == 0 && !isLoaded)
            direction += Math.PI;
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
     * get the color of a car
     * @return returns the color of a car
     */
    public Color getColor() {
        return color;
    }

    public int getSize() {
        return size;
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
        if (!isLoaded && currentSpeed == 0)
            currentSpeed = 0.1;
    }

    /**
     * stops a cars engine, and speed
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * the speed factor for a object
     * @return returns the speed factor for a car
     */
    protected abstract double speedFactor();

    public void loadVehicle() {
        isLoaded = true;
    }

    public void unloadVehicle() {
        isLoaded = false;
    }

    protected void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean isLoaded() {
        return isLoaded;
    }

    /**
     * increments the speed of a Car
     * @param amount the amount which the car should change speed with
     */
    private void incrementSpeed(double amount){
        if (!isLoaded)
            currentSpeed = Math.min(currentSpeed + speedFactor() * amount,getEnginePower());
    }

    /**
     * decrements the speed of a Car
     * @param amount the amount which the car should change speed with
     */
    private void decrementSpeed(double amount){
        if (!isLoaded)
            currentSpeed = Math.max(currentSpeed - speedFactor() * amount,0);
    }

    /***
     * gets current x pos for car
     * @return returns a cars x
     */
    public double getX() {
        return x;
    }

    /***
     * gets current y pos for car
     * @return returns a cars y
     */

    public double getY() {
        return y;
    }

    /**
     * accelerates cars current speed
     * @param amount the amount which the car should change speed with
     */

    public void gas(double amount){
        if (amount >= 0 && amount <= 1 && !isLoaded) {
            incrementSpeed(amount);
        }
    }

    /**
     * decelerates cars current speed
     * @param amount the amount which the car should change speed with
     */

    public void brake(double amount){
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
    }
}
