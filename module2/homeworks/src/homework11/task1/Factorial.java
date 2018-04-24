package homework11.task1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class Factorial{

    private static BigInteger calculateFactorial(int num) {
        if (num == 0) return BigInteger.ONE;
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= num; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }


    private static void writeToFile(String filename, String content) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void calcAndWriteFactorial(int num) {
        BigInteger factorial = calculateFactorial(num);
        String filename = "./src/homework11/task1/logs/factorial_" + num + ".txt";
        writeToFile(filename, factorial.toString());
    }

    public static void calculateFactorialsMultithreadMode(int numThreads, int num) {
        Thread[] threads = new Thread[numThreads];

        for (int i = 1; i <= numThreads; i++) {
            int curNum = num * i;
            threads[i - 1] = new Thread(() -> calcAndWriteFactorial(curNum), "factorial_" + String.valueOf(i));
            threads[i - 1].start();
        }

        for (int i = 1; i <= numThreads; i++) {
            try {
                threads[i - 1].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
