package homework2.task1;

/*
Написать класс:
Dish (блюдо).
Свойства: название, описание, цена.
 */

public class Dish {
    private final String name;
    private final String description;
    private final long price;

    public Dish(String name, String description, long price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public long getPrice() { return price; }

    public String toString() { return String.format("%s - %d UAH \n", name, price); }
}
