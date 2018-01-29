package homework1;

public class L4T4 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        printSum(arr);
    }

    private static void printSum(int[] arr) {
        int len = arr.length;
        int sum = 0;
        for(int i = 1; i < len - 1; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
