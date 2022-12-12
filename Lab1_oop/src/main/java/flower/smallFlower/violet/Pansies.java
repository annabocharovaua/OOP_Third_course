package flower.smallFlower.violet;

import flower.smallFlower.violet.Violet;
import flowerShop.Color;
import flower.NameFlower;

public class Pansies extends Violet {

    public Pansies(Color color, int lengthStem, String deliveryDate) {
        super(color, lengthStem, deliveryDate);
    }
    protected void setName(){
        this.name = NameFlower.VIOLET_PANCIES;
    }

    protected void setColor(Color color){
        if (color == Color.RED || color== Color.YELLOW || color==Color.PINK || color==Color.BLUE || color==Color.BLACK || color==Color.WHITE) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }
    public void setPrice(){
        this.price = 10;
    }
}