public class Test {
    public static void main(String[] args) {
        Scania testCar = new Scania();
        testCar.incrementAngle();
        testCar.incrementAngle();
        testCar.incrementAngle();
        testCar.incrementAngle();
        testCar.decrementAngle();
        testCar.decrementAngle();
        testCar.decrementAngle();
        testCar.gas(1);
        System.out.println(testCar.getCurrentSpeed());
        System.out.println(testCar.getFlatbedAngle());
    }
}
