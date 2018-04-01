package homework8.task3;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class FilterRunner {
    public static void main(String[] args) {
        List<Integer> ages = Arrays.asList(36, 28, 12, 25, 43);
        List<Integer> agesBetween20And30 = Filter.filter(ages, new RangePredicate(20, 30));
        System.out.println(agesBetween20And30); // [28, 25]

        List<LocalDate> birthDays = Arrays.asList(
                LocalDate.of(1995, 8, 4),
                LocalDate.of(2004, 10, 3),
                LocalDate.of(1986, 3, 15),
                LocalDate.of(2001, 2, 26)
        );
        List<LocalDate> birthDaysIn21thCentury =
                Filter.filter(birthDays, new DateAfterPredicate(LocalDate.of(1999, 12, 31)));
        System.out.println(birthDaysIn21thCentury); // [2004-10-03, 2001-02-26]


    }
}
