package homework9.task1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BinarySearch {

    static int binarySearch(int[] array, int elem) {
        if (array.length == 1) {
            if (array[0] == elem) return 0;
            else return -1;
        }

        int idx = array.length / 2;
        if (array[idx] == elem) return idx;
        if (array[idx] > elem)  {
            int nextIdx = binarySearch(Arrays.copyOfRange(array, 0, idx), elem);
            return nextIdx;
        }
        else if (array[idx] < elem) {
            int nextIdx = binarySearch(Arrays.copyOfRange(array, idx, array.length), elem);
            if (nextIdx < 0) return -idx + nextIdx;
            else return idx + nextIdx;
        }

        return 0;
    }


    static <T> int binarySearch(List<T> list, T elem, Comparator<T> comparator) {
        if (list.size() == 1) {
            if (comparator.compare(list.get(0), elem) == 0) return 0;
            else return -1;
        }
        int idx = list.size() / 2;
        if (comparator.compare(list.get(idx), elem) == 0) return idx;

        if (comparator.compare(list.get(idx), elem) > 0)  {
            int nextIdx = binarySearch(list.subList(0, idx), elem, comparator);
            return nextIdx;
        }
        else if (comparator.compare(list.get(idx), elem) < 0) {
            int nextIdx = binarySearch(list.subList(idx, list.size()), elem, comparator);
            if (nextIdx < 0) return -idx + nextIdx;
            else return idx + nextIdx;
        }

        return 0;
    }
}
