package flower.middleFlower.chrysanthemum;

import flowerShop.Color;
import flower.NameFlower;
import flower.middleFlower.MiddleFlower;

public abstract class Chrysanthemum extends MiddleFlower{
    public Chrysanthemum(Color color, int lengthStem, String deliveryDate) {
        super(color, lengthStem, deliveryDate);
    }

    public boolean checkFreshness() {
        return getFreshness() < 12;
    }
}
