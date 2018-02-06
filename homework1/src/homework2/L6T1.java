package homework2;
/*
Дано текст из 3-х слов “word1 word2 word3”. Поменять 1-е
и 3-е слова местами и вывести на экран результат.
 */

public class L6T1 {
    public static void main(String[] args) {
        String str = "word1 word2 word3";
        String newStr = changeOrder(str);
        System.out.println(newStr);
    }

    private static String changeOrder(String str) {
        String[] words = str.split(" ");
        return String.format("%s %s %s", words[2], words[1], words[0]);
    }
}
