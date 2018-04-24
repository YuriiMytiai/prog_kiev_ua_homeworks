package homework12.task3;

public class BabyStatisticsRunner {
    public static void main(String[] args) {
        String inFile = "./src/homework12/task3/births.csv";
        String outFile = "./src/homework12/task3/births_by_years.csv";

        new BabyStatistics(inFile, outFile).birthsByYears();
    }
}
