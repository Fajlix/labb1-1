import Cars.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

/**
 * A class for the controller of this application
 */
public class CarController {
    CarView frame;
    CarModel carModel;

    public CarController (CarView carView, CarModel carModel)
    {
        this.carModel = carModel;
        frame = carView;
        InitActionListeners();
        int delay = 50;
        Timer timer = new Timer(delay, new TimerListener());
        timer.start();
    }

    /**
     * Updates the application regularly
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            carModel.update();
        }
    }

    /**
     * Part of observer pattern, if a button is pressed the application will listen and update
     */
    void InitActionListeners (){
        frame.gasButton.addActionListener(e -> carModel.gas(frame.gasAmount));
        frame.brakeButton.addActionListener(e -> carModel.brake(frame.gasAmount));

        frame.turboOnButton.addActionListener(e -> carModel.turboOn());
        frame.turboOffButton.addActionListener(e -> carModel.turboOff());

        frame.liftBedButton.addActionListener(e -> carModel.incrementAngle());
        frame.lowerBedButton.addActionListener(e -> carModel.decrementAngle());

        frame.startButton.addActionListener(e -> carModel.startAllCars());
        frame.stopButton.addActionListener(e -> carModel.stopAllCars());

        frame.addCarButton.addActionListener(e -> carModel.addCar(CarFactory.createRandomCar(0,carModel.getNextY())));
        frame.removeCarButton.addActionListener(e -> carModel.removeCar());
    }

}
