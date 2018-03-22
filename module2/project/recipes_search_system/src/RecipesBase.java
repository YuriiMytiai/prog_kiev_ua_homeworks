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

    public void addPecipe(Recipe recipe) { recipes.add(recipe); }

    public ArrayList<Recipe> getRecipes() { return recipes; }

    /*
    method findByProducts(ArrayList<Product> products) will return new RecipesBase object with matches in products
     */
    public RecipesBase findByProducts(ArrayList<Product> products) {
        return null;
    }

    /*
    method findByProducts(ArrayList<Product> products, byte entryPercents) will return new RecipesBase object
     with matches in products with some tolerance
     */
    public RecipesBase findByProducts(ArrayList<Product> products, byte entryPercents) {
        return null;
    }

    /*
    method findByTime(int time) will return RecipesBase with time <= than given
    */
    public RecipesBase findByTime(int time) {
        return null;
    }

    /*
    method findByComplexity(byte complexity) will return RecipesBase with complexity <= than given
    */
    public RecipesBase findByComplexity(byte complexity) {
        return null;
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




}
