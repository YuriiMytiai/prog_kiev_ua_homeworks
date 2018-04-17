package homework10.task2;

import java.util.*;

public class MapMovieYearFinder implements MovieYearFinder {

    private final TreeMap<Integer, ArrayList<Movie>> movies = new TreeMap<>();

    @Override
    public void add(Movie movie) {
        int key = movie.getYear();
        if (movies.containsKey(key)) {
            ArrayList<Movie> moviesByYear = movies.get(key);
            moviesByYear.add(movie);
            movies.replace(key, moviesByYear);

        }
        else {
            ArrayList<Movie> newMoviesList = new ArrayList<>();
            newMoviesList.add(movie);
            movies.put(key, newMoviesList);
        }
    }

    @Override
    public List<Movie> findByReleaseYear(int releaseYear) {
        if (!movies.containsKey(releaseYear)) return new ArrayList<>();  // cause of user interface
        return movies.get(releaseYear);
    }

    @Override
    public List<Movie> findByReleaseYears(int minReleaseYear, int maxReleaseYear) {
        SortedMap<Integer, ArrayList<Movie>> sortedMovies = movies.subMap(minReleaseYear, maxReleaseYear);
        List<Movie> moviesList = new ArrayList<Movie>();
        sortedMovies.forEach((y, m) -> moviesList.addAll(m));
        return moviesList;
    }
}
