package Cars;

public interface IGenericCar extends Movable{
    String getModelName();
    double getDirection();
    void turnAround();
    void setLoaded();
    void setNotLoaded();
    boolean isLoaded ();
    double getCurrentSpeed();
    void startEngine();
    void stopEngine();
    double speedFactor();
    double getX();
    double getY();
    void gas(double amount);
    void brake(double amount);
}
