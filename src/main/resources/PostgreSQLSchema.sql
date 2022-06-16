create table movies(
    id int primary key,
    adult boolean,
    budget double precision,
    originalLanguage varchar,
    originalTitle varchar,
    overview varchar,
    popularity double precision,
    releaseDate date,
    revenue int,
    runtime int,
    status varchar,
    tagline varchar,
    title varchar,
    voteAverage double precision,
    voteCount int
);

create table movie_genres(
    id int references movies(id),
    genre varchar,
    primary key (id, genre)
);