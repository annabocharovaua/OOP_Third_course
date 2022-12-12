package flowerShop;

import flower.Flower;
import flowerShop.accessories.Accessories;
import flowerShop.accessories.decoration.Decoration;
import flowerShop.accessories.binding.Binding;
import flowerShop.accessories.packing.Package;

import java.util.ArrayList;

public class Bouquet {
    private int price;
    private Package packing;
    private Binding binding;
    private Decoration decoration;
    private ArrayList<Flower> flowers = new ArrayList<>();

    public void Bouquet() {
        this.flowers = new ArrayList<>();
        this.packing = null;
        this.binding = null;
        this.decoration = null;
        this.price = 0;
    }

    public void Bouquet(ArrayList<Flower> flowers, Decoration decoration, Binding binding, Package packing) {
        this.flowers = flowers;
        this.packing = packing;
        this.binding = binding;
        this.decoration = decoration;

        this.price = 0;
        for(Flower flower : flowers) {
            this.price += flower.getPrice();
        }
    }

    public void Bouquet(ArrayList<Flower> flowers) {
        this.flowers = flowers;
        this.price = 0;
        for(Flower flower : flowers) {
            this.price += flower.getPrice();
        }

    }

    public void Bouquet(ArrayList<Flower> flowers, Binding binding, Package packing) {
        this.flowers = flowers;
        this.packing = packing;
        this.binding = binding;
        this.decoration = null;

        this.price = 0;
        for(Flower flower : flowers) {
            this.price += flower.getPrice();
        }
    }

    public int getPrice() {
        return price;
    }

    public ArrayList<Flower> getFlowers() {
        return flowers;
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
        price+=flower.getPrice();
    }

    public void addAccessories (Accessories accessory) {
        if(accessory instanceof Decoration){
            decoration = (Decoration) accessory;
        } else if (accessory instanceof Package){
            packing = (Package) accessory;
        } else if (accessory instanceof Binding) {
            binding = (Binding) accessory;
        }

        price +=accessory.getPrice();
    }

    public void sortByFreshness() {
        flowers.sort((f1, f2) -> f1.getFreshness().compareTo(f1.getFreshness()));
    }

    public ArrayList<Flower> getFlowersLengthStem (int minStem, int maxStem) {
        ArrayList<Flower> result =  new ArrayList<>();
        for(Flower flower : flowers) {
            if(flower.getLengthStem() >= minStem && flower.getLengthStem()<=maxStem){
                result.add(flower);
            }
        }

        if(result.size()==0) {
            return null;
        }

        return result;
    }

    public void printBouquet() {
        System.out.println("Bouquet price: " + price + "$\n");
        System.out.println("Flowers : ");
        for(Flower flower: flowers) {
            System.out.println(flower.getName() + " (" + flower.getColor() + ") " + flower.getPrice() + "$ " +  flower.getLengthStem() + " sm " + flower.getFreshness() + " day");
        }
        if (packing != null) {
            System.out.println("Packed in: " + packing.getName() + " (" + packing.getColor() + ")  " + packing.getPrice() + "$");
        }
        if (binding != null) {
            System.out.println("With: " + binding.getName() + " (" + binding.getColor() + ") " + binding.getPrice() + "$");
        }
        if (decoration != null) {
            System.out.println("With: " + decoration.getName() + "  (" + decoration.getColor() + ") " + decoration.getPrice() + "$");
        }
    }







}
