package homework9.task3;

public class MenuRunner {
    public static void main(String[] args) {
        Menu menu = new Menu("Italian summer");
        menu.addDish(new Dish("Margherita", "Italian pizza", 200));
        menu.addDish(new Dish("Carbonara", "Italian pasta", 100));
        menu.addDish(new Dish("Lasagne", "Flat Italian pasta", 130));

        for (Dish dish : menu) {
            System.out.println(dish);
        }

    }
}
