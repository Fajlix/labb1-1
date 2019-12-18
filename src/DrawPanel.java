import Cars.IGenericCar;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

/**
 * Class for the panel that the cars move on
 */
public class DrawPanel extends JPanel implements PaintListener{
    CarView view;

    public DrawPanel(int x, int y, CarView view) {
        this.view = view;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    /**
     * Paints all the cars
     *
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (IGenericCar car : view.carModel.getCars()) {
            g.drawImage(getImage(car.getModelName()), (int) car.getX(), (int) car.getY(),
                    CarModel.carWith, CarModel.carHeight, null); // see javadoc for more info on the parameters
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

    /**
     * Repaints the panel, acts on updates
     */
    @Override
    public void actOnUpdate() {
        repaint();
    }
}
