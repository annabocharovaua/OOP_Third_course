package flower.bigFlower.peony;

import flower.bigFlower.peony.Peony;
import flowerShop.Color;
import flower.NameFlower;

public class European extends Peony {

    public European(Color color, int lenghtStem, String deliveryDate) {
        super(color, lenghtStem, deliveryDate);
    }
    protected void setName(){
        this.name = NameFlower.PEONY_EUVROPEAN;
    }

    protected void setColor(Color color){
        if (color == Color.PURPLE || color == Color.PINK) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }
    public void setPrice(){
        this.price = 70;
    }
}