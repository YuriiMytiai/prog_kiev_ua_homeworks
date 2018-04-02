import java.util.List;
import java.util.function.Predicate;

public class RecipesPredicates {

    public static final Predicate<Recipe> filterByProducts(List<String> products){
        return recipe -> recipe.getPercentageOfEntries(products) == 100;
    }

    public static final Predicate<Recipe> filterByProducts(List<String> products, byte entryPercents){
        return recipe -> recipe.getPercentageOfEntries(products) >= entryPercents;
    }

    public static final Predicate<Recipe> filterByTime(int time){
        return recipe -> recipe.getTime() <= time;
    }

    public static final Predicate<Recipe> filterByComplexity(byte complexity){
        return recipe -> recipe.getComplexity() <= complexity;
    }
}

