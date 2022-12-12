package flower.middleFlower.rose;

import flower.middleFlower.rose.Rose;
import flowerShop.Color;
import flower.NameFlower;

public class Amsterdam extends Rose {

    public Amsterdam(Color color, int lengthStem, String deliveryDate) {

        super(color, lengthStem, deliveryDate);
    }
    protected void setName(){
        this.name = NameFlower.ROSE_AMSTERDAM;
    }

    protected void setColor(Color color){
        if (color == Color.CORAL) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }
    public void setPrice(){
        this.price = 150;
    }
}