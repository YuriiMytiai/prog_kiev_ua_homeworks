package homework9.task3;

/*
Написать класс:
Menu (меню).
Свойства: название, список блюд.
Методы: добавление блюда, нахождение самого дешевого блюда.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class Menu implements Iterable<Dish> {

    private final String name;
    private final ArrayList<Dish> dishes = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    public void addDish(Dish dish) { dishes.add(dish); }

    public Dish getCheapestDish() {
        if (dishes.isEmpty()) throw new IllegalArgumentException("There are no dishes in menu");

        if (dishes.size() == 1) return dishes.get(0);

        long lowestPrice = dishes.get(0).getPrice();
        Dish cheapestDish = dishes.get(0);
        for(Dish curDish:dishes) {
            if (curDish.getPrice() < lowestPrice) {
                lowestPrice = curDish.getPrice();
                cheapestDish = curDish;
            }
        }

        return cheapestDish;
    }
    public String getName() { return name; }

    public String toString() {
        StringBuilder string = new StringBuilder("Menu name: " + name + "\nDishes:\n");
        for (Dish curDish:dishes) {
            string.append(curDish.toString());
        }
        return string.toString();
    }

    @Override
    public Iterator<Dish> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Dish> {

        private final Iterator<Dish> iter = dishes.iterator();
        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }

        @Override
        public Dish next() {
            return iter.next();
        }
    }
}
