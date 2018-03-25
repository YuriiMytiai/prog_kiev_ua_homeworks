package homework6.task2;

import java.time.LocalTime;

public class FlightInfo {
    private final String id;
    private final String dispatchPlace;
    private final String arrivalPlace;
    private final LocalTime dispatchTime;
    private final int placeNumber;
    private final long price;

    public FlightInfo(String id, String dispatchPlace, String arrivalPlace, LocalTime dispatchTime, int placeNumber, long price) {
        this.id = id;
        this.dispatchPlace = dispatchPlace;
        this.arrivalPlace = arrivalPlace;
        this.dispatchTime = dispatchTime;
        this.placeNumber = placeNumber;
        this.price = price;
    }

    public long getPrice() {
        return price;
    }
}
