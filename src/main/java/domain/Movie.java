package domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;

public class Movie {

    private final boolean adult;
    private final double budget;
    private final int id;
    private final String originalLanguage;
    private final String originalTitle;
    private final String overview;
    private final double popularity;
    private final LocalDate releaseDate;
    private final String status;
    private final String tagline;
    private final String title;
    private final double voteAverage;
    private final int voteCount;
    private final HashSet<String> genres;

    public Movie(final boolean adult,
                 final double budget,
                 final int id,
                 final String originalLanguage,
                 final String originalTitle,
                 final String overview,
                 final double popularity,
                 final LocalDate releaseDate,
                 final String status,
                 final String tagline,
                 final String title,
                 final double voteAverage,
                 final int voteCount,
                 final HashSet<String> genres){

        this.adult = adult;
        this.budget = budget;
        this.id = id;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.popularity = popularity;
        this.releaseDate = releaseDate;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.genres = genres;
    }

    @Override
    public boolean equals(final Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Movie that = (Movie) o;

        return adult == that.adult &&
                budget == that.budget &&
                id == that.id &&
                originalLanguage.equals(that.originalLanguage) &&
                originalTitle.equals(that.originalTitle) &&
                overview.equals(that.overview) &&
                popularity == that.popularity &&
                releaseDate.equals(that.releaseDate) &&
                status.equals(that.status) &&
                tagline.equals(that.tagline) &&
                title.equals(that.title) &&
                voteAverage == that.voteAverage &&
                voteCount == that.voteCount &&
                genres.equals(that.genres);
    }

    @Override
    public int hashCode(){
        return Objects.hash(adult, budget, id, originalLanguage, originalTitle, overview, popularity, releaseDate, status,
                tagline, title, voteAverage, voteCount, genres);
    }

    @Override
    public String toString(){
        return "Adult: " + adult +
                ", Budget: " + budget +
                ", Id: " + id +
                ", Orig Lang: " + originalLanguage +
                ", Orig title: " + originalTitle +
                ", Overview: " + overview +
                ", Popularity: " + popularity +
                ", Release Date: " + releaseDate +
                ", Status: " + status +
                ", Tag line: " + tagline +
                ", Title: " + title +
                ", Avg. vote: " + voteAverage +
                ", Vote count: " + voteCount +
                ", Genres: " + genres.toString();
    }
}
