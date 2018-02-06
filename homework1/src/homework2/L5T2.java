package homework2;

/*
Написать свой вариант ф-и Arrays.equals для short[].
 */

public class L5T2 {
    public static void main(String[] args) {
        short[] arr1 = {1, 2, 3, 4, 5, 6};
        short[] arr2 = {1, 3, 2, 4, 5, 6};

        boolean isEqual = equals(arr1, arr1);
        System.out.println(isEqual);

        isEqual = equals(arr1, arr2);
        System.out.println(isEqual);

    }


    static boolean equals(short[] arr1, short[] arr2) {
        if (arr1.length != arr2.length) return false;
        int len = arr1.length;
        for (int i  = 0; i < len; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
