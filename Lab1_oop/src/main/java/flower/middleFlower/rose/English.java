package flower.middleFlower.rose;

import flower.middleFlower.rose.Rose;
import flowerShop.Color;
import flower.NameFlower;

public class English extends Rose {

    public English(Color color, int lengthStem, String deliveryDate) {
        super(color, lengthStem, deliveryDate);
    }
    protected void setName(){
        this.name = NameFlower.ROSE_ENGLISH;
    }

    protected void setColor(Color color){
        if (color == Color.RED || color== Color.YELLOW || color==Color.PINK) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }
    public void setPrice(){
        this.price = 100;
    }
}