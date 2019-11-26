import java.util.ArrayDeque;
import java.util.Deque;

public class StoreCars implements IStoreCars{
    Deque<GenericCar> carsList = new ArrayDeque<>();

    public GenericCar removeNextCar() {
        return null;
    }

    public void addCar(GenericCar car) {

    }

    public double getDistance(GenericCar car) {
        return 0;
    }

    public Deque<GenericCar> getCarsList() {
        return null;
    }
}
