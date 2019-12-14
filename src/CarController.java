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
    public boolean collides (IGenericCar car){
        double x = car.getX();
        return  (x + frame.drawPanel.getImage(car.getModelName()).getWidth() > frame.drawPanel.getWidth() &&
                Math.cos(car.getDirection()) > 0 ||
                x < 0 && Math.cos(car.getDirection()) < 0);
    }
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
