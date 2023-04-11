package main.lld.movieticket.services;

import main.lld.movieticket.exceptions.NotFoundException;
import main.lld.movieticket.model.Screen;
import main.lld.movieticket.model.Seat;
import main.lld.movieticket.model.Theatre;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TheatreService {

    private final Map<String, Theatre> theatres;
    private final Map<String, Screen> screens;
    private final Map<String, Seat> seats;

    public TheatreService() {
        this.theatres = new HashMap<>();
        this.screens = new HashMap<>();
        this.seats = new HashMap<>();
    }

    public Theatre createTheatre(final String theatreName) {
        String theatreId = UUID.randomUUID().toString();
        Theatre theatre = new Theatre(theatreId, theatreName);
        theatres.put(theatreId, theatre);
        return theatre;
    }

    public Screen createScreenInTheatre(final String screenName, final Theatre theatre) {
        Screen screen = createScreen(screenName, theatre);
        theatre.addScreen(screen);
        return screen;
    }

    public Seat createSeatInScreen(final Integer rowNo, final Integer seatNo, final Screen screen) {
        String seatId = UUID.randomUUID().toString();
        Seat seat = new Seat(seatId, rowNo, seatNo);
        seats.put(seatId, seat);
        screen.addSeat(seat);
        return seat;
    }

    public Theatre getTheatreById(final String theatreId) {
        if (!theatres.containsKey(theatreId)) {
            throw new NotFoundException("Theatre not found with ID " + theatreId);
        }
        return theatres.get(theatreId);
    }

    public Screen getScreenById(final String screenId) {
        if (!screens.containsKey(screenId)) {
            throw new NotFoundException("Screen not found with ID " + screenId);
        }
        return screens.get(screenId);
    }

    public Seat getSeatById(final String seatId) {
        if (!seats.containsKey(seatId)) {
            throw new NotFoundException("Seat not found with ID " + seatId);
        }
        return seats.get(seatId);
    }

    private Screen createScreen(final String screenName, final Theatre theatre) {
        String screenId = UUID.randomUUID().toString();
        Screen screen = new Screen(screenId, screenName, theatre);
        screens.put(screenId, screen);
        return screen;
    }

}
