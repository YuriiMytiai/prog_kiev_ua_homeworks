package homework2.task2;

/*
Написать класс:
Rectangles (прямоугольники).
Свойства: список прямоугольников.
Методы: добавление прямоугольника, подсчет суммарной площади всех прямоугольников.
 */

import java.util.ArrayList;

public class Rectangles {

    private final ArrayList<Rectangle> rectangles = new ArrayList<>();

    public void addRectangle(Rectangle rectangle) { rectangles.add(rectangle); }

    public double calcSummaryArea() {
        double sumArea = 0;
        for (Rectangle curRect:rectangles) {
            sumArea += curRect.calcArea();
        }

        return sumArea;
    }
}
