package homework7;

public class RandomAccount implements Account {
    private final double notEnoughFundsProbability;
    private final double accountExpiredProbability;
    private final double lostConnectionProbability;

    public RandomAccount(double accountExpiredProbability,
            double notEnoughFundsProbability,
            double lostConnectionProbability) {
        this.notEnoughFundsProbability = notEnoughFundsProbability;
        this.accountExpiredProbability = accountExpiredProbability;
        this.lostConnectionProbability = lostConnectionProbability;
    }

    @Override
    public void withdraw(long money) throws AccountException {
        double rnd = Math.random();

        double p0 = notEnoughFundsProbability;
        double p1 = p0 + accountExpiredProbability;
        double p2 = p1 + lostConnectionProbability;

        if (rnd <= p0){
            System.out.println("will throw not enough founds exception");
            throw new NotEnoughFundsException("Not enough founds");
        }
        else if ((rnd > p0) && (rnd <= p1)) {
            System.out.println("will throw account expired exception");
            throw new AccountExpiredException("Account expired");
        }
        else if ((rnd > p1) && (rnd <= p2)) {
            System.out.println("will retry to connect");
            throw new AccountConnectionException("No connection");
        }
        else return;
    }
}

