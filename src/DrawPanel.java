import Cars.IGenericCar;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    ArrayList<IGenericCar> cars = new ArrayList<>();

    // TODO: Make this general for all cars

    public DrawPanel(int x, int y) {

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (IGenericCar car : cars) {
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

    public void setCars(ArrayList<IGenericCar> cars) {
        this.cars = cars;
    }
}
