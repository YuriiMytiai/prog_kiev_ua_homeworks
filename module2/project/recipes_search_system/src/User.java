import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class User {
    private final String name;
    private CategoriesOfDishes category;
    private final ArrayList<String> validProducts;
    private final HashMap<CategoriesOfDishes, RecipesBase> allRecipesBase;
    private RecipesBase recipesBase;
    private final ArrayList<String> products = new ArrayList<>();

    public User(String name, CategoriesOfDishes category, HashMap<CategoriesOfDishes, RecipesBase> recipes, ArrayList<String> validProducts) {
        this.name = name;
        this.category = category;
        allRecipesBase = recipes;
        this.validProducts = validProducts;
        changeRecipeBase(category);
    }


    public void changeCategory(CategoriesOfDishes category) {
        this.category = category;
        changeRecipeBase(category);
    }

    public RecipesBase getRecipesBase() {
        return recipesBase;
    }

    public ArrayList<String> getProducts() {
        return products;
    }

    public User addProduct(String product) {
        validateProduct(product);
        products.add(product.toUpperCase());
        return this;
    }

    private void validateProduct(String product) {
        if (Collections.binarySearch(validProducts, product.toUpperCase()) < 0)
            throw new IllegalArgumentException("Product " + product + " is not valid one");
    }

    public void clearProductsList() {
        products.clear();
    }

    private void changeRecipeBase(CategoriesOfDishes category) {
        try {
            recipesBase = allRecipesBase.get(category);
        } catch (IllegalArgumentException e) {
            e.initCause(new Throwable("Base category " + category + " does not exist"));
        }
    }
}

