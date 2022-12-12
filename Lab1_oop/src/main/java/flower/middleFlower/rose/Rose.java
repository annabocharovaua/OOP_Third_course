package flower.middleFlower.rose;

import flowerShop.Color;
import flower.NameFlower;
import flower.middleFlower.MiddleFlower;

public abstract class Rose extends MiddleFlower{
    public Rose(Color color, int lengthStem, String deliveryDate) {
        super(color, lengthStem, deliveryDate);
    }

    public boolean checkFreshness() {
        return getFreshness() < 12;
    }
}
