package homework4.task2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CinemaRunner {
    public static void main(String[] args) {

        String descr = "Американський супергеройський фільм, заснований на однойменних коміксах видавництва Marvel Comics";
        Movie movie1 = new Movie("Black Panther", 2018, 134, descr);
        HallForSession redHall = new HallForSession(12,30);

        LocalDateTime time = LocalDateTime.of(LocalDate.of(2018, 3, 19), LocalTime.of(20,15));
        MovieSession session1 = new MovieSession(movie1, redHall, 100, time);

        session1.getHall().bookSeat(2, 5);
        session1.getHall().bookSeat(6, 20);
        session1.getHall().bookSeat(10, 20);
        session1.getHall().bookSeat(12, 20);
        session1.getHall().bookSeat(1, 12);
        try{
            session1.getHall().bookSeat(1, 12);  // this seat is already booked
        } catch (IllegalArgumentException ex) { ex.printStackTrace(); }

        try{
            session1.getHall().bookSeat(1, 31);  // this seat doesn't exist
        } catch (IllegalArgumentException ex) { ex.printStackTrace(); }

        System.out.println(session1.getAmount()); // 5 * 100 = 500

        System.out.println(session1.getHall().getSummFree()); // 12 * 30 - 5 = 355

    }
}
