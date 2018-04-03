import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private final String name;
    private DishCategory category;
    private final List<String> validProducts;
    private final AllRecipesCollection allRecipesBase;
    private RecipesBase recipesBase;
    private final List<String> products = new ArrayList<>();

    public User(String name, DishCategory category, AllRecipesCollection recipes, List<String> validProducts) {
        this.name = name;
        this.category = category;
        allRecipesBase = recipes;
        this.validProducts = validProducts;
        changeRecipeBase(category);
    }


    public void changeCategory(DishCategory category) {
        this.category = category;
        changeRecipeBase(category);
    }

    public RecipesBase getRecipesBase() {
        return recipesBase;
    }

    public List<String> getProducts() {
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

    private void changeRecipeBase(DishCategory category) {
        recipesBase = allRecipesBase.changeDishesCategory(category);
    }
}

