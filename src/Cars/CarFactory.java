package Cars;

/**
 * A class that creates the cars wanted from the start
 */
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
    public static IGenericCar createRandomCar(int x, int y){
        int rand = (int)(Math.random()*3);
        switch (rand){
            case 0:
                return createSaab95(x,y);
            case 1:
                return createVolvo240(x,y);
            case 2:
                return createScania(x,y);
            default:
                return createRandomCar(x,y);
        }
    }
}
