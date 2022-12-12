package flower.smallFlower.violet;

import flower.smallFlower.violet.Violet;
import flowerShop.Color;
import flower.NameFlower;

public class Star extends Violet {

    public Star(Color color, int lengthStem, String deliveryDate) {
        super(color, lengthStem, deliveryDate);
    }
    protected void setName(){
        this.name = NameFlower.VIOLET_STAR;
    }

    protected void setColor(Color color){
        if (color==Color.PINK || color==Color.VIOLET) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }
    public void setPrice(){
        this.price = 20;
    }
}