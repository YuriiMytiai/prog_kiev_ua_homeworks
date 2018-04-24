package homework11.task1;

public class Benchmark {
    public static void main(String[] args) {
        // let's call factorial method in sequence
        int n = 100;
        int k = 1000;

        runSequence(n, k); // 263 sec

        // let's call factorial method in parallel
        runParallel(n, k); // 157 sec

    }

    private static void runSequence(int n, int k) {
        long start = System.currentTimeMillis();
        for (int i = 1; i <= n; i++) {
            int num = k * i;
            Factorial.calcAndWriteFactorial(num);
        }
        long time = System.currentTimeMillis() - start;

        System.out.println("Execution time of sequence of method calls: " + time / 1000 + " sec.");
    }

    private static void runParallel(int n, int k) {
        long start = System.currentTimeMillis();
        Factorial.calculateFactorialsMultithreadMode(n, k);
        long time = System.currentTimeMillis() - start;

        System.out.println("Execution time of parallel method calls: " + time / 1000 + " sec.");
    }
}
