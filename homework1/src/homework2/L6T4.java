package homework2;
/*
Дано текст. Убрать лишние пробелы, расставить знаки
препинания. Пример: «Я длинное предложение Я
второе предложение.» -> «Я длинное предложение. Я
второе предложение.»
 */

public class L6T4 {
    public static void main(String[] args) {
        String text = "  Я  длинное предложение    Я  второе предложение  .";
        String correctedText = corectText(text);
        System.out.println(correctedText);

    }

    private static String corectText(String text) {
        int len = text.length();
        if (len == 0) return "";

        char[] arr = text.toCharArray();

        StringBuilder sb = new StringBuilder();

        // first char always must be in upper case

        // need some flags
        boolean lastNotDot = false;
        boolean wasDot = false;
        boolean firstLetter = true;

        for (int i = 0; i < len; i++) {
            // first character must be not dot or space
            if (firstLetter && ((arr[i] == 46) || (arr[i] == 32))) continue;
            // first char always must be in upper case
            else if (firstLetter) {
                sb.append(Character.toUpperCase(arr[i]));
                firstLetter = false;
            }
            // flag to add dot in the end of sentence
            else if ((i == len - 1) && (arr[i] != 46)) lastNotDot = true;
            // miss extra spaces
            else if (arr[i] == 32 && arr[i+1] == 32) continue;
            // if dot set flag and append
            else if (arr[i] == 46)  {
                wasDot = true;
                sb.append(arr[i]);
            }
            // if not dot and not space and was dot before this character
            // set char to upper case, append it and reset dot flag
            else if ((arr[i] != 32) && (arr[i] != 46) && wasDot) { //
                sb.append(Character.toUpperCase(arr[i]));
                wasDot = false;
            }
            // if character is not a dot ot space and character is in upper case but there wasn't dot before it
            // add dot before space and add char
            else if ((arr[i] == Character.toUpperCase(arr[i])) && (arr[i - 2] != 46) && (arr[i] != 32) && (arr[i] != 46)) {
                sb.insert(sb.length() - 1, '.');
                sb.append(arr[i]);
            }
            // if there is a space before dot miss it
            else if ((arr[i] == 32 && arr[i+1] == 46)) continue;
            // else add current character
            else sb.append(arr[i]);

        }

        if (lastNotDot) sb.append('.');
        return sb.toString();
    }
}
