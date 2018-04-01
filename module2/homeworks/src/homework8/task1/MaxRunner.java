package homework8.task1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxRunner {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Bob", "Alexander", "Sophia", "Zoe");
        String longestName = Max.max(names, new LengthComparator());
        System.out.println(longestName); // Alexander

        List<LocalDate> birthDays = Arrays.asList(
                LocalDate.of(1995, 8, 4),
                LocalDate.of(1986, 3, 15),
                LocalDate.of(1990, 10, 3),
                LocalDate.of(1990, 2, 26)
        );
        LocalDate latestBirthDayInYear = Max.max(birthDays, new DayInYearComparator());
        System.out.println(latestBirthDayInYear); // // 1990-10-03
    }

}



/** Сравнивает 2 строки по длине. */
class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
        // OR: Integer.compare(s1.length(), s2.length());
    }
}

/** Сравнивает 2 даты по номеру дня в году.*/
class DayInYearComparator implements Comparator<LocalDate> {
    @Override
    public int compare(LocalDate ld1, LocalDate ld2) {
        return ld1.getDayOfYear() - ld2.getDayOfYear();
        // OR: Integer.compare(ld1.getDayOfYear(), ld2.getDayOfYear());
    }
}