import java.io.Serializable;
import java.util.ArrayList;
// this class describes one product in recipe

public class Product implements Serializable {

    private final String name; // name should be one of valid values
    private final Units unit;
    private final byte significance; // significance of product in percents (0-100)
    private final ArrayList<Product> substitutes = new ArrayList<>(); // list of possible substitute products
    private double quantity; // how much product needs in recipe

    public Product(String name, double quantity, Units unit, byte significance) {
        checkArgs(quantity, significance);
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.significance = significance;
    }


    private void checkArgs(double quantity, byte significance) {
        if ((quantity < 0)) // if quantity = 0 we don't need this product in recipe, if qty < 0 it doesn't have sens
            throw new IllegalArgumentException("Quantity has illegal value");
        else if ((significance < 1) || (significance > 100)) // if significance = 0 we don't need this product in recipe, if significance < 0 it doesn't have sens
            throw new IllegalArgumentException("Significance has illegal value");
    }

    public void addSubstitute(Product product) {
        substitutes.add(product);
    }

    public String getName() { return name; }

    public Units getUnit() { return unit; }

    public byte getSignificance() { return significance; }

    public ArrayList<Product> getSubstitutes() { return substitutes; }

    public double getQuantity(int persons) {
        if (persons < 1) throw new IllegalArgumentException("Number of persons must be grater than 0");
        return quantity * persons;
    }

    @Override
    public String toString() {
        String text;
        if (substitutes.isEmpty()) text = String.format("%s - %.3f %s\n", name, quantity, unit);
        else {
            StringBuilder sb = new StringBuilder(String.format("%s - %.3f %s\n", name, quantity, unit));
            for (Product product:substitutes) {
                sb.append("\tor\n\t");
                sb.append(product.toString());
            }
            text = sb.toString();
        }

        return text;
    }
}
