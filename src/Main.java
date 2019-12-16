import Cars.CarFactory;

public class Main {
    public static void main(String[] args) {
        CarModel carModel = initCars();
        CarView carView = new CarView("CarSim 1.0", carModel);
        CarController cc = new CarController(carView, carModel);
        cc.carModel.addListener(carView.drawPanel);
        cc.carModel.addListener(carView.infoPanel);
    }


    public static CarModel initCars(){
        CarModel carModel = new CarModel();
        carModel.addCar(CarFactory.createSaab95(0,carModel.getNextY()));
        carModel.addCar(CarFactory.createScania(0,carModel.getNextY()));
        carModel.addCar(CarFactory.createVolvo240(0,carModel.getNextY()));
        return carModel;
    }
}
