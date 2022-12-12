package flower;

import flowerShop.Color;
import java.time.LocalDate;
import java.time.Period;

public abstract class Flower {
    protected NameFlower name;
    protected Color color;
    public int price;
    protected int lengthStem;
    protected LocalDate deliveryDate;

    public Flower (Color color, int lengthStem, String deliveryDate) {
        setName();
        setColor(color);
        setLengthStem(lengthStem);
        setDate(deliveryDate);
        setPrice();
    }

    public NameFlower getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public int getLengthStem() {
        return lengthStem;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public Integer getFreshness() {
        return Period.between(deliveryDate, LocalDate.now()).getDays();
    }

    protected void setColor(Color color){
        if(true){
            this.color = color;
        } else {
            throw new IllegalArgumentException("Is not valid argument");
        }
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPrice() {
        this.price =0;
    }

    protected void setName() {
        this.name = null;
    }

    protected void setLengthStem(int lengthStem){
        if(lengthStem >=5 && lengthStem<=200){
            this.lengthStem = lengthStem;
        } else {
            throw new IllegalArgumentException("Is not valid argument");
        }
    }

    public boolean checkFreshness() {
        return getFreshness() < 15;
    }

    protected void setDate(String deliveryDate){
        if(LocalDate.now().isAfter(LocalDate.parse(deliveryDate)) || LocalDate.now().isEqual(LocalDate.parse(deliveryDate))) {
            this.deliveryDate = LocalDate.parse(deliveryDate);
            if(!checkFreshness()){
                throw new IllegalArgumentException("Stale flowers");
            }

        } else {
            throw new IllegalArgumentException("Is not valid argument");
        }
    }

}
