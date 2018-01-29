package homework1;


import java.util.Scanner;

public class L3T5_2 {
    public static void main(String[] args) {
        dialog();
    }

    private static void dialog() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Length of int array: ");
        int len = sc.nextInt();
        int[] a = new int[len];

        for(int i = 0; i < a.length; i++) {
            System.out.print("Type integer: ");
            a[i] = sc.nextInt();
        }

        boolean cont = true;
        int idx;
        String yN;
        while (cont) {
            System.out.print("Type element index: ");
            idx = sc.nextInt();
            int maxIdx = a.length - 1;

            if (idx > maxIdx) {
                System.out.println("Index out of bounds. Valid values are from 0 to " + Integer.toString(maxIdx));
                continue;
            }
            System.out.println(a[idx]);

            System.out.print("Do you want to continue (y/n): ");
            yN = sc.next();

            if (yN.equals("n")) {
                cont = false;
            }
        }
    }
}
