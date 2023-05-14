package main.lld.movieticket.services;

import main.lld.movieticket.exceptions.NotFoundException;
import main.lld.movieticket.model.Movie;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MovieService {

    private final Map<String, Movie> movies;


    public MovieService() {
        movies = new HashMap<>();
    }

    public Movie createMovie(final String movieName) {
        String movieId = UUID.randomUUID().toString();
        Movie movie = new Movie(movieId, movieName);
        movies.put(movieId,movie);
        return movie;
    }

    public Movie getMovieById(final String movieId) {
        if (!movies.containsKey(movieId)) {
            throw new NotFoundException("Movie not found with Id " + movieId);
        }
        return movies.get(movieId);
    }
}
