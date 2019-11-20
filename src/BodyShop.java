import java.util.ArrayList;

public class BodyShop <T> {
    private final int MAX_CARS;
    private ArrayList<T> Garage = new ArrayList<T>();;


    public BodyShop(int maxCars) {
        this.MAX_CARS = maxCars;
    }

    public void addCar (T car) {
        if (Garage.size() < MAX_CARS)
            Garage.add(car);
    }
    public T getCar (T car) {
        int index = Garage.indexOf(car);
        if (index != -1)
        {
            return Garage.remove(index);
        }
        else
            return null;
    }

    public String test () {
        return Garage.toString();
    }

}
