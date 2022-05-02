package domain;

import com.google.gson.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class MovieDataParser {

    public static List<Movie> parse(String location) throws IOException {
        final Path moviePath = Paths.get(location);
        final List<String> entries = Files.readAllLines(moviePath);

        //Remove header row
        entries.remove(0);

        return iterateOverEntries(entries);
    }

    private static List<Movie> iterateOverEntries(List<String> entries){
        ArrayList<Movie> movies = new ArrayList<>();

        for(String currentEntry: entries){
            movies.add(parseLineColumns(currentEntry));
        }

        return movies;
    }

    private static Movie parseLineColumns(String singleLine){

        final String[] columns = singleLine.split("\\|");

        final String strAdult = columns[0];
        Boolean isAdult = false;
        if(strAdult.equals("True")) isAdult = true;

        final double budget = Double.parseDouble(columns[2]);
        final int id = Integer.parseInt(columns[5]);
        final String originalLanguage = columns[7];
        final String originalTitle = columns[8];
        final String overview = columns[9];
        final double popularity = Double.parseDouble(columns[10]);
        final LocalDate releaseDate = LocalDate.parse(columns[14]);
        final String status = columns[18];
        final String tagline = columns[19];
        final String title = columns[20];
        final double voteAverage = Double.parseDouble(columns[22]);
        final int voteCount = Integer.parseInt(columns[23]);

        final HashSet<String> genres = getGenres(columns[3]);

        return new Movie(isAdult, budget, id, originalLanguage, originalTitle, overview, popularity, releaseDate,
                status, tagline, title, voteAverage, voteCount,genres);
    }

    private static HashSet<String> getGenres(String genreJSON){

        HashSet<String> genres = new HashSet<>();

        JsonArray genreArray = JsonParser.parseString(genreJSON).getAsJsonArray();
        for(int i = 0; i < genreArray.size(); i++){
            genres.add(genreArray.get(i).getAsJsonObject().get("name").toString().replace("\"", ""));

        }

        return genres;
    }
}
