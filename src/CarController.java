import Cars.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {

    public static void main(String[] args) {
        CarController cc = new CarController(new CarView("CarSim 1.0"));

        cc.timer.start();
    }

    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());
    CarView frame;
    ArrayList<IGenericCar> cars = new ArrayList<>();

    public CarController (CarView carView)
    {
        cars.add(CarFactory.createSaab95(0,0));
        cars.add(CarFactory.createScania(0,100));
        cars.add(CarFactory.createVolvo240(0,200));
        frame = carView;
        CreateActionListeners();
    }

    void CreateActionListeners (){
        frame.gasButton.addActionListener(e -> gas(frame.gasAmount));
        frame.brakeButton.addActionListener(e -> brake(frame.gasAmount));

        frame.turboOnButton.addActionListener(e -> turboOn());
        frame.turboOffButton.addActionListener(e -> turboOff());

        frame.liftBedButton.addActionListener(e -> incrementAngle());
        frame.lowerBedButton.addActionListener(e -> decrementAngle());

        frame.startButton.addActionListener(e -> startAllCars());
        frame.stopButton.addActionListener(e -> stopAllCars());
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

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (IGenericCar car : cars) {
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                if (x + frame.drawPanel.getImage(car.getModelName()).getWidth() > frame.drawPanel.getWidth() &&
                        Math.cos(car.getDirection()) > 0 ||
                        x < 0 && Math.cos(car.getDirection()) < 0)
                {
                    car.stopEngine();
                    car.turnAround();
                    car.startEngine();
                }
                frame.speedLabel.setText("Speed: " + car.getCurrentSpeed());
                frame.drawPanel.setCars(cars);
                frame.drawPanel.repaint();
            }
        }
    }

    public ArrayList<IGenericCar> getCars() {
        return cars;
    }
}
