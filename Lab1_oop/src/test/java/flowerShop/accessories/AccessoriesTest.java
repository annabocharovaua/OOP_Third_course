package flowerShop.accessories;

import static org.junit.jupiter.api.Assertions.*;
import flowerShop.accessories.Accessories;
import flowerShop.accessories.packing.Paper;
import flowerShop.Color;
import org.junit.jupiter.api.Test;

class AccessoriesTest {
    Accessories accessory = new Paper(Color.PINK);

    @Test
    void getName() {
        assertEquals(NameAccessory.PAPER, accessory.getName());
    }

    @Test
    void getColor() {
        assertEquals(accessory.getColor(), Color.PINK);
    }

    @Test
    void setColor() {
        accessory.setColor(Color.BLUE);
        assertEquals(accessory.getColor(), Color.BLUE);
    }

    @Test
    void getPrice() {
        assertEquals(accessory.getPrice(),20);
    }


    @Test
    void setPrice() {
        accessory.setPrice(50);
        assertEquals(50, accessory.getPrice());
    }

}