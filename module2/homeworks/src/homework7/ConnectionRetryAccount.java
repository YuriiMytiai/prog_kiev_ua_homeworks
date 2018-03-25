package homework7;

public class ConnectionRetryAccount implements Account {
    private final Account account;
    private final int retries;

    public ConnectionRetryAccount(Account account, int retries) {
        this.account = account;
        this.retries = retries;
    }

    @Override
    public void withdraw(long money) throws AccountException {
        tryWithdraw(money, retries);
        System.out.println("Successful  call of Withdraw");
    }

    private void tryWithdraw(long money, int retriesCounter) throws AccountException {
        try {
            account.withdraw(money);
        } catch (AccountConnectionException ex) {
            if (retriesCounter > 0) {
                retriesCounter--;
                tryWithdraw(money, retriesCounter);
            }
        }
    }
}

