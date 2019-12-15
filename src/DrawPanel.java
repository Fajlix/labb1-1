import Cars.IGenericCar;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

/**
 * Class for the panel that the cars move on
 */
public class DrawPanel extends JPanel implements PaintListener{
    CarModel carModel;

    public DrawPanel(int x, int y, CarModel carModel) {
        this.carModel = carModel;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    /**
     * Paints all the cars
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (IGenericCar car : carModel.getCars()) {
            g.drawImage(getImage(car.getModelName()), (int) car.getX(), (int) car.getY(), null); // see javadoc for more info on the parameters
        }
    }

    public BufferedImage getImage (String modelName){
        BufferedImage image = null;
        try {
            image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + modelName + ".jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return image;
    }
    @Override
    public void actOnUpdate() {
        repaint();
    }

}
