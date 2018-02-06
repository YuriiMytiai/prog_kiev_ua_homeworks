package homework2;
/*
Дано 3 массива чисел. С помощью 1-2-х циклов найти
сумму элементов во всех массивах.
 */

public class L6T3 {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {1, 2, 3, 4};
        int[] arr3 = {1};

        int sum = findSum(arr1, arr2, arr3);
        System.out.println(sum);

    }


    private static int findSum(int[] arr1, int[] arr2, int[] arr3) {
        int sum = 0;

        int len1 = arr1.length;
        int len2 = arr2.length;
        int len3 = arr3.length;

        int maxLenArr = maxLen(len1, len2, len3);

        for (int i = 0; i < maxLenArr; i++) {
            if (i < len1) sum += arr1[i];
            if (i < len2) sum += arr2[i];
            if (i < len3) sum += arr3[i];
        }
        return sum;
    }

    private static int maxLen(int len1, int len2, int len3) {
        return Math.max(Math.max(len1, len2), Math.max(len1, len3));
    }
}
