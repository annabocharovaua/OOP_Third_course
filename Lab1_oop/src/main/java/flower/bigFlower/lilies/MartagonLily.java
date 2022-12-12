package flower.bigFlower.lilies;

import flowerShop.Color;
import flower.NameFlower;

public class MartagonLily extends Lily {

    public MartagonLily(Color color, int lenghtStem, String deliveryDate) {
        super(color, lenghtStem, deliveryDate);
    }
    protected void setName(){
        this.name = NameFlower.LILY_MARTAGON;
    }

    protected void setColor(Color color){
        if (color == Color.PINK || color == Color.YELLOW || color == Color.VIOLET) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }
    public void setPrice(){
        this.price = 100;
    }
}
