package jsonHomeTask;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * class is responsible for saving data about goods in the shop
 */
public class FruitShop {
    private List<Fruits> fruits;
    private String path;

    public FruitShop(List<Fruits> fruits, String path) {
        this.fruits = fruits;
        this.path = path;
    }

    /**
     * method join elements from both lists of fruits and adds all elements from list to Json file.
     * One file - one delivery.
     *
     * @param pathToJsonFile new path to form new file of delivery;
     */
    public void addFruits(String pathToJsonFile, List<Fruits> fruits) throws IOException {
        this.fruits.addAll(fruits);
        File file = new File(pathToJsonFile);
        ObjectMapper om = new ObjectMapper();
        FileWriter fileWriter = new FileWriter(file);
        String content = om.writerWithDefaultPrettyPrinter().writeValueAsString(fruits);
        fileWriter.write(content);
        fileWriter.close();
    }

    /**
     * method saves information about existing list of fruits to the new Json file.
     *
     * @param pathToJsonFile new path to new file, to make savings;
     */
    public void saveFruits(String pathToJsonFile) throws IOException {
        File file = new File(pathToJsonFile);
        FileWriter fw = new FileWriter(file);
        ObjectMapper om = new ObjectMapper();
        String content = om.writerWithDefaultPrettyPrinter().writeValueAsString(fruits);
        System.out.println("Saved to the file. There are " + fruits.size() + " fruits delivered in the shop.");
        fw.write(content);
        fw.close();
    }

    /**
     * delete current information from the List and save a new one from the saved version.
     *
     * @param pathToJsonFile path to file, where some information should be deleted;
     */
    public void loadFruits(String pathToJsonFile) throws IOException {
        System.out.println("List size before loading is " + fruits.size());
        File file = new File(pathToJsonFile);
        ObjectMapper mapper = new ObjectMapper();
        fruits = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, Fruits.class));
        System.out.println("List size after loading is " + fruits.size());
    }

    /**
     * method find if there is spoiled Fruits in the List of Fruits and return List of spoiled Fruits;
     *
     * @param date
     * @return list of Fruits, in wich date of shelf life has expired;
     */
    public List<Fruits> getSpoiledFruits(LocalDate date) {
        List<Fruits> spoiledFruits = fruits.stream()
                .filter(fruit -> fruit.getComeDate().plusDays(fruit.getShelfLife()).isBefore(date))
                .collect(Collectors.toList());
        System.out.println(spoiledFruits.toString());
        return spoiledFruits;
    }

    /**
     * method find if there is good, not spoiled Fruits in the List of Fruits and return List of available Fruits;
     *
     * @param date
     * @return list of Fruits, in wich date of shelf life has not expired yet;
     */
    public List<Fruits> getAvailableFruits(LocalDate date) {
        List<Fruits> availableFruits = fruits.stream()
                .filter(friut -> friut.getComeDate().plusDays(friut.getShelfLife()).isAfter(date))
                .collect(Collectors.toList());
        System.out.println(availableFruits.toString());
        return availableFruits;
    }

    /**
     * method fill and return List of Fruits with date of shelfLife is out and defined type from enum KindOfFruit;
     *
     * @param date date of check;
     * @param type One of enum KindOfFruit
     * @return List of Fruits that shelfLife is out and given type
     */
    public List<Fruits> getSpoiledFruits(LocalDate date, KindOfFruit type) {
        List<Fruits> spoiledFruits = fruits.stream()
                .filter(f -> f.getComeDate().plusDays(f.getShelfLife()).isBefore(date))
                .filter(fruits1 -> fruits1.getKindOfFruit().equals(type))
                .collect(Collectors.toList());
        System.out.println(spoiledFruits.toString());
        return spoiledFruits;
    }

    /**
     * method as previouse one return List with good Fruits according to the given type (enum KindOf Fruit).
     *
     * @param date
     * @param type
     * @return
     */
    public List<Fruits> getAvailableFruits(LocalDate date, KindOfFruit type) {
        List<Fruits> availableFruits = fruits.stream()
                .filter(f -> f.getComeDate().plusDays(f.getShelfLife()).isAfter(date))
                .filter(f -> f.getKindOfFruit().equals(type))
                .collect(Collectors.toList());
        System.out.println(availableFruits.toString());
        return availableFruits;
    }

    /**
     * return List of fruits with given date of delivery;
     *
     * @param date given date of delivery;
     * @return List of Fruits;
     */
    public List<Fruits> getAddedFruits(LocalDate date) {
        List<Fruits> addedFruits = fruits.stream()
                .filter(f -> f.getComeDate().isEqual(date))
                .collect(Collectors.toList());
        System.out.println(addedFruits.toString());
        return addedFruits;
    }

    /**
     * method return List with fruits delivered in a given date and given type;
     *
     * @param date
     * @param type
     * @return
     */
    public List<Fruits> getAddedFruits(LocalDate date, KindOfFruit type) {
        List<Fruits> addedFruits = fruits.stream()
                .filter(f -> f.getComeDate().isEqual(date))
                .filter(f -> f.getKindOfFruit().equals(type))
                .collect(Collectors.toList());
        System.out.println(addedFruits.toString());
        return addedFruits;
    }
}
