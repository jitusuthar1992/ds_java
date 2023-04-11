package main.lld.movieticket.controller;

import main.lld.movieticket.model.Screen;
import main.lld.movieticket.model.Theatre;
import main.lld.movieticket.services.TheatreService;

public class TheatreController {

    private final TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    public String createTheatre(final String theatreName) {
        return this.theatreService.createTheatre(theatreName).getId();
    }

    public String createScreenInTheatre(final String screenName, final String threatreId) {
        final Theatre theatre = this.theatreService.getTheatreById(threatreId);
        return this.theatreService.createScreenInTheatre(screenName, theatre).getId();
    }

    public String createSeatInScreen(final Integer rowNo, final Integer seatNo, final String screenId) {
        final Screen screen = this.theatreService.getScreenById(screenId);
        return this.theatreService.createSeatInScreen(rowNo, seatNo, screen).getId();
    }
}
