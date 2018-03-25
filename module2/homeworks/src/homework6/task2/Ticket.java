package homework6.task2;

public class Ticket {
    private final int number;
    private final PassengerInfo passenger;
    private final FlightInfo flight;

    public Ticket(int number, PassengerInfo passenger, FlightInfo flight) {
        this.number = number;
        this.passenger = passenger;
        this.flight = flight;
    }

    public long getPrice() {
        return flight.getPrice();
    }
}
