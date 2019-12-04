import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    BufferedImage image;
    Point volvoPoint = new Point();
    ArrayList<GenericCar> cars = new ArrayList<>();

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
        for (GenericCar car : cars) {
            g.drawImage(car.getImage(), (int) car.getX(), (int) car.getY(), null); // see javadoc for more info on the parameters
        }
    }

    public void setCars(ArrayList<GenericCar> cars) {
        this.cars = cars;
    }
}
