import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class RecipesBase implements Serializable {
    // this class contains list of recipes that corresponds to some category of dishes
    private final CategoriesOfDishes category;
    private final ArrayList<Recipe> recipes = new ArrayList<>();

    public RecipesBase(CategoriesOfDishes category) {
        this.category = category;
    }

    public void addRecipe(Recipe recipe) { recipes.add(recipe); }

    public ArrayList<Recipe> getRecipes() { return recipes; }

    /*
    method findByProducts(ArrayList<Product> products) will return new RecipesBase object with matches in products
     */
    public RecipesBase findByProducts(ArrayList<Enum> products) {
        RecipesBase base = new RecipesBase(category);
        for (Recipe curRecipe:recipes) {
            if (curRecipe.getPercentageOfEntries(products) == 100) base.addRecipe(curRecipe);
        }
        return base;
    }

    /*
    method findByProducts(ArrayList<Product> products, byte entryPercents) will return new RecipesBase object
     with matches in products with some tolerance
     */
    public RecipesBase findByProducts(ArrayList<Enum> products, byte entryPercents) {
        RecipesBase base = new RecipesBase(category);
        for (Recipe curRecipe:recipes) {
            if (curRecipe.getPercentageOfEntries(products) > entryPercents) base.addRecipe(curRecipe);
        }
        return base;
    }

    /*
    method findByTime(int time) will return RecipesBase with time <= than given
    */
    public RecipesBase findByTime(int time) {
        RecipesBase base = new RecipesBase(category);
        for (Recipe curRecipe:recipes) {
            if (curRecipe.getTime() <= time) base.addRecipe(curRecipe);
        }
        return base;
    }

    /*
    method findByComplexity(byte complexity) will return RecipesBase with complexity <= than given
    */
    public RecipesBase findByComplexity(byte complexity) {
        RecipesBase base = new RecipesBase(category);
        for (Recipe curRecipe:recipes) {
            if (curRecipe.getComplexity() <= complexity) base.addRecipe(curRecipe);
        }
        return base;
    }


    /*
    method sortByTime() will sort recipes field by time needed to cook dishes
     */
    public void sortByTime() {
        Collections.sort(recipes, Recipe.CompareByTime);
    }

    /*
    method sortByComplexity() will sort recipes field by complexity of cooking
     */
    public void sortByComplexity() {
        Collections.sort(recipes, Recipe.CompareByComplexity);
    }

    /*
    method sortByNumOfEntries() will sort recipes field by number of entries
    (first will be recipe with largest number of entries of products, given by user)
     */
    public void sortByNumOfProducts() {
        Collections.sort(recipes, Recipe.CompareByNumOfProducts);
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("");
        String header = String.format("Available recipes from %s category:\n", category);
        text.append(header);
        int i = 1;
        for (Recipe curRecipe:recipes) {
            text.append(String.format("%d. %s\n", i++, curRecipe.toString()));
        }

        return text.toString();
    }
}
