package homework2.task2;

/*
Написать класс:
Клиентский класс RectangleRunner: протестировать функционал предыдущих классов.
 */

public class RectangleRunner {
    public static void main(String[] args) {

        Rectangles rectangles = new Rectangles();
        rectangles.addRectangle(new Rectangle(2, 4));
        rectangles.addRectangle(new Rectangle(1, 3));
        rectangles.addRectangle(new Rectangle(12.25, 2.5));

        System.out.println(rectangles.calcSummaryArea());
    }
}
