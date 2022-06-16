package domain;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieAnalyzer {

    private final List<Movie> movies;

    public MovieAnalyzer(final List<Movie> movies){
        this.movies = movies;
    }

    public List<Movie> moviesWithRuntimeGreaterThan(final int runtime){
        return filterIntVariable(x -> x.runtime() > runtime);
    }

    public List<Movie> moviesWithRevenueGreaterThan(final int revenue){
        return filterIntVariable(x -> x.revenue() > revenue);
    }

    private List<Movie> filterIntVariable(Predicate<Movie> movieFilter){
        return movies.stream().filter(movieFilter).collect(Collectors.toList());
    }

    public List<Movie> getAdultRatedMovies(){
        return movies.stream().filter(Movie::adult).collect(Collectors.toList());
    }

    public List<Movie> getMoviesWithGenre(final String targetGenre){
        return movies.stream().filter(x -> x.genres().contains(targetGenre)).collect(Collectors.toList());
    }

    public Map<String, Long> getGenreCount(){
         return movies.stream()
                .flatMap(x -> x.genres().stream())
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()));

    }
}
