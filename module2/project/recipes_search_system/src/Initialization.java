import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Initialization {
    private final File productsDirectory;
    private final File recipesDirectory;

    public Initialization(File productsDirectory, File recipesDirectory) {
        checkDirectory(productsDirectory);
        checkDirectory(recipesDirectory);
        this.productsDirectory = productsDirectory;
        this.recipesDirectory = recipesDirectory;
    }

    private void checkDirectory(File directory) {
        if (!directory.exists() || !directory.isDirectory()) throw new
                IllegalArgumentException("directory: " + directory.toString() + " does not exist");
    }

    public ArrayList<String> createProductsBase() {
        ArrayList<String> productsBase = new ArrayList<>();
        for (File curItem:productsDirectory.listFiles()) {
            String fileName = curItem.getName();
            if(fileName.endsWith(".json")){
                ArrayList<String> productsInFile = parseProductsJson(curItem);
                productsBase.addAll(productsInFile);
            }
        }
        Collections.sort(productsBase);
        return productsBase;
    }

    public HashMap<CategoriesOfDishes, RecipesBase> createRecipesBase() {
        HashMap<CategoriesOfDishes, RecipesBase> recipesBase = new HashMap<>();
        for (File curItem:recipesDirectory.listFiles()) {
            String fileName = curItem.getName();
            if(fileName.endsWith(".json")){
                Recipe recipe = parseRecipeJson(curItem);
                addRecipeToBase(recipe, recipesBase);
            }
        }

        return recipesBase;
    }

    private void addRecipeToBase(Recipe recipe, HashMap<CategoriesOfDishes, RecipesBase> recipesBase) {
        if (!recipe.getName().equals("Not initialized")) {
            CategoriesOfDishes key = recipe.getCategory();
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

    private ArrayList<String> parseProductsJson(File curItem) {
        ArrayList<String> products = new ArrayList<>();
        try {
            String fileContent = readFile(curItem);
            JSONObject jsonObject = new JSONObject(fileContent);
            JSONArray array = jsonObject.getJSONArray("products");
            for (int i = 0; i < array.length(); i++) {
                String product = array.getJSONObject(i).getString("ProductName");
                products.add(product.toUpperCase());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return products;
    }

    private String readFile(File file) throws FileNotFoundException {
        StringBuilder fileContents = new StringBuilder((int)file.length());
        Scanner scanner = new Scanner(file);
        String lineSeparator = System.getProperty("line.separator");

        try {
            while(scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine() + lineSeparator);
            }
            return fileContents.toString();
        } finally {
            scanner.close();
        }
    }

    private Product createProduct(JSONObject curObj) throws JSONException, IllegalArgumentException {
        String productName = curObj.getString("name").toUpperCase();
        double quantity = curObj.getDouble("quantity");

        Units units = Units.valueOf(curObj.getString("units"));
        byte significance = (byte) curObj.getInt("significance");

        Product newProduct = new Product(productName, quantity, units, significance);

        JSONArray substitutesArray = curObj.getJSONArray("substitutes");
        for (int i = 0; i < substitutesArray.length(); i++) {
            curObj = substitutesArray.getJSONObject(i);
            Product newSubstitute = createProduct(curObj);
            newProduct.addSubstitute(newSubstitute);
        }

        return newProduct;
    }

    private Recipe createRecipe(JSONObject jsonObject) throws JSONException, IllegalArgumentException {
        String category = jsonObject.getString("category");
        CategoriesOfDishes.valueOf(category);

        String name = jsonObject.getString("name");
        int time = jsonObject.getInt("time");
        byte complexity = (byte)jsonObject.getInt("complexity");
        String algorithm = jsonObject.getString("algorithm");

        return new Recipe(CategoriesOfDishes.valueOf(category), name, time, complexity, algorithm);
    }

    public ArrayList<String> addProducts(File file, ArrayList<String> oldProductsBase) {
        if (!file.exists()) throw new IllegalArgumentException("File does not exist!");
        String fileName = file.getName();
        if(fileName.endsWith(".json")){
            ArrayList<String> productsInFile = parseProductsJson(file);
            oldProductsBase.addAll(productsInFile);
        }
        Collections.sort(oldProductsBase);
        return oldProductsBase;
    }

    public HashMap<CategoriesOfDishes, RecipesBase> addRecipe(File file, HashMap<CategoriesOfDishes, RecipesBase> oldRecipesBase) {
        if (!file.exists()) throw new IllegalArgumentException("File does not exist!");
        String fileName = file.getName();
        if(fileName.endsWith(".json")){
            Recipe recipe = parseRecipeJson(file);
            addRecipeToBase(recipe, oldRecipesBase);
        }
        return oldRecipesBase;
    }
}
