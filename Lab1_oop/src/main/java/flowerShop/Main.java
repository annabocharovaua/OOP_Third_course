package flowerShop;

import flower.Flower;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        MakeBouquet makeBouquet = new MakeBouquet();
        warehouse.buying(4, "2022-12-12");

        Run(warehouse, makeBouquet);
    }

    public static void  Run(Warehouse warehouse, MakeBouquet work) {
        while(true) {
            System.out.println("Do you want to buy a bouquet? We have such a range : ");
            System.out.println("Choose 1 - LOVE");
            System.out.println("Choose 2 - WEDDING");
            System.out.println("Choose 3 - HOLIDAY");
            System.out.println("Choose 0 - EXIT");

            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();;
            Bouquet newBouquet = null;

            switch(choose) {
                case 1:
                    System.out.print("LOVE bouquet");
                    newBouquet = work.makeBouquet(warehouse, Bouquets.LOVE);
                    break;
                case 2:
                    System.out.print("WEDDING bouquet");
                    newBouquet = work.makeBouquet(warehouse, Bouquets.WEDDING);
                    break;
                case 3:
                    System.out.print("HOLIDAY bouquet");
                    newBouquet = work.makeBouquet(warehouse, Bouquets.HOLIDAY);
                    break;
                case 0:
                    System.out.println("Exit");
                    return;
                default:
                    break;

            }

            System.out.println("Sort by freshness: ");
            newBouquet.sortByFreshness();
            newBouquet.printBouquet();

            System.out.println("Find flowers by length stem");
            System.out.println("Please, enter min length");
            int min = scanner.nextInt();
            System.out.println("Please, enter max length");
            int max = scanner.nextInt();
            ArrayList<Flower> flowers = newBouquet.getFlowersLengthStem(min, max);
            if(flowers.size()==0){
                System.out.println("Not found");
            } else {
                for(Flower flower : flowers){
                    System.out.println(flower.getName()  + " height: " + flower.getLengthStem());
                }
            }

            System.out.println("Do you need one more bouquet (y/n)");
            String str=scanner.next();
            if(str.equals("n")){
                return;
            }
        }
    }
}
