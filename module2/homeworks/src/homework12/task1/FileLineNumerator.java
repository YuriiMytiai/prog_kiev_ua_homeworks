package homework12.task1;

import java.io.*;

public class FileLineNumerator {
    private final String inFileName;
    private final String outFileName;

    public FileLineNumerator(String inFileName, String outFileName) {
        this.inFileName = inFileName;
        this.outFileName = outFileName;
    }

    public void runLineNumeration() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outFileName))) {

            String curLine;
            String newLine;
            int i = 1;
            while ((curLine = reader.readLine()) != null)   {
                newLine = String.valueOf(i++) + ": " + curLine + '\n';
                writer.write(newLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
