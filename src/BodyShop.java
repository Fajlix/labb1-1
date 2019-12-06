import java.util.ArrayList;

public class BodyShop <T extends GenericCar> {
    private final int MAX_CARS;
    private ArrayList<T> Garage = new ArrayList<>();;

    /**
     * Creates a new BodyShop
     * @param maxCars The max amount of cars a BodyShop can have.
     */
    public BodyShop(int maxCars) {
        this.MAX_CARS = maxCars;
    }

    /**
     * adds a car to the BodyShop, to it's garage list
     * @param car a vehicle
     */
    public void addCar (T car) {
        if (Garage.size() < MAX_CARS)
            Garage.add(car);
    }

    /**
     * takes a car out of the BodyShop
     * @param car a vehicle
     * @return returns the vehicle that got removed
     */
    public T getCar (T car) {
        int index = Garage.indexOf(car);
        if (index != -1)
        {
            return Garage.remove(index);
        }
        else
            return null;
    }

    /**
     * gets the carList
     * @return A arrayList
     */

    public ArrayList<T> getGarage() {
        return Garage;
    }
}
