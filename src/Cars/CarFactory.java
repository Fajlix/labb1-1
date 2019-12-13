package Cars;

public class CarFactory {
    public static IGenericCar createSaab95(int x, int y){
        return new Saab95(x,y);
    }
    public static IGenericCar createVolvo240(int x, int y){
        return new Volvo240(x,y);
    }
    public static IGenericCar createScania(int x, int y){
        return new Scania(x,y);
    }
}
