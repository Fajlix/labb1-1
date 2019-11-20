import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class CarTransport extends GenericCar {
    enum FlatbedPos {UP, DOWN}

    private FlatbedPos flatbedPos = FlatbedPos.UP;
    private Deque<GenericCar> carsList = new ArrayDeque<>();
    private final int MAX_CARS = 5;
    private final int MAX_SIZE = 8;
    public CarTransport() {
        super(2,Color.black,300,"CarTransport", 20);
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

    public void liftFlatbed () {
        flatbedPos = FlatbedPos.UP;
    }

    public void lowerFlatbed () {
        if (getCurrentSpeed() == 0)
            flatbedPos = FlatbedPos.DOWN;
    }
    public void addCar (GenericCar car) {
        if (carsList.size() < MAX_CARS && car.size < MAX_SIZE && car.getClass() != this.getClass() &&
        flatbedPos == FlatbedPos.DOWN)
            carsList.push(car);
    }
    public GenericCar removeNextCar () {
        if (!carsList.isEmpty())
            return carsList.pop();
        else
            return null;
    }
    @Override
    public void gas(double amount) {
        if (flatbedPos == FlatbedPos.UP)
            super.gas(amount);
    }

    public String getCarsListString() {
        return carsList.toString();
    }
}

