package homework1;

public class L4T7 {
    /*
    Can find just one most repeated value
     */
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 3, 3, 3, 5, 6, 7, 8, 9, 2, 4, 5};
        findMostRepeatedFromArray(array);
    }

    private static void findMostRepeatedFromArray(int[] arr) {
        int len = arr.length;
        int[] uniqueNums = new int[len];
        int[] numOfRepeats = new int[len];
        int curEl;
        boolean foundedUnique;

        for(int i = 0; i < len; i++) {
            foundedUnique = false;
            curEl = arr[i];

            for (int j = 0; j < len; j++) {
                if(curEl == uniqueNums[j]) {
                    numOfRepeats[j]++;
                    foundedUnique = true;
                    break;
                }
            }
            if(!foundedUnique) {
                uniqueNums[i] = curEl;
                numOfRepeats[i]++;
            }
        }

        int[] result = findMostRepeated(uniqueNums, numOfRepeats);
        System.out.println(String.format("Most repeated value is %d. It repeats %d times", result[0], result[1]));
    }


    private static int[] findMostRepeated(int[] uniqueNums, int[] numOfRepeats) {
        int len = numOfRepeats.length;
        int maxRepeats = 0;
        int targetIdx = -1;
        int curEl;
        for(int i = 0; i < len; i++) {
            curEl = numOfRepeats[i];
            if(curEl > maxRepeats) {
                maxRepeats = curEl;
                targetIdx = i;
            }
        }
        int mostRepNum = uniqueNums[targetIdx];
        int numOfReps = numOfRepeats[targetIdx];
        int[] res = {mostRepNum, numOfReps};
        return res;
    }

}
