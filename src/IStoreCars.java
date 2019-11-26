import java.util.*;

public interface IStoreCars {

    GenericCar removeNextCar ();

    void addCar (GenericCar car);

    double getDistance (GenericCar car);

    Deque<GenericCar> getCarsList();
}
