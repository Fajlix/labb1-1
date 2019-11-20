import java.awt.*;

public class TestCar extends GenericCar{
    public TestCar() {
        super(2, Color.red, 100, "testCar", 5);
    }

    @Override
    public double speedFactor() {
        return 1;
    }
}
