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
    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());
    CarView frame;
    CarModel carModel;

    public CarController (CarView carView, CarModel carModel)
    {
        this.carModel = carModel;
        frame = carView;
        carModel.addListener(carView.drawPanel);
        InitActionListeners();
        timer.start();
    }

    /**
     * Updates the application regularly
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (IGenericCar car : carModel.getCars()) {
                car.move();
                if (collides(car))
                    car.turnAround();
                carModel.update();
                frame.infoPanel.updateLabels();
            }
        }
    }

    /**
     * Checks if the car collides with the sides of the screen window
     * @param car parameter for the specific car
     * @return returns true or false depending on the cars position, true of it is inside the screen and vice versa
     */
    public boolean collides (IGenericCar car){
        double x = car.getX();
        return  (x + frame.drawPanel.getImage(car.getModelName()).getWidth() > frame.drawPanel.getWidth() &&
                Math.cos(car.getDirection()) > 0 ||
                x < 0 && Math.cos(car.getDirection()) < 0);
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
    }

}
