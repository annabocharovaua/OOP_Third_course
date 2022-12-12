package flowerShop.accessories.packing;

import flowerShop.Color;
import flowerShop.accessories.NameAccessory;

public class Tape extends Package{
    public Tape(Color color) {
        super(color);
    }

    protected void setName(){
        this.name = NameAccessory.TAPE;
    }

    public void setPrice(){
        this.price = 5;
    }
}
