import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RecipesBase implements Serializable {
    /** this class contains list of recipes that corresponds to some category of dishes
     *
     */
    private final DishCategory category;
    private final List<Recipe> recipes;

    public RecipesBase(DishCategory category) {
        this.category = category;
        recipes = new ArrayList<>();
    }

    private RecipesBase(DishCategory category, List<Recipe> recipes) {
        this.category = category;
        this.recipes = recipes;
    }

    public RecipesBase addRecipe(Recipe recipe) {
        recipes.add(recipe);
        return this;
    }

    public List<Recipe> getRecipes() { return recipes; }

    /**
     * method findByProducts(ArrayList<Product> products) will return new RecipesBase object with matches in products
     */
    public RecipesBase findByProducts(List<String> products) {
        List<Recipe> filteredRecipes =
                recipes.stream().filter(RecipesPredicates.filterByProducts(products)).collect(Collectors.toList());
        return new RecipesBase(category, filteredRecipes);
    }

    /**
     * method findByProducts(ArrayList<Product> products, byte entryPercents) will return new RecipesBase object
     * with matches in products with some tolerance
     */
    public RecipesBase findByProducts(List<String> products, byte entryPercents) {
        List<Recipe> filteredRecipes =
                recipes.stream().filter(RecipesPredicates.filterByProducts(products, entryPercents)).collect(Collectors.toList());
        return new RecipesBase(category, filteredRecipes);
    }

    /**
     * method findByTime(int time) will return RecipesBase with time <= than given
    */
    public RecipesBase findByTime(int time) {
        List<Recipe> filteredRecipes =
                recipes.stream().filter(RecipesPredicates.filterByTime(time)).collect(Collectors.toList());
        return new RecipesBase(category, filteredRecipes);
    }

    /**
     * method findByComplexity(byte complexity) will return RecipesBase with complexity <= than given
    */
    public RecipesBase findByComplexity(byte complexity) {
        List<Recipe> filteredRecipes =
                recipes.stream().filter(RecipesPredicates.filterByComplexity(complexity)).collect(Collectors.toList());
        return new RecipesBase(category, filteredRecipes);
    }

    /**
     * method sortByTime() will sort recipes field by time needed to cook dishes
     */
    public void sortByTime() {
        Collections.sort(recipes, RecipeComparators.CompareByTime);
    }

    /**
     * method sortByComplexity() will sort recipes field by complexity of cooking
     */
    public void sortByComplexity() {
        Collections.sort(recipes, RecipeComparators.CompareByComplexity);
    }

    /**
     * method sortByNumOfEntries() will sort recipes field by number of entries
     * (first will be recipe with largest number of entries of products, given by user)
     */
    public void sortByNumOfProducts() {
        Collections.sort(recipes, RecipeComparators.CompareByNumOfProducts);
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
