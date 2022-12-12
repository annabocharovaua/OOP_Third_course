package flower.smallFlower;

import static org.junit.jupiter.api.Assertions.*;

import flower.smallFlower.violet.Pansies;
import flowerShop.Color;
import org.junit.jupiter.api.Test;

class SmallFlowerTest {

    SmallFlower smallFlower = new Pansies(Color.PINK, 15, "2022-11-28");

    @Test
    public void setLength () {
        smallFlower.setLengthStem(12);
        assertEquals(12, smallFlower.getLengthStem());
    }

    @Test
    public void setLengthException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> smallFlower.setLengthStem(120));
        assertEquals("Length stem is not valid argument", exception.getMessage());
    }
}