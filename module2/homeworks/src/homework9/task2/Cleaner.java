package homework9.task2;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

public class Cleaner {

    static void removeNulls(Collection<?> collection) {
        for (Iterator<?> itr = collection.iterator(); itr.hasNext();) {
            if (itr.next() == null) { itr.remove(); }
        }
    }

    static <T> void remove(Collection<T> collection,
                           Predicate<T> predicate) {
        for (Iterator<T> itr = collection.iterator(); itr.hasNext();) {
            if (predicate.test(itr.next())) { itr.remove(); }
        }
    }
}
