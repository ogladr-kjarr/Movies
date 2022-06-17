package domain;

import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;

@NoArgsConstructor
@AllArgsConstructor
@Data public class Movie {
    private boolean adult;
    private double budget;
    private int id;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private double popularity;
    private LocalDate releaseDate;
    private int revenue;
    private int runtime;
    private String status;
    private String tagline;
    private String title;
    private double voteAverage;
    private int voteCount;
    private HashSet<String> genres;
}
