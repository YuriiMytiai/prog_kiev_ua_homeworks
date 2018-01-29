package homework1;

import java.util.Scanner;

public class L4T8 {
    /*
    Can't parse brackets and takes precedence over signs
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Type an expression: ");
        String expr = sc.next();
        double result = evalExpr(expr);
        System.out.println(String.format("%s = %f", expr, result));
    }

    private static double evalExpr(String expr) {
        String[] exprPlusMinus = expr.split("(?<=[+-])|(?=[+-])"); // unfortunately I don't fully understand this regular expression
        for(int j = 0; j < exprPlusMinus.length; j++) {
            String subStr = exprPlusMinus[j];
            if((subStr.equals("+")) || (subStr.equals("-"))) {
                continue;
            }

            String[] exprMultDiv = subStr.split("(?<=[*/])|(?=[*/])");
            if(exprMultDiv.length > 1) {
                double multDivRes = Double.parseDouble(exprMultDiv[0]);

                for (int i = 1; i < exprMultDiv.length; i += 2) {
                    switch (exprMultDiv[i]) {

                        case "*":
                            multDivRes *= Double.parseDouble(exprMultDiv[i + 1]);
                            break;

                        case "/":
                            multDivRes /= Double.parseDouble(exprMultDiv[i + 1]);
                            break;

                        default:
                            break;
                    }
                }
                exprPlusMinus[j] = Double.toString(multDivRes);
            }
        }


        double res = Double.parseDouble(exprPlusMinus[0]);
        for(int i = 1; i < exprPlusMinus.length; i += 2) {
            switch (exprPlusMinus[i]) {

                case "+":
                    res += Double.parseDouble(exprPlusMinus[i + 1]);
                    break;

                case "-":
                    res -= Double.parseDouble(exprPlusMinus[i + 1]);
                    break;

                default:
                    break;
            }
        }

        return res;
    }

}
