import Cars.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A facade for the model, the same component as the model of the application
 */
public class CarModel {
    public static final int X = 800;
    public static final int Y = 560;
    public static final int carWith = 100;
    public static final int carHeight = 60;

    private static final int carOffset = 75;

    ArrayList<IGenericCar> cars = new ArrayList<>();
    private List<PaintListener> listeners = new ArrayList<>();

    /**
     * Method for notifying all the listeners
     */
    public void update(){
        for (IGenericCar car : cars) {
            car.move();
            if (collides(car))
                car.turnAround();
        }
        notifyListeners();
    }
    /**
     * Checks if the car collides with the sides of the screen window
     * @param car parameter for the specific car
     * @return returns true or false depending on the cars position, true of it is inside the screen and vice versa
     */
    public boolean collides (IGenericCar car){
        double x = car.getX();
        return  (x + carWith > X &&
                Math.cos(car.getDirection()) > 0 ||
                x < 0 && Math.cos(car.getDirection()) < 0);
    }

    /**
     * Tells all the listeners to
     */
    private void notifyListeners(){
        for (PaintListener l : listeners)
            l.actOnUpdate();
    }

    /**
     * adding a listener
     * @param l parameter for what should be added
     */
    public void addListener(PaintListener l){
        listeners.add(l);
    }

    /**
     * Adding a car to the application
     * @param car parameter for the car that will be added
     */
    public void addCar (IGenericCar car){
        if (cars.size() < 10)
            cars.add(car);
    }
    public void removeCar (){
        if (!cars.isEmpty())
            cars.remove(cars.size()-1);
    }
    public int getNextY(){
        if (cars.size()> 0)
            return (int)cars.get(cars.size() -1).getY() + carOffset;
        return 0;
    }

    /**
     * Composite pattern, accelerating all the cars like we accelerate one car
     * @param amount Parameter for how much the cars will accelerate
     */
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (IGenericCar car : cars) {
            car.gas(gas);
        }
    }

    /**
     * Composite pattern, decelerating all the cars like we decelerate one car
     * @param amount Parameter for how much the cars will decelerate
     */
    void brake(int amount) {
        double brake = (double) amount / 100;
        for (IGenericCar car : cars) {
            car.brake(brake);
        }
    }

    /**
     * Composite pattern, turns the turbo on for all the cars
     */
    void turboOn() {
        for (IGenericCar car : cars) {
            if (car.getClass() == Saab95.class) {
                ((Saab95)car).setTurboOn();
            }
        }
    }

    /**
     * Composite pattern, turns the turbo off for all the cars
     */
    void turboOff() {
        for (IGenericCar car : cars) {
            if (car.getClass() == Saab95.class)
                ((Saab95)car).setTurboOff();
        }
    }

    /**
     * Composite pattern, increments the angle for all the Scania cars
     */
    void incrementAngle () {
        for (IGenericCar car : cars) {
            if (car.getClass() == Scania.class)
                ((Scania)car).incrementAngle();
        }
    }

    /**
     * Composite pattern, decrements the angle for all the Scania cars
     */
    void decrementAngle (){
        for (IGenericCar car : cars) {
            if (car.getClass() == Scania.class)
                ((Scania)car).decrementAngle();
        }
    }

    /**
     * Composite pattern, start all the cars
     */
    void startAllCars () {
        for (IGenericCar car : cars)
            car.startEngine();
    }

    /**
     * Composite pattern, turns off the engine for all the cars
     */
    void stopAllCars () {
        for (IGenericCar car : cars)
            car.stopEngine();
    }

    public ArrayList<IGenericCar> getCars() {
        return cars;
    }
}
