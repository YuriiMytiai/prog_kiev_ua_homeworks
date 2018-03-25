package homework7;

public class AccountRunner {
    public static void main(String[] args) {

        Account account = new RandomAccount(0.2, 0.3, 0.4);

        Account connecionRetry = new ConnectionRetryAccount(account, 5);


        try {
            connecionRetry.withdraw(10);
        } catch (AccountException e) {
            System.out.println("\t" + e.getMessage());
        }

        System.out.println("\n\n---------------------------");

        try {
            connecionRetry.withdraw(10);
        } catch (AccountException e) {
            System.out.println("\t" + e.getMessage());
        }

        System.out.println("\n\n---------------------------");

        try {
            connecionRetry.withdraw(10);
        } catch (AccountException e) {
            System.out.println("\t" + e.getMessage());
        }

        System.out.println("\n\n---------------------------");

        try {
            connecionRetry.withdraw(10);
        } catch (AccountException e) {
            System.out.println( "\t" + e.getMessage());
        }
    }
}
