public class Test {
    public static void main(String[] args) {
        CarTransport testTransport = new CarTransport();
        testTransport.lowerFlatbed();
        BodyShop<Volvo240> bodyShop = new BodyShop<>(10);
        BodyShop<GenericCar> bodyShop1 = new BodyShop<>(10);
        Scania testScania = new Scania();
        Volvo240 testVolvo = new Volvo240();
        Saab95 testSaab = new Saab95();

        bodyShop.addCar(testVolvo);
        bodyShop1.addCar(testSaab);
        bodyShop1.addCar(testScania);
        System.out.println(bodyShop.test());
        System.out.println(bodyShop1.test());



        testTransport.addCar(testScania);
        testTransport.addCar(testTransport);
        testTransport.addCar(testVolvo);
        testTransport.addCar(testSaab);
        testTransport.addCar(testVolvo);
        testTransport.removeNextCar();
    }
}
