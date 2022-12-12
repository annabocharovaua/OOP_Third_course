package flowerShop;

import static org.junit.jupiter.api.Assertions.*;
import flower.bigFlower.lilies.Asiatic;
import flowerShop.Color;
import flower.Flower;
import org.junit.jupiter.api.Test;

class WarehouseTest {

    Warehouse warehouse = new Warehouse();
    @Test
    void getCount() {
        warehouse.buying(3, "2022-11-28");
        assertEquals(3, warehouse.getCount(new Asiatic(Color.RED, 120, "2022-11-28")));
    }

    @Test
    void removeFlower() {
        warehouse.buying(3, "2022-11-28");
        Flower flower = new Asiatic(Color.RED, 120, "2022-11-28");
        warehouse.removeFlower(flower);
        assertEquals(2, warehouse.getCount(flower));
    }






}