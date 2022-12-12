package flowerShop;

import java.util.ArrayList;

import flowerShop.accessories.packing.Box;
import flowerShop.accessories.packing.Paper;
import flowerShop.accessories.packing.Tape;
import flowerShop.accessories.binding.Ribbon;
import flowerShop.accessories.decoration.BowKnot;
import flower.Flower;
import flower.NameFlower;



public class MakeBouquet {
    public Bouquet makeBouquet (Warehouse warehouse, ArrayList<Flower> flowers){
        Bouquet bouquet = new Bouquet();
        for(Flower flower : flowers) {
            if(warehouse.isInStock(flower)) {
                bouquet.addFlower(flower);
                warehouse.removeFlower(flower);
            }
        }

        return bouquet;
    }

    public Bouquet makeBouquet(Warehouse warehouse, Bouquets name){
        switch(name) {
            case LOVE:
                return makeLoveBouquet(warehouse);
            case WEDDING:
                return maleWeddingBouquet(warehouse);
            case HOLIDAY:
                return makeHolidayBouquet(warehouse);
            default:
                return null;
        }
    }


    private Bouquet makeLoveBouquet(Warehouse warehouse) {
        ArrayList<Flower> flowers = new ArrayList<Flower>();
        flowers.add(warehouse.getFlower(NameFlower.LILY_ASIATIC,Color.RED));
        flowers.add(warehouse.getFlower(NameFlower.LILY_ASIATIC,Color.WHITE));
        flowers.add(warehouse.getFlower(NameFlower.LILY_MARTAGON,Color.PINK));
        flowers.add(warehouse.getFlower(NameFlower.LILY_MARTAGON,Color.PINK));
        flowers.add(warehouse.getFlower(NameFlower.LILY_MARTAGON,Color.VIOLET));
        flowers.add(warehouse.getFlower(NameFlower.ROSE_AMSTERDAM,Color.CORAL));
        flowers.add(warehouse.getFlower(NameFlower.ROSE_AMSTERDAM,Color.CORAL));
        flowers.add(warehouse.getFlower(NameFlower.ROSE_AMSTERDAM,Color.CORAL));

        Bouquet result  = makeBouquet(warehouse, flowers);
        result.addAccessories(new Paper(Color.PINK));
        result.addAccessories(new Ribbon(Color.PURPLE));
        return result;

    }

    private Bouquet maleWeddingBouquet(Warehouse warehouse) {
        ArrayList<Flower> flowers = new ArrayList<Flower>();
        flowers.add(warehouse.getFlower(NameFlower.PEONY_JAPANESE,Color.SCARLET));
        flowers.add(warehouse.getFlower(NameFlower.PEONY_JAPANESE,Color.SCARLET));
        flowers.add(warehouse.getFlower(NameFlower.CHRYSANTHEMUM_BACARDI,Color.VIOLET));
        flowers.add(warehouse.getFlower(NameFlower.CHRYSANTHEMUM_BACARDI,Color.WHITE));
        flowers.add(warehouse.getFlower(NameFlower.CHRYSANTHEMUM_REAGAN,Color.ORANGE));
        flowers.add(warehouse.getFlower(NameFlower.VIOLET_PANCIES,Color.RED));
        flowers.add(warehouse.getFlower(NameFlower.VIOLET_PANCIES,Color.YELLOW));
        flowers.add(warehouse.getFlower(NameFlower.VIOLET_PANCIES,Color.PINK));

        Bouquet result  = makeBouquet(warehouse, flowers);
        result.addAccessories(new Tape(Color.WHITE));
        result.addAccessories(new Ribbon(Color.PURPLE));
        result.addAccessories(new BowKnot(Color.BLUE));
        return result;

    }

    private Bouquet makeHolidayBouquet(Warehouse warehouse) {
        ArrayList<Flower> flowers = new ArrayList<Flower>();
        flowers.add(warehouse.getFlower(NameFlower.ROSE_ENGLISH,Color.RED));
        flowers.add(warehouse.getFlower(NameFlower.ROSE_ENGLISH,Color.RED));
        flowers.add(warehouse.getFlower(NameFlower.ROSE_ENGLISH,Color.PINK));
        flowers.add(warehouse.getFlower(NameFlower.ROSE_ENGLISH,Color.YELLOW));
        flowers.add(warehouse.getFlower(NameFlower.ROSE_ENGLISH,Color.PINK));
        flowers.add(warehouse.getFlower(NameFlower.PEONY_EUVROPEAN,Color.PURPLE));
        flowers.add(warehouse.getFlower(NameFlower.PEONY_EUVROPEAN,Color.PURPLE));

        Bouquet result  = makeBouquet(warehouse, flowers);
        result.addAccessories(new Box(Color.WHITE));
        result.addAccessories(new Ribbon(Color.PURPLE));
        result.addAccessories(new BowKnot(Color.BLUE));
        return result;

    }
}
