package homework9.task1;

import homework8.task4.Task;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BinarySearchRunner {
    public static void main(String[] args) {
        int[] array = {0, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17, 19, 20};
        System.out.println(BinarySearch.binarySearch(array, 3)); // 3
        System.out.println(BinarySearch.binarySearch(array, 2)); // 2
        System.out.println(BinarySearch.binarySearch(array, 14)); // -14
        System.out.println(BinarySearch.binarySearch(array,17)); //16
        System.out.println(BinarySearch.binarySearch(array,0)); //0
        System.out.println(BinarySearch.binarySearch(array,1)); // -1

        System.out.println();

        List<Integer> list = Arrays.asList(0, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17, 19, 20);
        System.out.println(BinarySearch.binarySearch(list, Integer.valueOf(3), byValue())); // 3
        System.out.println(BinarySearch.binarySearch(list, Integer.valueOf(0), byValue())); // 0
        System.out.println(BinarySearch.binarySearch(list, Integer.valueOf(14), byValue())); // -14
        System.out.println(BinarySearch.binarySearch(list, Integer.valueOf(17), byValue())); // 16
    }

    public static Comparator<Integer> byValue() {
        return new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.intValue() - o2.intValue();
            }

        };
    }
}
