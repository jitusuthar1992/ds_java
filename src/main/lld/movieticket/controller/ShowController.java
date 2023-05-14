package main.lld.movieticket.controller;

import main.lld.movieticket.model.Movie;
import main.lld.movieticket.model.Screen;
import main.lld.movieticket.model.Seat;
import main.lld.movieticket.model.Show;
import main.lld.movieticket.services.MovieService;
import main.lld.movieticket.services.SeatAvailabilityService;
import main.lld.movieticket.services.ShowService;
import main.lld.movieticket.services.TheatreService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ShowController {

    private final TheatreService theatreService;
    private final MovieService movieService;
    private final ShowService showService;
    private final SeatAvailabilityService seatAvailabilityService;

    public ShowController(TheatreService theatreService, MovieService movieService, ShowService showService, SeatAvailabilityService seatAvailabilityService) {
        this.theatreService = theatreService;
        this.movieService = movieService;
        this.showService = showService;
        this.seatAvailabilityService = seatAvailabilityService;
    }


    public String createShow(final String screenId, final String movieId, final Date startTime,
                             final Integer durationInSeconds) {
        Screen screen = theatreService.getScreenById(screenId);
        Movie movie = movieService.getMovieById(movieId);
        return showService.createShow(screen, movie, startTime, durationInSeconds).getId();
    }

    public List<String> getAvailableSeats(final String showId) {
        final Show show = showService.getShow(showId);
        final List<Seat> availableSeats = seatAvailabilityService.getAvailableSeats(show);
        return availableSeats.stream().map(Seat::getId).collect(Collectors.toList());
    }
}
