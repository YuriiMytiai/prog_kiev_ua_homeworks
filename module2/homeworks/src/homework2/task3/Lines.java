package homework2.task3;

/*
Написать класс:
Lines (линии).
Свойства: список линий.
Методы: добавление линии, суммарная длина всех линий, нахождение самой длинной линии.
 */

import java.util.ArrayList;

public class Lines {

    private final ArrayList<Line> lines = new ArrayList<>();

    public void addLine(Line line) { lines.add(line); }

    public double calcSummaryLen() {
        double sum = 0;
        for(Line curLine:lines) {
            sum += curLine.calcLen();
        }

        return sum;
    }

    public Line findTheLongest() {
        if (lines.size() == 1) return lines.get(0);

        double maxLen = lines.get(0).calcLen();
        Line longestOne = lines.get(0);
        for (Line curLine:lines) {
            if (curLine.calcLen() > maxLen) {
                maxLen = curLine.calcLen();
                longestOne = curLine;
            }
        }

        return longestOne;
    }
}
