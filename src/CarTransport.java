import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class CarTransport extends GenericCar {
    enum FlatbedPos {UP, DOWN}

    private FlatbedPos flatbedPos = FlatbedPos.UP;
    private Deque<GenericCar> carsList = new ArrayDeque<>();
    private final int MAX_CARS;
    private final int MAX_SIZE = 8;
    public static final int MAX_DISTANCE = 5;


    /**
     * creates a new CarTransport
     * @param maxCars max cars a carTransport can handle
     */
    public CarTransport(int maxCars) {
        super(2,Color.black,220,"CarTransport", 20);
        MAX_CARS = maxCars;
    }
    /**
     * the speed factor for a Cartransport
     * @return returns the speed factor for a carTransport
     */
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * gets the current value of the carTransport's flatbedPos
     * @return a FlatbedPos value
     */

    public FlatbedPos getFlatbedPos() {
        return flatbedPos;
    }

    /**
     * changes the flatbedPos to UP
     */

    public void liftFlatbed () {
        flatbedPos = FlatbedPos.UP;
    }

    /**
     * changes the flatbedPos to DOWN
     */

    public void lowerFlatbed () {
        if (getCurrentSpeed() == 0)
            flatbedPos = FlatbedPos.DOWN;
    }

    /**
     * adds a car to the CarTransport, to it's carList
     * @param car a vehicle
     */

    public void addCar (GenericCar car) {
        if (carsList.size() < MAX_CARS && car.getSize() < MAX_SIZE && car.getClass() != this.getClass() &&
        flatbedPos == FlatbedPos.DOWN && getDistance(car) <= MAX_DISTANCE)
            carsList.push(car);
    }

    /**
     * removes the next car out of the CarTransport
     * @return returns the vehicle that got removed
     */
    public GenericCar removeNextCar () {
        if (!carsList.isEmpty() && flatbedPos== FlatbedPos.DOWN) {
            carsList.peek().removeFromTransport(this);
            return carsList.pop();
        }
        else
            return null;
    }

    /**
     * Extra term that the flatbed should be UP
     * @param amount the amount which the car should change speed with
     */
    @Override
    public void gas(double amount) {
        if (flatbedPos == FlatbedPos.UP)
            super.gas(amount);
    }

    /**
     * calculates the distance between this and a vehicle
     * @param car a vehicle
     * @return returns a double distance
     */

    private double getDistance (GenericCar car){
        return Math.sqrt(Math.pow(getX() - car.getX(), 2) + Math.pow(getY() - car.getY(), 2));
    }

    /**
     * Returns the list of cars on the car transport
     * @return returns the list of cars
     */
    public Deque<GenericCar> getCarsList() {
        return carsList;
    }
}

