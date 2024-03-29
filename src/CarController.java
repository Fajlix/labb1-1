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
    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());
    CarView frame;
    ArrayList<GenericCar> cars = new ArrayList<>();

    public CarController ()
    {
        frame = new CarView("CarSim 1.0");

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
        for (GenericCar car : cars) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = (double) amount / 100;
        for (GenericCar car : cars) {
            car.brake(brake);
        }
    }
    void turboOn() {
        for (GenericCar car : cars) {
            if (car.getClass() == Saab95.class) {
                ((Saab95)car).setTurboOn();
            }
        }
    }
    void turboOff() {
        for (GenericCar car : cars) {
            if (car.getClass() == Saab95.class)
                ((Saab95)car).setTurboOff();
        }
    }
    void incrementAngle () {
        for (GenericCar car : cars) {
            if (car.getClass() == Scania.class)
                ((Scania)car).incrementAngle();
        }
    }
    void decrementAngle (){
        for (GenericCar car : cars) {
            if (car.getClass() == Scania.class)
                ((Scania)car).decrementAngle();
        }
    }
    void startAllCars () {
        for (GenericCar car : cars)
            car.startEngine();
    }
    void stopAllCars () {
        for (GenericCar car : cars)
            car.stopEngine();
    }

    public static void main(String[] args) {
        CarController cc = new CarController();
        cc.cars.add(new Volvo240());
        cc.cars.add(new Scania(0,100));
        cc.cars.add(new Saab95(0,200));

        cc.timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (GenericCar car : cars) {
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
                frame.drawPanel.setCars(cars);
                frame.drawPanel.repaint();
            }
        }
    }

    public ArrayList<GenericCar> getCars() {
        return cars;
    }
}
