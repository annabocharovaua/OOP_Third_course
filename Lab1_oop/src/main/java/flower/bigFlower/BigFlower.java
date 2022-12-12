package flower.bigFlower;

import flowerShop.Color;
import flower.Flower;


public abstract class BigFlower extends Flower {
    public BigFlower(Color color, int lengthStem, String deliveryDate){
        super(color, lengthStem, deliveryDate);
    }

    protected void setLengthStem (int lengthStem) {
        if(lengthStem >=70 && lengthStem<=200) {
            this.lengthStem = lengthStem;
        } else {
            throw new IllegalArgumentException("Length stem is not valid argument");
        }
    }
}
