package homework12.task1;

public class FileLineNumeratorRunner {
    public static void main(String[] args) {
        String inFileName = "./src/homework12/task1/texts/hamlet.txt";
        String outFileName = "./src/homework12/task1/texts/hamlet-with-line-nums.txt";
        new FileLineNumerator(inFileName, outFileName).runLineNumeration();
    }
}
