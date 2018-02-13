package homework3;

import java.util.Scanner;

public class Quadratic {
    public static void main(String[] args) {
        System.out.println("Quadratic equation: ax^2 + bx + c = 0");

        double[] coeffs = scanCoeffs();
        double dSqrt = discriminantSqrt(coeffs);
        double[] ans = findSolution(coeffs, dSqrt);

        System.out.println("x1 = " + ans[0]);
        System.out.println("x2 = " + ans[1]);
    }

    private static double[] scanCoeffs() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a: ");
        double a = sc.nextDouble();

        System.out.print("Enter b: ");
        double b = sc.nextDouble();

        System.out.print("Enter c: ");
        double c = sc.nextDouble();

        return new double[]{a, b, c};
    }

    private static double discriminantSqrt(double[] coeffs) {
        double dSqrt =  Math.sqrt(coeffs[1]*coeffs[1] - 4*coeffs[0]*coeffs[2]);
        if (Double.isNaN(dSqrt)) {
            System.out.println("D < 0, answer is not a real numbers");
            System.exit(0);
        }

        return dSqrt;
    }

    private static double[] findSolution(double[] coeffs, double dSqrt) {
        double[] ans = new double[2];
        ans[0] = (-1 * coeffs[1] + dSqrt) / (2 * coeffs[0]);
        ans[1] = (-1 * coeffs[1] - dSqrt) / (2 * coeffs[0]);

        return ans;
    }
}
