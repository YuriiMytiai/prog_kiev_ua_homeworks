package homework2;
/*
Написать свой вариант ф-и Arrays.toString() для int[].
 */

public class L5T3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        String arrString = toString(arr);
        System.out.println(arrString);
    }

    private static String toString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        if (arr.length == 0) return sb.toString();

        sb.append("[");
        for (int i = 0; i < (arr.length - 1); i++) {
            sb.append(arr[i]);
            sb.append(", ");
        }
        sb.append(arr[arr.length - 1]);
        sb.append("]");
        return sb.toString();
    }
}
