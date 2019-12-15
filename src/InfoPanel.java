import Cars.IGenericCar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * A class part of the view that controls the speed labels
 */
public class InfoPanel extends JPanel {
    CarModel carModel;
    ArrayList<JLabel> speedLabels = new ArrayList<>();

    public InfoPanel(int x, int y, CarModel carModel) {
        this.carModel = carModel;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(800, 40));
        this.setBackground(Color.white);
        this.setLocation(0,560);
        createLabels();
    }

    /**
     * Creates all the necessary labels
     */
    public void createLabels(){
        for (IGenericCar car : carModel.getCars()) {
            speedLabels.add(new JLabel());
        }
        updateLabels();
    }

    /**
     * Updates the labels regularly
     */
    public void updateLabels () {
        int x = 0;
        for (IGenericCar car : carModel.getCars()) {
            speedLabels.get(x).setText(car.getModelName() + ": " + Math.round(car.getCurrentSpeed() * 100.0) / 100.0);
            this.add(speedLabels.get(x));
            x++;
        }
    }
}
