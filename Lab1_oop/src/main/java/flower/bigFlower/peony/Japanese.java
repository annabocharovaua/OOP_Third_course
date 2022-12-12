package flower.bigFlower.peony;

import flower.bigFlower.peony.Peony;
import flowerShop.Color;
import flower.NameFlower;

public class Japanese extends Peony {

    public Japanese(Color color, int lenghtStem, String deliveryDate) {
        super(color, lenghtStem, deliveryDate);
    }
    protected void setName(){
        this.name = NameFlower.PEONY_JAPANESE;
    }

    protected void setColor(Color color){
        if (color == Color.SCARLET) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }
    public void setPrice(){
        this.price = 75;
    }
}