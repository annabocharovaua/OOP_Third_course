package flower.middleFlower;

import flower.middleFlower.rose.English;
import flowerShop.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiddleFlowerTest {

    MiddleFlower middleFlower = new English(Color.YELLOW, 65, "2022-11-28");

    @Test
    public void setLength () {
        middleFlower.setLengthStem(60);
        assertEquals(60, middleFlower.getLengthStem());
    }

    @Test
    public void setLengthException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> middleFlower.setLengthStem(120));
        assertEquals("Length stem is not valid argument", exception.getMessage());
    }

}