import Cars.IGenericCar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * A class part of the view that controls the speed labels
 */
public class InfoPanel extends JPanel implements PaintListener{
    CarView view;
    private ArrayList<JLabel> speedLabels = new ArrayList<>();

    public InfoPanel(int x, int y, CarView view) {
        this.view = view;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);
        createLabels();
    }

    /**
     * Creates all the necessary labels
     */
    private void createLabels(){
        removeAll();
        speedLabels = new ArrayList<>();
        for (IGenericCar car : view.carModel.getCars()) {
            speedLabels.add(new JLabel());
        }
        updateLabels();
    }

    /**
     * Updates the labels regularly
     */
    public void updateLabels () {
        if (speedLabels.size() != view.carModel.getCars().size())
            createLabels();
        else {
            int x = 0;
            for (IGenericCar car : view.carModel.getCars()) {
                speedLabels.get(x).setText(car.getModelName() + ": " + Math.round(car.getCurrentSpeed() * 100.0) / 100.0);
                this.add(speedLabels.get(x));
                x++;
            }
        }
    }

    @Override
    public void actOnUpdate() {
        updateLabels();
    }
}
