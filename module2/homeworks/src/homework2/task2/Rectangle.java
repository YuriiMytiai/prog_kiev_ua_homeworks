package homework2.task2;

/*
Написать класс:
Rectangle (прямоугольник).
Свойства: ширина, высота.
Методы: подсчет периметра, подсчет площади.

 */

public class Rectangle {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calcPerimeter() { return 2 * (width + height); }

    public double calcArea() { return width * height; }
}
