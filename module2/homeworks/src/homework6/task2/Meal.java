package homework6.task2;

public class Meal {
    private final String mealType;
    private final boolean isDrink;
    private final long mealPrice;

    public Meal(String mealType, long mealPrice, boolean withDrink) {
        this.mealType = mealType;
        this.mealPrice = mealPrice;
        isDrink = withDrink;
    }

    public long getMealPrice() {
        return (isDrink) ? (mealPrice + 10) : mealPrice;
    }
}
