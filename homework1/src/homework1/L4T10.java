package homework1;

import java.util.Arrays;

public class L4T10 {
    public static void main(String[] args) {
        int len = 21;
        int minValue = 0;
        int[] array = fillMirrorArray(len, minValue);
        System.out.println(Arrays.toString(array));
    }

    private static int[] fillMirrorArray(int len, int minValue) {
        int[] arr  = new int[len];

        int  curValue;
        int remainder = len % 2;

        switch (remainder){

            case 1:
                arr[len / 2] = minValue;

                for(int i = 0; i <= len / 2; i++) {
                    curValue = minValue++;
                    arr[len / 2 - i] = curValue;
                    arr[len / 2 + i] = curValue;
                }
                break;


            case 0:
                for(int i = 0; i < len / 2; i++) {
                    curValue = minValue++;
                    arr[len / 2 + i] = curValue;
                    arr[len / 2 - i - 1] = curValue;
                }
        }
        return arr;
    }
}
