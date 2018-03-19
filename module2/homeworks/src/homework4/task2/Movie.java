package homework4.task2;

public class Movie {
    private final String title;
    private final int year;
    private final int length; // in minutes
    private final String description;

    public Movie(String title, int year, int length, String description) {
        this.title = title;
        this.year = year;
        this.length = length;
        this.description = description;
    }
}
