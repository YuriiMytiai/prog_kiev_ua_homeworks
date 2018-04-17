package homework10.task2;

public class Movie {
    private final String name;
    private final int year;
    private final Genre genre;

    public Movie(String name, int year, Genre genre) {
        this.name = name;
        this.year = year;
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", genre=" + genre +
                '}';
    }
}
