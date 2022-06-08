import domain.Movie;
import domain.MovieDataParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

public class TestMovieCSVParsing {

    @Test
    public void testMovieCSVParse() throws IOException {

        //The first movie in the movies_metadata.csv file
        Movie testMovie = new Movie(
                false,
                30000000,
                862,
                "en",
                "Toy Story",
                "Led by Woody, Andy's toys live happily in his room until Andy's birthday brings Buzz Lightyear onto the scene. Afraid of losing his place in Andy's heart, Woody plots against Buzz. But when circumstances separate Buzz and Woody from their owner, the duo eventually learns to put aside their differences.",
                21.946943,
                LocalDate.parse("1995-10-30"),
                373554033,
                81,
                "Released",
                "NA",
                "Toy Story",
                7.7,
                5415,
                new HashSet<String>(Arrays.asList("Animation", "Comedy", "Family")));

        Movie parsedMovie = MovieDataParser.parse("src/test/resources/movies_piped.psv").get(0);

        Assert.assertEquals(testMovie, parsedMovie);
    }
}

