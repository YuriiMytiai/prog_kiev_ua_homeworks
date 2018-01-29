package homework1;


public class L4T6 {
    public static void main(String[] args) {
        int[] array = {9, 8, 6, 2, 0, 7, 6, 3, 1, 2, 3};
        printMinMax(array);
    }

    private static void printMinMax(int[] arr) {
        int len = arr.length;
        int[] minValue = {arr[0], 0};
        int[] maxValue = {arr[0], 0};
        int curEl;
        for(int i = 0; i < len; i++) {
            curEl = arr[i];
            if(curEl < minValue[0]) {
                minValue[0] = curEl;
                minValue[1] = i;
            } else if(curEl > maxValue[0]) {
                maxValue[0] = curEl;
                maxValue[1] = i;
            }
        }
        System.out.println(String.format("Min value: %d at %d position, max value: %d at %d position", minValue[0], minValue[1], maxValue[0], maxValue[1]));
    }
}
