import java.io.File;
import java.util.HashMap;
import java.util.List;

public class Runner {
    //this class shows how to use Recipe Search System

    public static void main(String[] args) {
        //first we need some bases with recipes, so here we're going to initialize system:
        // here we need no set paths to products and recipes files:
        Initialization initialization = new Initialization(new File("src.//content.//products"),
                new File("src.//content//recipes"));

        //here we're creating base with products:
        List<String> productsBase = initialization.createProductsBase();

        //here we're creating bases with recipes that correspond to fixed
        //categories of dishes:
        AllRecipesCollection recipesBase = initialization.createRecipesBase();


        /*
        Next part of code shows user interaction with system.
        First of all user should choose one category from CategoriesOfDishes
        enumeration. Cause now we don't have big base at this moment let's assume that user have selected Barbeque category.
        */
        // lets assume that user selected Barbeque category:
        DishCategory userChoice = DishCategory.BARBEQUE;

        //lets create user:
        User user1 = new User("User 1", userChoice, recipesBase, productsBase);

        //Second step is creation of list of products that user want to use in recipe:
        user1.addProduct("Egg").addProduct("Beef").addProduct("Salt")
                .addProduct("Black pepper").addProduct("Olive oil");

        //Third step is searching for dishes that user can cook:
        RecipesBase whatUserCanCook = user1.getRecipesBase().findByProducts(user1.getProducts()); //will contain just steak

        /*
        After recipes were founded, user can sort or filter them.
         */

        System.out.println("First test");
        // let's look at list of available recipes:
        System.out.println(whatUserCanCook);

        //let's show this recipe:
        System.out.println(whatUserCanCook.getRecipes().get(0).showRecipe());

        System.out.println("--------------------------------");
        System.out.println("Second test");
        // let's create another one products list
        user1.clearProductsList();
        user1.addProduct("Egg").addProduct("Beef").addProduct("Salt")
                .addProduct("Black pepper").addProduct("Olive oil").addProduct("Onion").addProduct("Pork");


        //let's find recipes which products lists match with addAnotherProducts by 70 or more percents:
        whatUserCanCook = user1.getRecipesBase().findByProducts(user1.getProducts(), (byte) 70); // will return all 3 recipes

        // let's look at list of available recipes:
        System.out.println(whatUserCanCook);

        System.out.println("--------------------------------");
        System.out.println("Third test");
        //let's sort recipes by time needed for cooking:
        whatUserCanCook.sortByTime(); // will replace 1 and 3 position
        System.out.println(whatUserCanCook);

        //let's find (filter) recipes that need 40 or less minutes to cook dish:
        RecipesBase shortTimeRecipes = whatUserCanCook.findByTime(40);
        System.out.println(shortTimeRecipes); //will return 2 recipes

        //let's find (filter) recipes that have complexity less than or equal to 6:
        RecipesBase smallComplexityRecipes = whatUserCanCook.findByComplexity((byte)5);
        System.out.println(smallComplexityRecipes); //will return 1 recipe

    }


}
