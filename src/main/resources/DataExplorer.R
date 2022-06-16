library(readr)
library(jsonlite)
library(stringr)

wd <- "~/repos/learnjava/Movies/src/main/resources/"
credits <- read_csv(str_c(wd, "credits.csv"))
keywords <- read_csv(str_c(wd, "keywords.csv"))
movies <- read_csv(str_c(wd, "movies_metadata.csv"))
ratings <- read_csv(str_c(wd, "ratings.csv"))

write_delim(credits, 
            str_c(wd, "credits_piped.psv"), 
            delim = "|")

write_delim(keywords, 
            str_c(wd, "keywords_piped.psv"), 
            delim = "|")

write_delim(movies, 
            str_c(wd, "movies_piped.psv"), 
            delim = "|")

write_delim(ratings, 
            str_c(wd, "ratingsPiped.psv"),
            delim = "|")
