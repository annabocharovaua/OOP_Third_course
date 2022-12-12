package flower.smallFlower.violet;

import flowerShop.Color;
import flower.NameFlower;
import flower.smallFlower.SmallFlower;

public abstract class Violet extends SmallFlower{
    public Violet(Color color, int lengthStem, String deliveryDate) {
        super(color, lengthStem, deliveryDate);
    }

    public boolean checkFreshness() {
        return getFreshness() < 7;
    }
}
