package flower.bigFlower;

import static org.junit.jupiter.api.Assertions.*;
import flower.bigFlower.lilies.Asiatic;
import flowerShop.Color;
import org.junit.jupiter.api.Test;


class BigFlowerTest {
    BigFlower bigFlower = new Asiatic(Color.RED, 140, "2022-11-28");

    @Test
    public void setLength () {
        bigFlower.setLengthStem(180);
        assertEquals(180, bigFlower.getLengthStem());
    }

    @Test
    public void setLengthException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> bigFlower.setLengthStem(50));
        assertEquals("Length stem is not valid argument", exception.getMessage());
    }


}