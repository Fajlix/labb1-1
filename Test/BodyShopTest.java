import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyShopTest {

    @Test
    void addCar() {
        BodyShop<Volvo240> testShop = new BodyShop(700);
        testShop.addCar(new Volvo240());
        assertTrue(testShop.getGarage().size() == 1);
    }

    @Test
    void getCar() {
        BodyShop<Volvo240> testShop = new BodyShop(700);
        Volvo240 testCar = new Volvo240();
        testShop.addCar(testCar);
        testShop.getCar(testCar);
        assertTrue(testShop.getGarage().size() == 0);
    }
}