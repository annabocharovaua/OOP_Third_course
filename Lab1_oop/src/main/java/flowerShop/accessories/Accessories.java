package flowerShop.accessories;

import  flowerShop.Color;
import flowerShop.accessories.NameAccessory;

public abstract class Accessories {

    protected NameAccessory name;
    protected int price;
    protected Color color;

    public Accessories(Color color) {
        setName();
        setColor(color);
        setPrice();
    }

    protected void setName() {
        this.name = null;
    }

    public NameAccessory getName() {
        return name;
    }
    public void setPrice() {
        this.price = 0;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}
