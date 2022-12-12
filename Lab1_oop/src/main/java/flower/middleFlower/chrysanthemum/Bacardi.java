package flower.middleFlower.chrysanthemum;

import flower.middleFlower.chrysanthemum.Chrysanthemum;
import flowerShop.Color;
import flower.NameFlower;

public class Bacardi extends Chrysanthemum {

    public Bacardi(Color color, int lenghtStem, String deliveryDate) {
        super(color, lenghtStem, deliveryDate);
    }
    protected void setName(){
        this.name = NameFlower.CHRYSANTHEMUM_BACARDI;
    }

    protected void setColor(Color color){
        if (color == Color.WHITE || color== Color.VIOLET || color==Color.PINK) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }
    public void setPrice(){
        this.price = 75;
    }
}