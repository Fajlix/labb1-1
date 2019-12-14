import Cars.*;

import java.util.ArrayList;
import java.util.List;

public class CarModel {
    public static final int X = 800;
    public static final int Y = 800;

    ArrayList<IGenericCar> cars = new ArrayList<>();
    private List<PaintListener> listeners = new ArrayList<>();
    public void update(){
        notifyListeners();
    }

    public void addCar (IGenericCar car){
        cars.add(car);
    }
    private void notifyListeners(){
        for (PaintListener l : listeners)
            l.actOnUpdate();
    }
    public void addListener(PaintListener l){
        listeners.add(l);
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (IGenericCar car : cars) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = (double) amount / 100;
        for (IGenericCar car : cars) {
            car.brake(brake);
        }
    }
    void turboOn() {
        for (IGenericCar car : cars) {
            if (car.getClass() == Saab95.class) {
                ((Saab95)car).setTurboOn();
            }
        }
    }
    void turboOff() {
        for (IGenericCar car : cars) {
            if (car.getClass() == Saab95.class)
                ((Saab95)car).setTurboOff();
        }
    }
    void incrementAngle () {
        for (IGenericCar car : cars) {
            if (car.getClass() == Scania.class)
                ((Scania)car).incrementAngle();
        }
    }
    void decrementAngle (){
        for (IGenericCar car : cars) {
            if (car.getClass() == Scania.class)
                ((Scania)car).decrementAngle();
        }
    }
    void startAllCars () {
        for (IGenericCar car : cars)
            car.startEngine();
    }
    void stopAllCars () {
        for (IGenericCar car : cars)
            car.stopEngine();
    }
    public ArrayList<IGenericCar> getCars() {
        return cars;
    }

}
