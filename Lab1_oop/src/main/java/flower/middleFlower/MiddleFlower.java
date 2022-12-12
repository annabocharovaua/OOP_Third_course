package flower.middleFlower;

import flowerShop.Color;
import flower.Flower;


public abstract class MiddleFlower extends Flower {
    public MiddleFlower(Color color, int lengthStem, String deliveryDate){
        super(color, lengthStem, deliveryDate);
    }

    protected void setLengthStem (int lengthStem) {
        if(lengthStem >=20 && lengthStem<70) {
            this.lengthStem = lengthStem;
        } else {
            throw new IllegalArgumentException("Length stem is not valid argument");
        }
    }
}
