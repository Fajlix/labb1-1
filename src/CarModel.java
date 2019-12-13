import Cars.*;

import java.util.ArrayList;

public class CarModel {
    public static final int X = 800;
    public static final int Y = 800;

    private CarFactory carFactory = new CarFactory();
    ArrayList<IGenericCar> carArrayList = new ArrayList<>();

    public CarModel(){
        carArrayList.add(CarFactory.createSaab95(0,0));
        carArrayList.add(CarFactory.createScania(0,100));
        carArrayList.add(CarFactory.createVolvo240(0,200));
    }

}
