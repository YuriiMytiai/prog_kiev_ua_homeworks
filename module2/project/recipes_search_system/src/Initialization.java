import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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

    public List<String> createProductsBase() {
        List<String> productsBase = new ArrayList<>();
        for (File curItem:productsDirectory.listFiles()) {
            String fileName = curItem.getName();
            if(fileName.endsWith(".json")){
                List<String> productsInFile = parseProductsJson(curItem);
                productsBase.addAll(productsInFile);
            }
        }
        Collections.sort(productsBase);
        return productsBase;
    }

    public AllRecipesCollection createRecipesBase() {
        AllRecipesCollection recipesBase = new AllRecipesCollection();
        recipesBase.initialize(recipesDirectory);
        return recipesBase;
    }

    private List<String> parseProductsJson(File curItem) {
        List<String> products = new ArrayList<>();
        try {
            String fileContent = AllRecipesCollection.readFile(curItem);
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

    public List<String> addProducts(File file, List<String> oldProductsBase) {
        if (!file.exists()) throw new IllegalArgumentException("File does not exist!");
        String fileName = file.getName();
        if(fileName.endsWith(".json")){
            List<String> productsInFile = parseProductsJson(file);
            oldProductsBase.addAll(productsInFile);
        }
        Collections.sort(oldProductsBase);
        return oldProductsBase;
    }

}
