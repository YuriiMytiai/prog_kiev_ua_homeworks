package homework8.task3;

import java.time.LocalDate;
import java.util.function.Predicate;

/** Проверяет, находится ли дата после фиксированной даты. */
public class DateAfterPredicate implements Predicate<LocalDate> {

    private final LocalDate minDate;

    public DateAfterPredicate(LocalDate minDate) {
        this.minDate = minDate;
    }

    @Override
    public boolean test(LocalDate date) {
        return date.compareTo(minDate) > 0;
    }
}

