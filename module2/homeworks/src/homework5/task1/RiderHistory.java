package homework5.task1;

import java.util.ArrayList;

public class RiderHistory {

    private final ArrayList<Ride> rides = new ArrayList<>();

    public void addRide(Ride ride) { rides.add(ride);}

    public long getTotalPrice() {
        long sum = 0;
        for (Ride curRide:rides) {
            sum += curRide.getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "RiderHistory{" +
                "rides=" + rides +
                '}';
    }
}
