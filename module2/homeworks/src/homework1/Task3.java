package homework1;

/*
Написать метод, находящий количество дней, прошедших с дня рождения человека.
День рождения задается в формате “YYYY-MM-DD”, где YYYY - год (4 цифры),
MM - номер месяца (2 цифры), DD - номер дня (2 цифры).
Примеры формата: “1972-12-28”, “2005-05-01”.
Использовать класс java.time.LocalDate.
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Task3 {

    public static void main(String[] args) {
        String dateOfBirth = "1994-10-21";

        long daysFromBirth = daysFromBirthDate(dateOfBirth);
        System.out.println(daysFromBirth);
    }

    private static long daysFromBirthDate(String dateOfBirthString) {
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate currentDate = LocalDate.now();

        return ChronoUnit.DAYS.between(dateOfBirth, currentDate);
    }
}

