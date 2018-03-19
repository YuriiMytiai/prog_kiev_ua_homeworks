package homework5.task1;

public class StandartTariff implements Tariff {
    private final int distance;
    private final int duration;

    public StandartTariff(int distance, int duration) {
        this.distance = distance;
        this.duration = duration;
    }

    @Override
    public long calculatePrice(Ride ride) {
        return 30 + 5 * distance + 2 * duration;
    }
}
