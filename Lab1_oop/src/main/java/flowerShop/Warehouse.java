package flowerShop;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


import flower.smallFlower.violet.Pansies;
import flower.smallFlower.violet.Star;
import flower.middleFlower.chrysanthemum.Bacardi;
import flower.middleFlower.chrysanthemum.Reagan;
import flower.middleFlower.rose.Amsterdam;
import flower.middleFlower.rose.English;
import flower.bigFlower.lilies.MartagonLily;
import flower.bigFlower.lilies.Asiatic;
import flower.bigFlower.peony.European;
import flower.bigFlower.peony.Japanese;
import flower.Flower;
import flower.NameFlower;

public class Warehouse {
    private Map<Flower, Integer> flowers;

    public Warehouse() {
        flowers = new HashMap<Flower, Integer>();
    }

    public void addFlower(Flower flower) {
       flowers.put(inWarehouse(flower), getCount(flower) +1);
    }

    public Flower inWarehouse(Flower flower) {
        for (Map.Entry<Flower, Integer> f: flowers.entrySet()) {
            if(f.getKey().getName()==flower.getName() && f.getKey().getColor()==flower.getColor()){
                return f.getKey();
            }
        }
        return flower;
    }

    public int getCount(Flower flower) {
        return getCount(flower.getName(), flower.getColor());
    }

    public int getCount(NameFlower name, Color color) {
        for(Map.Entry<Flower, Integer> currentFlower : flowers.entrySet()) {
            if(currentFlower.getKey().getName() == name && currentFlower.getKey().getColor()==color) {
                return currentFlower.getValue();
            }
        }
        return 0;
    }

    public Flower getFlower(NameFlower name, Color color) {
        for(Map.Entry<Flower, Integer> currentFlower : flowers.entrySet()) {
            if(currentFlower.getKey().getName() == name && currentFlower.getKey().getColor()==color) {
               removeFlower(currentFlower.getKey());
               return currentFlower.getKey();
            }
        }
        return null;
    }

    public void removeFlower(Flower flower) {
        removeFlower(flower.getName(), flower.getColor());
    }

    public void removeFlower(NameFlower name, Color color) {
        for(Map.Entry<Flower, Integer> currentFlower : flowers.entrySet()) {
            if(currentFlower.getKey().getName() == name && currentFlower.getKey().getColor()==color) {
                if(currentFlower.getValue() > 0) {
                    flowers.put(currentFlower.getKey(), currentFlower.getValue()-1);
                }
                break;
            }
        }
    }

    public void printCount() {
        for(Map.Entry<Flower, Integer> currentFlower : flowers.entrySet()) {
            System.out.println(currentFlower.getKey().getName() + "(" + currentFlower.getKey().getColor() +
                    ")" + " : " + currentFlower.getValue());
        }
    }


    public  boolean isInStock(Flower flower) {
        return getCount(flower) > 0;
    }

      public void buying(int count, String date) {
        for(int i=0; i<count; i++) {
            buying(date);
        }
    }

    public void buying(String date) {
       addFlower(new Asiatic(Color.WHITE , 150, date));
       addFlower(new Asiatic(Color.RED , 120, date));
       addFlower(new MartagonLily(Color.PINK, 100, date));
       addFlower(new MartagonLily(Color.YELLOW, 90, date));
       addFlower(new MartagonLily(Color.VIOLET, 110, date));
       addFlower(new Amsterdam(Color.CORAL, 50, date));
       addFlower(new English(Color.RED, 60, date));
       addFlower(new English(Color.YELLOW, 65, date));
       addFlower(new English(Color.PINK, 65, date));
       addFlower(new European(Color.PURPLE, 115, date));
       addFlower(new European(Color.PINK, 130, date));
       addFlower(new Japanese(Color.SCARLET, 150, date));
       addFlower(new Bacardi(Color.PINK, 60, date));
       addFlower(new Bacardi(Color.VIOLET, 63, date));
       addFlower(new Bacardi(Color.WHITE, 67, date));
       addFlower(new Reagan(Color.ORANGE, 55, date));
       addFlower(new Pansies(Color.RED, 6, date));
       addFlower(new Pansies(Color.YELLOW, 7, date));
       addFlower(new Pansies(Color.PINK, 8, date));
       addFlower(new Pansies(Color.BLUE, 9, date));
       addFlower(new Pansies(Color.BLACK, 10, date));
       addFlower(new Pansies(Color.WHITE, 11, date));
       addFlower(new Star(Color.PINK, 14, date));
       addFlower(new Star(Color.VIOLET, 12, date));


    }

}
