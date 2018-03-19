package homework5.task1;

public class FamilyTariff implements Tariff {
    private final int passengers;
    private final int distance;

    public FamilyTariff(int passengers, int distance) {
        this.passengers = passengers;
        this.distance = distance;
    }


    @Override
    public long calculatePrice(Ride ride) {
        return 50 + 20 * distance / passengers;
    }
}
