package flower.bigFlower.peony;

import flowerShop.Color;
import flower.NameFlower;
import flower.bigFlower.BigFlower;

public abstract class Peony extends BigFlower{
    public Peony(Color color, int lenghtStem, String deliveryDate) {
        super(color, lenghtStem, deliveryDate);
    }

    public boolean checkFreshness() {
        return getFreshness() < 10;
    }
}
