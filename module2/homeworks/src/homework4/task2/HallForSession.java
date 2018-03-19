package homework4.task2;

public class HallForSession {

    private final boolean[][] seats;

    public HallForSession(int rows, int seats) {
        this.seats = new boolean[rows][seats];
    }

    public void bookSeat(int row, int seat) {
        if ((row > seats.length) || (seat > seats[0].length)) throw new IllegalArgumentException("Seat does not exist!");
        row--; // cause numeration of seat starts from 1, but array indexing starts form 0
        seat--;
        if (seats[row][seat]) throw new IllegalArgumentException("This seat is already booked!");

        seats[row][seat] = true;
    }

    public int getSummBooked() {
        int sum = 0;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                sum += (seats[i][j]) ? 1 : 0;
            }
        }

        return sum;
    }

    public int getSummFree() {
        int sum = seats.length * seats[0].length;
        return sum - getSummBooked();
    }
}
