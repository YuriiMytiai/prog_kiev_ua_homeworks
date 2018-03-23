import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class Recipe implements Serializable {
    // this class describes one recipe
    private final String name; // name of dish
    private final CategoriesOfDishes category; // category of dish
    private final ArrayList<Product> products = new ArrayList<>(); // list of required products
    private final int time; // time required for cooking
    private final byte complexity; // complexity of recipe
    private final String algorithm;

    public Recipe(CategoriesOfDishes category, String name, int time, byte complexity, String algorithm) {
        checkArgs(time, complexity);
        this.category = category;
        this.name = name;
        this.time = time;
        this.complexity = complexity;
        this.algorithm = algorithm;
    }

    private void checkArgs(int time, byte complexity) {
        if (time < 1) throw new IllegalArgumentException("Invalid time value");
        if ((complexity < 0) || (complexity > 10)) throw new IllegalArgumentException("Complexity should have value between 0 and 10");
    }

    public void addProduct(Product product) { products.add(product); }

    public String getName() { return name; }

    public CategoriesOfDishes getCategory() { return category; }

    public ArrayList<Product> getProducts() { return products; }

    public ArrayList<Product> getProducts(int persons) {
        if (persons < 1) throw new IllegalArgumentException("Number of persons should be grater then 0");

        ArrayList<Product> products = new ArrayList<>();
        for (Product curProduct:this.products) {
            curProduct.getQuantity(persons);
            products.add(curProduct);
        }
        return products;
    }

    public int getTime() { return time; }

    public byte getComplexity() { return complexity; }

    public String getAlgorithm() { return algorithm; }

    /*
    method getPercentageOfEntries(ArrayList<Enum> products) search through all products in recipe and
    all products in user's product list and finds equal products
     */
    public byte getPercentageOfEntries(ArrayList<Enum> products) {
        int numOfEquals = 0;
        for (Product productInRecipe:this.products) {
            for(Enum curProduct:products) {
                if (productInRecipe.getName().equals(curProduct)) numOfEquals++;
            }
        }

        return (byte)(numOfEquals * 100 / this.products.size());
    }

    public static final Comparator<Recipe> CompareByTime = new Comparator<Recipe>() {
        @Override
        public int compare(Recipe r1, Recipe r2) {
            return r1.getTime() - r2.getTime();
        }
    };

    public static final Comparator<Recipe> CompareByComplexity = new Comparator<Recipe>() {
        @Override
        public int compare(Recipe r1, Recipe r2) {
            return r1.getComplexity() - r2.getComplexity();
        }
    };


    // here if number of products is smaller, than object will be higher in list.
    public static final Comparator<Recipe> CompareByNumOfProducts = new Comparator<Recipe>() {
        @Override
        public int compare(Recipe r1, Recipe r2) {
            return r2.getProducts().size() - r1.getProducts().size();
        }
    };

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

    @Override
    public String toString() {
        return String.format("%s, required time: %d min, complexity: %d of 10", name, time, complexity);
    }
}
