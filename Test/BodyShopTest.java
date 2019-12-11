import Cars.BodyShop;
import Cars.Volvo240;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyShopTest {

    @Test
    void addCar() {
        BodyShop<Volvo240> testShop = new BodyShop<>(700);
        testShop.addCar(new Volvo240());
        assertEquals(1, testShop.getGarage().size());
    }

    @Test
    void getCar() {
        BodyShop<Volvo240> testShop = new BodyShop<>(700);
        Volvo240 testCar = new Volvo240();
        testShop.addCar(testCar);
        testShop.getCar(testCar);
        assertEquals(0, testShop.getGarage().size());
    }
}