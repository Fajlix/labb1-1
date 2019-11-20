import java.awt.*;

public class Scania extends GenericCar{
    private double flatbedAngle;
    final double THRESHOLD = 0.01;

    public Scania() {
        super(2, Color.black, 220, "Scania", 11);
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }
    public void incrementAngle () {
        if (getCurrentSpeed() == 0) {
           flatbedAngle = Math.min(Math.round((flatbedAngle += 0.1)* 100.0) / 100.0 , 0.7);
        }
    }

    public void decrementAngle () {
        flatbedAngle = Math.max(Math.round((flatbedAngle -= 0.1) * 100.0) / 100.0, 0);
    }

    public double getFlatbedAngle() {
        return flatbedAngle;
    }
    @Override
    public void gas(double amount) {
        if (flatbedAngle == 0)
            super.gas(amount);
    }
}
