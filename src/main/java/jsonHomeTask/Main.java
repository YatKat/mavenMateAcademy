package jsonHomeTask;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Fruits> fruits = new ArrayList<>();
        fruits.add(new Fruits(KindOfFruit.APPLE, 200,
                LocalDate.of(2018, 12, 13), new BigDecimal(86.00)));
        fruits.add(new Fruits(KindOfFruit.BANANA, 4, LocalDate.of(2018, 12, 14),
                new BigDecimal(36.00)));
        fruits.add(new Fruits(KindOfFruit.KIWI, 630, LocalDate.of(2018, 11, 21),
                new BigDecimal(58.00)));
        String path = "fruitsInfo.json";
        String pathToDBFile = "fruitsDataBase.json";
        FruitShop shop = new FruitShop(fruits, path);// create shop with some fruits and path to file

        List<Fruits> newDelivery1 = new ArrayList<>();
        newDelivery1.add(new Fruits(KindOfFruit.APRICOT, 100,
                LocalDate.of(2018, 12, 16), new BigDecimal(120.00)));
        newDelivery1.add(new Fruits(KindOfFruit.TANGERINE, 300,
                LocalDate.of(2018, 12, 16), new BigDecimal(78.00)));
        newDelivery1.add(new Fruits(KindOfFruit.ORANGE, 3,
                LocalDate.of(2018, 12, 16), new BigDecimal(52.00)));

        List<Fruits> newDelivery2 = new ArrayList<>();
        newDelivery2.add(new Fruits(KindOfFruit.CHERRY, 15,
                LocalDate.of(2018, 12, 18), new BigDecimal(150.00)));
        newDelivery2.add(new Fruits(KindOfFruit.PEAR, 300,
                LocalDate.of(2018, 12, 18), new BigDecimal(108.00)));
        newDelivery2.add(new Fruits(KindOfFruit.PLUM, 300,
                LocalDate.of(2018, 12, 18), new BigDecimal(90.00)));
        try {
            shop.addFruits(path, newDelivery1);
            System.out.println("Add fruits and write delivery to file fruitsInfo.json.");
            shop.saveFruits(pathToDBFile);
            System.out.println("Saved all fruits in the List to fruitsDataBase.json.");
            shop.addFruits("delivery2.json", newDelivery2);
            System.out.println("New delivery! Hurry up!");
            shop.saveFruits(pathToDBFile);
            shop.loadFruits(pathToDBFile);
            System.out.println("Updated the shop list with info from DataBase");
        } catch (IOException e) {
            e.printStackTrace();
        }
        shop.getSpoiledFruits(LocalDate.of(2019, 1, 4));
        shop.getAvailableFruits(LocalDate.of(2019, 1, 4));
        shop.getSpoiledFruits(LocalDate.of(2019, 1, 4), KindOfFruit.CHERRY);
        shop.getAvailableFruits(LocalDate.of(2018, 12, 15), KindOfFruit.BANANA);
        shop.getAddedFruits(LocalDate.of(2018, 12, 18));
        shop.getAddedFruits(LocalDate.of(2018, 12, 18), KindOfFruit.PLUM);
    }
}
