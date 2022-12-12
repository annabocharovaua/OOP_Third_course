package flower.bigFlower.lilies;

import flowerShop.Color;
import flower.NameFlower;

public class Asiatic extends Lily {

    public Asiatic(Color color, int lengthStem, String deliveryDate) {
        super(color, lengthStem, deliveryDate);
    }
    protected void setName(){
        this.name = NameFlower.LILY_ASIATIC;
    }

    protected void setColor(Color color){
        if (color == Color.WHITE || color == Color.RED) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Is not valid argument");
        }
    }
    public void setPrice(){
        this.price = 50;
    }
}
