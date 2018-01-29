package homework1;

import java.util.Arrays;

public class L4T3 {
    public static void main(String[] args) {
        int maxNum = 100;
        int minNum = 0;
        int[] arr = makeDescArray(minNum, maxNum);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] makeDescArray(int minNum, int maxNum) {
        int len = maxNum - minNum + 1;
        int[] arr = new int[len];
        for (int i = maxNum, j = 0; i >= minNum; i--, j++) {
            arr[j] = i;
        }
        return arr;
    }


}