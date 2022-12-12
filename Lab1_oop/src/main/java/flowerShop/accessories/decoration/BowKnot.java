package flowerShop.accessories.decoration;

import flowerShop.Color;
import flowerShop.accessories.NameAccessory;

public class BowKnot extends Decoration{
    public BowKnot(Color color) {
        super(color);
    }

    public void setName() {
        this.name = NameAccessory.BOW_KNOT;
    }

    public void setPrice() {
        this.price = 20;
    }
}
