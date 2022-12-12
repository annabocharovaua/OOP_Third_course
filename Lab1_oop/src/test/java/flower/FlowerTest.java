package flower;

import static org.junit.jupiter.api.Assertions.*;
import flowerShop.Color;
import flower.bigFlower.lilies.Asiatic;
import org.junit.jupiter.api.Test;

class FlowerTest {
    Flower flower = new Asiatic(Color.RED, 140, "2022-11-28");

    @Test
    void getName() {
        assertEquals(NameFlower.LILY_ASIATIC, flower.getName());
    }

    @Test
    void getColor() {
        assertEquals(Color.RED, flower.getColor());
    }

    @Test
    void setColor() {
        flower.setColor(Color.WHITE);
        assertEquals(Color.WHITE, flower.getColor());
    }

    @Test
    void setColorException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> flower.setColor(Color.BLACK));
        assertEquals("Is not valid argument", exception.getMessage());
    }

    @Test
    void getLengthStem() {
        assertEquals(140, flower.getLengthStem());
    }

    @Test
    void setLengthStem() {
        flower.setLengthStem(168);
        assertEquals(168, flower.getLengthStem());
    }

    @Test
    void setLengthException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> flower.setLengthStem(50));
        assertEquals("Length stem is not valid argument", exception.getMessage());
    }

    @Test
    void getPrice() {
        assertEquals(50, flower.getPrice());
    }

    @Test
    void setPrice() {
        flower.setPrice(80);
        assertEquals(80, flower.getPrice());
    }

    @Test
    void getDeliveryData() {
        assertEquals("2022-11-28", flower.getDeliveryDate().toString());
    }

    @Test
    void getFreshness() {
        assertEquals(1, flower.getFreshness());
    }

    @Test
    void setDeliveryData() {
        flower.setDate("2022-11-25");
        assertEquals("2022-11-25", flower.getDeliveryDate().toString());
    }

    @Test
    void setDeliveryException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> flower.setDate("2022-10-10"));
        assertEquals("Stale flowers", exception.getMessage());
    }


}