package main.lld.movieticket.services;

import main.lld.movieticket.exceptions.NotFoundException;
import main.lld.movieticket.exceptions.ScreenAlreadyOccupiedException;
import main.lld.movieticket.model.Movie;
import main.lld.movieticket.model.Screen;
import main.lld.movieticket.model.Show;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ShowService {

    private final Map<String, Show> shows;

    public ShowService() {
        this.shows = new HashMap<>();
    }

    public Show createShow(final Screen screen, final Movie movie, final Date startTime, final Integer
            durationInSeconds) {
        if (!checkIfShowCreationAllowed(screen, startTime, durationInSeconds)) {
            throw new ScreenAlreadyOccupiedException();
        }
        String showId = UUID.randomUUID().toString();
        final Show show = new Show(showId, movie, screen, startTime, durationInSeconds);
        this.shows.put(showId, show);
        return show;
    }

    private boolean checkIfShowCreationAllowed(final Screen screen, final Date startTime, final Integer durationInSeconds) {
        // TODO: Implement this. This method will return whether the screen is free at a particular time for
        // specific duration. This function will be helpful in checking whether the show can be scheduled in that slot
        // or not.
        return true;
    }

    public Show getShow(final String showId) {
        if (!shows.containsKey(showId)) {
            throw new NotFoundException("Show not found with Id " + showId);
        }
        return shows.get(showId);
    }
}
