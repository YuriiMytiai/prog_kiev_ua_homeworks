import java.util.Comparator;

public class RecipeComparators {

    public static final Comparator<Recipe> compareByTime() {
        return Comparator.comparingInt(Recipe::getTime);
    }

    public static final Comparator<Recipe> compareByComplexity(){
        return Comparator.comparingInt(Recipe::getComplexity);
    }

    /**
     * here if number of products is smaller, than object will be higher in list.
      */
    public static final Comparator<Recipe> compareByNumOfProducts() {
        return (r1, r2) -> r2.getProducts().size() - r1.getProducts().size();
    }
}
