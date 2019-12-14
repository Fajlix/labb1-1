import Cars.CarFactory;

public class Main {
    public static void main(String[] args) {
        CarModel carModel = initCars();
        CarView carView = new CarView("CarSim 1.0", carModel);
        carView.createLabels();
        CarController cc = new CarController(carView, carModel);
    }
    public static CarModel initCars(){
        CarModel carModel = new CarModel();
        carModel.addCar(CarFactory.createSaab95(0,0));
        carModel.addCar(CarFactory.createScania(0,100));
        carModel.addCar(CarFactory.createVolvo240(0,200));
        return carModel;
    }
}
