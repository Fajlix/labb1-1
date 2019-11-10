public interface ChangeSpeed {
    /**
     * the speed factor for a object
     * @return returns the speed factor for a car
     */
    double speedFactor();

    /**
     * increments the speed of a object
     * @param amount the amount which the car should change speed with
     */
    void incrementSpeed(double amount);

    /**
     * decrements the speed of a object
     * @param amount the amount which the car should change speed with
     */
    void decrementSpeed(double amount);
}
