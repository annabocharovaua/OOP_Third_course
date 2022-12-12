package flower.bigFlower.lilies;

import flowerShop.Color;
import flower.NameFlower;
import flower.bigFlower.BigFlower;

public abstract class Lily extends BigFlower{
    public Lily(Color color, int lenghtStem, String deliveryDate) {
        super(color, lenghtStem, deliveryDate);
    }

    public boolean checkFreshness() {
        return getFreshness() < 14;
    }
}
