package homework1;

/*
Написать метод, находящий все имена, начинающиеся с буквы startLetter, в списке имен.
Использовать цикл for-each.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Task2 {

    public static void main(String[] args) {
        String[] namesArr = new String[] {"Pavel", "Michael", "Ivan", "Vasiliy", "Anastasiia", "Olga", "Mariia"};
        ArrayList<String> names = new ArrayList<>(Arrays.asList(namesArr));

        char targetLetter = 'L';

        ArrayList<String> targetNames = namesWithStartLetter(names, targetLetter);
        System.out.println(targetNames);
    }

    private static ArrayList<String> namesWithStartLetter(ArrayList<String> names, char letter) {
        ArrayList<String> targetList = new ArrayList<>();

        for (String curName:names) {
            if (curName.charAt(0) == letter) targetList.add(curName);
        }

        return targetList;
    }
}
