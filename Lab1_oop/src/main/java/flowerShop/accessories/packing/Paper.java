package flowerShop.accessories.packing;

import flowerShop.Color;
import flowerShop.accessories.NameAccessory;

public class Paper extends Package{
    public Paper(Color color) {
        super(color);
    }

    protected void setName(){
        this.name = NameAccessory.PAPER;
    }

    public void setPrice(){
        this.price = 20;
    }
}
