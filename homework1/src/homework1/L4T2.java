package homework1;

public class L4T2 {
    public static void main(String[] args) {
        int len = 100;
        int[] arr = new int[len];
        for(int i = 1; i <= len; i++) {
            arr[i-1] = i;
        }
        printNums(arr, 3);
    }

    private static void printNums(int[] arr, int divider) {
        for(int el:arr) {
            if (el % divider == 0) {
                System.out.println(el);
            }
        }
    }
}
