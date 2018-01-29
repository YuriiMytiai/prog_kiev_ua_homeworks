package homework1;

import java.util.Arrays;

public class L3T5 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(array));

        array = flipArr(array);
        System.out.println(Arrays.toString(array));
    }

    public static int[] flipArr(int[] arr) {
        int temp;
        int len = arr.length / 2;

        for(int i = 0; i < len; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }
}
