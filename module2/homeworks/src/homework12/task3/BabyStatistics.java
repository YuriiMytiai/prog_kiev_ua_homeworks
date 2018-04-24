package homework12.task3;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class BabyStatistics {

    private final String inFileName;
    private final String outFileName;
    private final String delimiter;

    public BabyStatistics(String inFileName, String outFileName, String delimiter) {
        this.inFileName = inFileName;
        this.outFileName = outFileName;
        this.delimiter = delimiter;
    }

    public BabyStatistics(String inFileName, String outFileName) {
        this(inFileName, outFileName, ",");
    }

    public void birthsByYears() {
        try(BufferedReader reader = new BufferedReader(new FileReader(inFileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFileName))) {

            Map<Integer, Integer> data = new TreeMap<>();
            String curLine;
            String header = reader.readLine(); // read header line
            writeHeaderLine(writer, header); // write header line to new file

            while ((curLine = reader.readLine()) != null)   {
                /*
                 * fields[0] - year
                 * fields[1] - births
                 */
                Integer[] fields = parseString(curLine);
                if (data.containsKey(fields[0])) {
                    data.replace(fields[0], data.get(fields[0]) + fields[1]);
                } else {
                    data.put(fields[0], fields[1]);
                }
            }
            writeToFile(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeHeaderLine(BufferedWriter writer, String header) throws IOException {
        String[] tokens = header.split(delimiter);
        String newHeader = tokens[0] + delimiter + tokens[3] + '\n';
        writer.write(newHeader);
    }

    private Integer[] parseString(String curLine) {
        Integer[] fields = new Integer[2];
        String[] tokens = curLine.split(delimiter);
        fields[0] = Integer.parseInt(tokens[0]);
        fields[1] = Integer.parseInt(tokens[3]);
        return fields;
    }

    private void writeToFile(Map<Integer, Integer> data, BufferedWriter writer) throws IOException {
        data.forEach((y, b) -> {
            try {
                writer.write(y + delimiter + b + '\n');
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writer.close();
    }
}
