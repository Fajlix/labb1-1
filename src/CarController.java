import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.activation.ActivationID;
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

    public CarController() {
        frame = new CarView("CarSim 1.0", this);

        frame.gasButton.addActionListener(e -> gas(frame.gasAmount));
        frame.brakeButton.addActionListener(e -> brake(frame.gasAmount));

        frame.turboOnButton.addActionListener(e-> turboOn());
        frame.turboOffButton.addActionListener(e -> turboOff());

        frame.liftBedButton.addActionListener(e -> liftBed());
        frame.lowerBedButton.addActionListener(e -> lowerBed());

        frame.startButton.addActionListener(e -> start());
        frame.stopButton.addActionListener(e -> stop());
    }

    public static void main(String[] args) {
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());

        cc.cars.add(new Scania(0,100));

        cc.cars.add(new Saab95(0,200));

        //cc.frame = new CarView("CarSim 1.0", cc);

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

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (GenericCar car : cars
        ) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = (double) amount / 100;
        for (GenericCar car : cars
        ) {
            car.brake(brake);
        }
    }
    void turboOn() {
        for (GenericCar car : cars) {
            if (car.getClass() == Saab95.class) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (GenericCar car : cars) {
            if (car.getClass() == Saab95.class) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void liftBed() {
        for (GenericCar car : cars) {
            if (car.getClass() == Scania.class) {
                ((Scania) car).incrementAngle();
            }
        }
    }

    void lowerBed() {
        for (GenericCar car : cars) {
            if (car.getClass() == Scania.class) {
                ((Scania) car).decrementAngle();
            }
        }
    }

    void start() {
        for (GenericCar car : cars) {
            car.startEngine();
        }
    }

    void stop() {
        for (GenericCar car : cars) {
            car.stopEngine();
        }
    }
}
