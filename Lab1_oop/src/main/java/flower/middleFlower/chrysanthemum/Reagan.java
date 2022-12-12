package flower.middleFlower.chrysanthemum;

import flower.middleFlower.chrysanthemum.Chrysanthemum;
import flowerShop.Color;
import flower.NameFlower;

public class Reagan extends Chrysanthemum {

    public Reagan(Color color, int lenghtStem, String deliveryDate) {
        super(color, lenghtStem, deliveryDate);
    }
    protected void setName(){
        this.name = NameFlower.CHRYSANTHEMUM_REAGAN;
    }

    protected void setColor(Color color){
        if (color == Color.ORANGE) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }
    public void setPrice(){
        this.price = 80;
    }
}