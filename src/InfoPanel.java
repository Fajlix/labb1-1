import Cars.IGenericCar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
    public void createLabels(){
        for (IGenericCar car : carModel.getCars()) {
            speedLabels.add(new JLabel());
        }
        updateLabels();
    }
    public void updateLabels () {
        int x = 0;
        for (IGenericCar car : carModel.getCars()) {
            speedLabels.get(x).setText(car.getModelName() + ": " + car.getCurrentSpeed());
            this.add(speedLabels.get(x));
            x++;
        }
    }
}
