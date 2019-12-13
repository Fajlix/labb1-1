import Cars.Volvo240;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {

    @Test
    void speedFactor() {
        Volvo240 testCar = new Volvo240();
        assertEquals(1.25, testCar.speedFactor());
    }
}