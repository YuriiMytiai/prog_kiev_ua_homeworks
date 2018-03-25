package homework6.task2;

public class VipTicket extends Ticket {

    private final Baggage baggage;
    private final Meal meaal;

    public VipTicket(int number, PassengerInfo passenger, FlightInfo flight, Baggage baggage, Meal meaal) {
        super(number, passenger, flight);
        this.baggage = baggage;
        this.meaal = meaal;
    }

    @Override
    public long getPrice() {
        return super.getPrice() + calcAdditionalPrice();
    }

    private long calcAdditionalPrice() {
        return baggage.getBaggagePrice() + meaal.getMealPrice();
    }
}
