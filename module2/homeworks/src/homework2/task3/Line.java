package homework2.task3;

/*
Написать класс:
Line (линия).
Свойства: начальная точка, конечная точка.
Методы: подсчет длины линии.
 */

public class Line {

    private final Point firstPoint;
    private final Point lastPoint;

    public Line (Point first, Point last) {
        firstPoint = first;
        lastPoint = last;
    }

    public double calcLen() {
        double lenSqr = (firstPoint.x - lastPoint.x) * (firstPoint.x - lastPoint.x) +
                (firstPoint.y - lastPoint.y) * (firstPoint.y - lastPoint.y);

        return Math.sqrt(lenSqr);
    }

    public String toString() {
        String string = String.format("X1: %f, Y1: %f\nX2: %f, Y2: %f", firstPoint.x, firstPoint.y,
                lastPoint.x, lastPoint.y);
        return string;
    }
}
