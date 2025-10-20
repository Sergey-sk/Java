package PR_9;

import java.util.ArrayList;
import java.util.List;

public class MovieService {
    private List<Movie> movies = new ArrayList<>();

    public MovieService() {
        movies.add(new Movie("Матрица", "фантастика", 299));
        movies.add(new Movie("Крепкий орешек", "боевик", 199));
        movies.add(new Movie("Комедия", "комедия", 149));
    }

    public List<Movie> getMoviesByGenre(String genre){
        return movies.stream()
                .filter(movie -> movie.getGenre().equals(genre))
                .toList();
    }

    public List<Movie> getAllMovies(){
        return movies;
    }
}
