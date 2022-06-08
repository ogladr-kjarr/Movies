package domain;

import com.google.gson.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class MovieDataParser {

    public static List<Movie> parse(final String location) throws IOException {
        final Path moviePath = Paths.get(location);
        final List<String> entries = Files.readAllLines(moviePath);

        //Remove header row
        entries.remove(0);

        return iterateOverEntries(entries);
    }

    private static List<Movie> iterateOverEntries(final List<String> entries){
        ArrayList<Movie> movies = new ArrayList<>();

        for(String currentEntry: entries){
            Optional<Movie> currentMovie = parseLineColumns(currentEntry);
            if(currentMovie.isPresent()){
                movies.add(currentMovie.get());
            }
        }

        return movies;
    }

    private static Optional<Movie> parseLineColumns(final String singleLine){

        final String[] columns = singleLine.split("\\|");

        try{
            final boolean isAdult = checkAdult(columns[0]);
            final double budget = Double.parseDouble(columns[2]);
            final int id = Integer.parseInt(columns[5]);
            final String originalLanguage = columns[7];
            final String originalTitle = columns[8];
            final String overview = columns[9];
            final double popularity = Double.parseDouble(columns[10]);
            final LocalDate releaseDate = LocalDate.parse(columns[14]);
            final int revenue = Integer.parseInt(columns[15]);
            final int runtime = Integer.parseInt(columns[16]);
            final String status = columns[18];
            final String tagline = columns[19];
            final String title = columns[20];
            final double voteAverage = Double.parseDouble(columns[22]);
            final int voteCount = Integer.parseInt(columns[23]);
            final HashSet<String> genres = getGenres(columns[3]);

            return Optional.of(new Movie(isAdult, budget, id, originalLanguage, originalTitle, overview, popularity, releaseDate,
                    revenue, runtime, status, tagline, title, voteAverage, voteCount,genres));

        }catch (ArrayIndexOutOfBoundsException | NumberFormatException | DateTimeParseException e){
            // The above exceptions can be caused by: wrong number of columns, NA in a numeric filed, or invalid date
            // format. Rather than try and recover from these records with issues, they are dropped.
            return Optional.empty();
        }
    }

    private static boolean checkAdult(final String adultFlag){

        return adultFlag.equals("True");
    }

    private static HashSet<String> getGenres(final String genreJSON){

        HashSet<String> genres = new HashSet<>();

        JsonArray genreArray = JsonParser.parseString(genreJSON).getAsJsonArray();
        for(int i = 0; i < genreArray.size(); i++){
            genres.add(genreArray.get(i).getAsJsonObject().get("name").toString().replace("\"", ""));

        }

        return genres;
    }
}
