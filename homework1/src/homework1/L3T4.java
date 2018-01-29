package homework1;

public class L3T4 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(calcMean(array));

        double[] arr = {1.5, 6.8, 2.8, 3};
        System.out.println(calcMean(arr));
    }


    private static double calcMean(int[] arr) {
        int sumArr = 0;
        for(int anA : arr) {
            sumArr += anA;
        }
        return sumArr / (double)arr.length;
    }

    private static double calcMean(double[] arr) {
        double sumArr = 0;
        for(double anA : arr) {
            sumArr += anA;
        }
        return sumArr / (double)arr.length;
    }
}
