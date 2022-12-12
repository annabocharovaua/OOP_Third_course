package flowerShop.accessories.packing;

import flowerShop.Color;
import flowerShop.accessories.NameAccessory;

public class Box extends Package{
    public Box(Color color) {
        super(color);
    }

    protected void setName(){
        this.name = NameAccessory.BOX;
    }

    public void setPrice(){
        this.price = 20;
    }
}
