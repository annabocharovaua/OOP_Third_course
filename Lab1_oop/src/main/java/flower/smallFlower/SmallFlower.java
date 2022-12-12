package flower.smallFlower;

import flowerShop.Color;
import flower.Flower;


public abstract class SmallFlower extends Flower {
    public SmallFlower(Color color, int lengthStem, String deliveryDate){
        super(color, lengthStem, deliveryDate);
    }

    protected void setLengthStem (int lengthStem) {
        if(lengthStem >=5 && lengthStem<20) {
            this.lengthStem = lengthStem;
        } else {
            throw new IllegalArgumentException("Length stem is not valid argument");
        }
    }
}
