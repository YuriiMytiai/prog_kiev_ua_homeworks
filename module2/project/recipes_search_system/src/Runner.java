import java.util.ArrayList;

public class Runner {
    //this class shows how to use Recipe Search System

    public static void main(String[] args) {
        //first we need some bases with recipes, so here we're going to create one:
        RecipesBase bbq = new RecipesBase(CategoriesOfDishes.Barbeque);
        addBbqs(bbq);

        /* according to idea of this tool there should be as many bases
           as fields in enumeration CategoriesOfDishes, one base per field.
           Now it'll take lot of time to create big number of bases, so we should try
           to take a look at project with just one base.
           So, bases must be created before user starts running tool. Now I don't know
           what way to store this bases is better. May be just Serializable RecipeBases classes,
           or may be some database.
        */

        /*
        Next part of code shows user interaction with system.
        First of all user should choose one category from CategoriesOfDishes
        enumeration. Cause now we don't have big base at this moment let's assume that user have selected Barbeque category.
        */

        //Second step is creation of list of products that user want to use in recipe:
        ArrayList<Enum> productsUserHas = new ArrayList<>();
        addProducts(productsUserHas);

        //Third step is searching for dishes that user can cook:
        RecipesBase whatUserCanCook = bbq.findByProducts(productsUserHas); //will contain just steak

        /*
        After recipes were founded, user can sort or filter them.
         */

        System.out.println("First test");
        // let's look at list of available recipes:
        System.out.println(whatUserCanCook);

        //let's show this recipe:
        System.out.println(whatUserCanCook.getRecipes().get(0).showRecipe());


        System.out.println("Second test");
        // let's create another one products list
        ArrayList<Enum> anotherProducts = new ArrayList<>();
        addAnotherProducts(anotherProducts);

        //let's find recipes which products lists match with addAnotherProducts by 70 or more percents:
        whatUserCanCook = bbq.findByProducts(anotherProducts, (byte) 70); // will return all 3 recipes

        // let's look at list of available recipes:
        System.out.println(whatUserCanCook);

        System.out.println("Third test");
        //let's sort recipes by time needed for cooking:
        whatUserCanCook.sortByTime(); // will replace 2 and 3 position
        System.out.println(whatUserCanCook);

        //let's find (filter) recipes that need 40 or less minutes to cook dish:
        RecipesBase shortTimeRecipes = whatUserCanCook.findByTime(40);
        System.out.println(shortTimeRecipes); //will return 2 recipes

        //let's find (filter) recipes that have complexity less than or equal to 6:
        RecipesBase smallComplexityRecipes = whatUserCanCook.findByComplexity((byte)6);
        System.out.println(smallComplexityRecipes); //will return 1 recipe

    }




    // method addBbqs(RecipesBase bbq) add some recipes to base
    private static void addBbqs(RecipesBase bbq) {
        //let's add recipe of simple beef steak:
        String alg = "Here is text with explanation how to cook steak.";
        Recipe steak  = new Recipe(CategoriesOfDishes.Barbeque, "Steak", 30, (byte) 6, alg);
        //and we need to add products, that are needed to cook steak:
        steak.addProduct(new Product(Meat.Beaf, 350, Units.Grams, (byte) 100));
        steak.addProduct(new Product(Spices.Salt,0.5, Units.Grams, (byte) 70));
        steak.addProduct(new Product(Spices.Black_pepper, 0.5, Units.Grams, (byte) 70));
        steak.addProduct(new Product(Liquids.Oil, 30, Units.Milliliters,(byte)80));

        //now we can add this recipe to base:
        bbq.addRecipe(steak);



        //let's add one more dish:
        alg = "Here is text with explanation how to cook cutlet";
        Recipe beefCutlet = new Recipe(CategoriesOfDishes.Barbeque, "Beef Cutlet", 45, (byte) 7, alg);
        beefCutlet.addProduct(new Product(Meat.Beaf, 0.5, Units.Kilos, (byte)100));
        beefCutlet.addProduct(new Product(Vegetables.Onion, 100, Units.Grams, (byte)80));
        beefCutlet.addProduct(new Product(AnimalOrigin.Egg, 1, Units.Pieces, (byte)70));
        beefCutlet.addProduct(new Product(Spices.Salt,0.5, Units.Grams, (byte) 70));
        beefCutlet.addProduct(new Product(Spices.Black_pepper, 0.5, Units.Grams, (byte) 70));
        beefCutlet.addProduct(new Product(Liquids.Oil, 30, Units.Milliliters,(byte)80));
        beefCutlet.addProduct(new Product(Vegetables.Carrot, 100, Units.Grams,(byte)20));
        bbq.addRecipe(beefCutlet);

        //and the last one:
        alg = "Here is text with explanation how to cook cutlet";
        Recipe porkCutlet = new Recipe(CategoriesOfDishes.Barbeque, "Pork Cutlet", 40, (byte) 7, alg);
        porkCutlet.addProduct(new Product(Meat.Pork, 0.5, Units.Kilos, (byte)100));
        porkCutlet.addProduct(new Product(Vegetables.Onion, 100, Units.Grams, (byte)80));
        porkCutlet.addProduct(new Product(AnimalOrigin.Egg, 1, Units.Pieces, (byte)70));
        beefCutlet.addProduct(new Product(Spices.Salt,0.5, Units.Grams, (byte) 70));
        beefCutlet.addProduct(new Product(Spices.Black_pepper, 0.5, Units.Grams, (byte) 70));
        beefCutlet.addProduct(new Product(Liquids.Oil, 30, Units.Milliliters,(byte)80));
        bbq.addRecipe(porkCutlet);

    }


    //method addProducts(ArrayList<Enum> productsUserHas) will add some products that user has
    private static void addProducts(ArrayList<Enum> productsUserHas) {
        productsUserHas.add(AnimalOrigin.Egg);
        productsUserHas.add(Meat.Beaf);
        productsUserHas.add(Spices.Salt);
        productsUserHas.add(Spices.Black_pepper);
        productsUserHas.add(Liquids.Oil);

    }

    //addAnotherProducts(ArrayList<Enum> productsUserHas)
    private static void addAnotherProducts(ArrayList<Enum> anotherProducts) {
        anotherProducts.add(AnimalOrigin.Egg);
        anotherProducts.add(Meat.Beaf);
        anotherProducts.add(Meat.Pork);
        anotherProducts.add(Spices.Salt);
        anotherProducts.add(Spices.Black_pepper);
        anotherProducts.add(Liquids.Oil);
        anotherProducts.add(Vegetables.Onion);

    }

}
