package homework4.task2;

import java.time.LocalDateTime;

public class MovieSession {
    private final Movie movie;
    private final HallForSession hall;
    private final long ticketPrice;
    private final LocalDateTime timeOfStart;

    public MovieSession(Movie movie, HallForSession hall, long ticketPrice, LocalDateTime timeOfStart) {
        this.movie = movie;
        this.hall = hall;
        this.ticketPrice = ticketPrice;
        this.timeOfStart = timeOfStart;
    }

    public long getAmount() {
        return ticketPrice * hall.getSummBooked();
    }

    public HallForSession getHall() {
        return hall;
    }
}
