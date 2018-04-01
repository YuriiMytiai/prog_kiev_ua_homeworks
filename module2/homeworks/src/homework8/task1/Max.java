package homework8.task1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Max {

    /*
    method returns NULL if list is empty
     */
    static <T> T max(List<T> list, Comparator<T> comparator) {
        return list.stream().max(comparator).get();

        //or:
        /*
        if (list.isEmpty()) return null;
        Object[] a = list.toArray();
        Arrays.sort(a, (Comparator) comparator);
        return (T) a[a.length - 1];
        */
    }
}
