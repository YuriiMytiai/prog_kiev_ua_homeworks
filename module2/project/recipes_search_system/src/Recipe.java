import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Recipe implements Serializable {
    /**
     * this class describes one recipe
      */
    private final String name; // name of dish
    private final DishCategory category; // category of dish
    private final List<Product> products = new ArrayList<>(); // list of required products
    private final int time; // time required for cooking
    private final int complexity; // complexity of recipe
    private final String algorithm;

    public Recipe(DishCategory category, String name, int time, int complexity, String algorithm) {
        checkArgs(time, complexity);
        this.category = category;
        this.name = name;
        this.time = time;
        this.complexity = complexity;
        this.algorithm = algorithm;
    }

    public Recipe() {
        this(DishCategory.OTHER, "Not initialized", 1, 1, "");
    }

    private void checkArgs(int time, int complexity) {
        if (time < 1) throw new IllegalArgumentException("Invalid time value");
        if ((complexity < 0) || (complexity > 10)) throw new IllegalArgumentException("Complexity should have value between 0 and 10");
    }

    public void addProduct(Product product) { products.add(product); }

    public String getName() { return name; }

    public DishCategory getCategory() { return category; }

    public List<Product> getProducts() { return products; }

    public List<Product> getProducts(int persons) {
        if (persons < 1) throw new IllegalArgumentException("Number of persons should be grater then 0");

        ArrayList<Product> products = new ArrayList<>();
        for (Product curProduct:this.products) {
            curProduct.getQuantity(persons);
            products.add(curProduct);
        }
        return products;
    }

    public int getTime() { return time; }

    public int getComplexity() { return complexity; }

    public String getAlgorithm() { return algorithm; }

    /*
    method getPercentageOfEntries(ArrayList<Enum> products) search through all products in recipe and
    all products in user's product list and finds equal products
     */
    public int getPercentageOfEntries(List<String> products) {
        int numOfEquals = 0;
        for (Product productInRecipe:this.products) {
            for(String curProduct:products) {
                if (productInRecipe.getName().equals(curProduct)) numOfEquals++;
            }
        }

        return numOfEquals * 100 / this.products.size();
    }

    public String showRecipe() {
        StringBuilder text = new StringBuilder();
        String header = String.format("Recipe of %s \nYou need:\n", name);
        text.append(header);
        int i = 1;
        for (Product curProduct:products) {
            text.append(String.format("%d. %s", i++, curProduct.toString()));
        }
        text.append(String.format("Instructions how to cook:\n%s\n\n", algorithm));
        text.append(String.format("Required time: %d min\nComplexity of recipe: %d of 10\n\n", time, complexity));

        return text.toString();
    }

    public void saveToTxtFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(showRecipe());
        } catch (IOException e) {
            System.out.println("Recipe can not be saved to text file " + fileName);
        }
    }

    public void saveToBinaryFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.out.println("Recipe can not be saved to binary file " + fileName);
        }
    }

    @Override
    public String toString() {
        return String.format("%s, required time: %d min, complexity: %d of 10", name, time, complexity);
    }
}
