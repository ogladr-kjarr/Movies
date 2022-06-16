package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public record Movie(boolean adult,
                    double budget,
                    int id,
                    String originalLanguage,
                    String originalTitle,
                    String overview,
                    double popularity,
                    LocalDate releaseDate,
                    int revenue,
                    int runtime,
                    String status,
                    String tagline,
                    String title,
                    double voteAverage,
                    int voteCount,
                    HashSet<String> genres){ }
