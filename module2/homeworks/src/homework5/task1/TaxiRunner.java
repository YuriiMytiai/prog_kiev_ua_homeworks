package homework5.task1;

public class TaxiRunner {

    public static void main(String[] args) {
        RiderHistory user1 = new RiderHistory();

        Ride ride1 = new Ride(2, 10, 30, new StandartTariff(10, 30));
        Ride ride2 = new Ride(2, 20, 50, new StandartTariff(20, 50));

        Ride ride3 = new Ride(2, 10, 30, new FamilyTariff(2,10));
        Ride ride4 = new Ride(2, 20, 50, new FamilyTariff(2, 20));

        user1.addRide(ride1);
        user1.addRide(ride2);
        user1.addRide(ride3);
        user1.addRide(ride4);

        System.out.println(user1.getTotalPrice()); //140 + 230 + 150 + 250 = 770

    }


}
