import com.sun.istack.internal.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class AllRecipesCollection {

   private  Map<DishCategory, RecipesBase> recipesBase = new HashMap<>();


    public AllRecipesCollection addRecipe(File file) {
        if (!file.exists()) throw new IllegalArgumentException("File does not exist!");
        String fileName = file.getName();
        if(fileName.endsWith(".json")) {
            Recipe recipe = parseRecipeJson(file);
            addRecipeToBase(recipe);
        } else if (fileName.endsWith(".ser")) {
            Optional<Recipe> recipe = loadRecipeFromBinary(file);
            recipe.ifPresent(this::addRecipeToBase);
        }
        return this;
    }

    private void addRecipeToBase(Recipe recipe) {
        if (!recipe.getName().equals("Not initialized")) {
            DishCategory key = recipe.getCategory();
            RecipesBase oneRecipesBase = recipesBase.get(key);
            if (oneRecipesBase != null) {
                recipesBase.get(key).addRecipe(recipe);
            } else {
                recipesBase.put(key, new RecipesBase(key).addRecipe(recipe));
            }
        }
    }

    private Recipe parseRecipeJson(File curItem) {
        Recipe newRecipe = new Recipe();
        try {
            String fileContent = readFile(curItem);
            JSONObject jsonObject = new JSONObject(fileContent);
            try{
                newRecipe = createRecipe(jsonObject);
            } catch (IllegalArgumentException e) {
                e.initCause(new Throwable("Category of recipe " + curItem.toString() + " is not valid"));
            }

            JSONArray productsArray = jsonObject.getJSONArray("products");

            JSONObject curObj;
            Product newProduct;
            for (int i = 0; i < productsArray.length(); i++) {
                curObj = productsArray.getJSONObject(i);
                try {
                    newProduct = createProduct(curObj);
                    newRecipe.addProduct(newProduct);
                } catch (IllegalArgumentException e) {
                    e.initCause(new Throwable("Units of measurement in " + curItem.toString() + " are not valid"));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return newRecipe;
    }

    static String readFile(File file) throws FileNotFoundException {
        StringBuilder fileContents = new StringBuilder((int)file.length());
        String lineSeparator = System.getProperty("line.separator");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine()).append(lineSeparator);
            }
            return fileContents.toString();
        }
    }

    private Recipe createRecipe(JSONObject jsonObject) throws JSONException, IllegalArgumentException {
        String category = jsonObject.getString("category");
        DishCategory.valueOf(category);

        String name = jsonObject.getString("name");
        int time = jsonObject.getInt("time");
        int complexity = jsonObject.getInt("complexity");
        String algorithm = jsonObject.getString("algorithm");

        return new Recipe(DishCategory.valueOf(category), name, time, complexity, algorithm);
    }

    private Product createProduct(JSONObject curObj) throws JSONException, IllegalArgumentException {
        String productName = curObj.getString("name").toUpperCase();
        double quantity = curObj.getDouble("quantity");

        Units units = Units.valueOf(curObj.getString("units"));
        int significance = curObj.getInt("significance");

        Product newProduct = new Product(productName, quantity, units, significance);

        JSONArray substitutesArray = curObj.getJSONArray("substitutes");
        for (int i = 0; i < substitutesArray.length(); i++) {
            curObj = substitutesArray.getJSONObject(i);
            Product newSubstitute = createProduct(curObj);
            newProduct.addSubstitute(newSubstitute);
        }

        return newProduct;
    }

    public void initialize(File recipesDirectory) {
        for (File curItem:recipesDirectory.listFiles()) {
            addRecipe(curItem);
        }
    }

    private Optional<Recipe> loadRecipeFromBinary(File curItem) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(curItem))) {
            Recipe recipe = (Recipe) ois.readObject();
            return Optional.of(recipe);
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Can not load recipe from file " + curItem);
        }
        return Optional.empty();
    }

    @Nullable
    public RecipesBase changeDishesCategory(DishCategory category) {
        try {
            RecipesBase recipesBase = this.recipesBase.get(category);
            return recipesBase;
        } catch (IllegalArgumentException e) {
            e.initCause(new Throwable("Base category " + category + " does not exist"));
        }
        return null;
    }
}
