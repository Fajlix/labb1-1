package Cars;

public interface IGenericCar extends Movable{
    String getModelName();

    double getDirection();

    /**
     * turns the car around and resets the current speed
     */
    void turnAround();

    void setLoaded();

    void setNotLoaded();

    /**
     * checks if the cartrasport is loaded
     * @return returns the boolean
     */
    boolean isLoaded ();

    double getCurrentSpeed();

    /**
     * starts a cars engine
     */
    void startEngine();

    /**
     * stops a cars engine, and speed
     */
    void stopEngine();

    /**
     * the speed factor for a object
     * @return returns the speed factor for a car
     */
    double speedFactor();

    double getX();

    double getY();

    /**
     * accelerates cars current speed
     * @param amount the amount which the car should change speed with
     */
    void gas(double amount);

    /**
     * decelerates cars current speed
     * @param amount the amount which the car should change speed with
     */
    void brake(double amount);
}
