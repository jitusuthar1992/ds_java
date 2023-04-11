package main.lld.movieticket.controller;

import main.lld.movieticket.services.MovieService;

public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public String createMovie(final String movieName) {
        return this.movieService.createMovie(movieName).getId();
    }
}
