import domain.MovieAnalyzer;
import domain.MovieDataParser;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class LookAtSelectedMovies {

    public static void main(String args[]) throws IOException {
        MovieAnalyzer ma = new MovieAnalyzer(MovieDataParser.parse("src/main/resources/movies_piped.psv"));

        ma.getGenreCount().entrySet().stream()
                .sorted(Collections.reverseOrder(comparingByValue()))
                .forEach(System.out::println);


    }
}
