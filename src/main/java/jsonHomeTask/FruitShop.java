package jsonHomeTask;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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
     * @param pathToJsonFile new path to form new file of delivery;
     */
    public void addFruits(String pathToJsonFile, List<Fruits> fruits) throws IOException {
        this.fruits.addAll(fruits);
        File file = new File(pathToJsonFile);
        ObjectMapper om = new ObjectMapper();
        FileWriter fileWriter = new FileWriter(file);
        for (Fruits fruit : fruits) {
            String content = om.writeValueAsString(fruit);
            fileWriter.write(content);
        }
        fileWriter.close();
    }

    /**
     * method saves information about existing list of fruits to the new Json file.
     * @param pathToJsonFile new path to new file, to make savings;
     */
    public void saveFruits(String pathToJsonFile) throws IOException {
        File file = new File(pathToJsonFile);
        FileWriter fw = new FileWriter(file);
        ObjectMapper om = new ObjectMapper();
        String content = om.writeValueAsString(fruits);
        System.out.println("Saved to the file. There are " + fruits.size()+ " fruits delivered in the shop.");
        fw.write(content);
        fw.close();
    }

    /**
     * delete current information from the List and save a new one from the saved version.
     * @param pathToJsonFile path to file, where some information should be deleted;
     */
    public void loadFruits(String pathToJsonFile) throws IOException {
        System.out.println("List size before loading is " + fruits.size());
        File file = new File(pathToJsonFile);
        ObjectMapper mapper = new ObjectMapper();
        fruits = null;
        fruits = mapper.readValue(file, List.class);// unchecked assignments;
        System.out.println("List size after loading is " + fruits.size());
    }
}
