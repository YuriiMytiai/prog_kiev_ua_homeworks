package homework1;

public class L4T1 {
    public static void main(String[] args) {
        int[] array = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        whileLoop(array);
        doWhileLoop(array);
        forLoop(array);
        forEachLoop(array);
    }

    private static void whileLoop(int[] arr) {
        int len = arr.length;
        int i = 0;
        while (i < len) {
            System.out.println(arr[i]);
            i++;
        }
    }

    private static void doWhileLoop(int[] arr) {
        int len = arr.length;
        int i = 0;
        do {
            System.out.println(arr[i]);
            i++;
        } while (i != len);
    }

    private static void forLoop(int[] arr) {
        int len = arr.length;
        for(int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void forEachLoop(int[] arr) {
        for(int el:arr) {
            System.out.println(el);
        }
    }
}
