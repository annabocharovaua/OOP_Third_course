package flowerShop.accessories.binding;

import flowerShop.Color;
import flowerShop.accessories.Accessories;
import flowerShop.accessories.NameAccessory;


public class Ribbon extends Binding {
    public Ribbon(Color color) {
        super(color);
    }

    protected void setName(){
        this.name = NameAccessory.RIBBON;
    }

    public void setPrice(){
        this.price = 10;
    }
}
