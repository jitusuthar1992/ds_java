package main.lld.movieticket.services;

import main.lld.movieticket.model.Seat;
import main.lld.movieticket.model.Show;
import main.lld.movieticket.providers.SeatLockProvider;

import java.util.ArrayList;
import java.util.List;

public class SeatAvailabilityService {

    private final BookingService bookingService;
    private final SeatLockProvider seatLockProvider;

    public SeatAvailabilityService(final BookingService bookingService, final SeatLockProvider seatLockProvider) {
        this.bookingService = bookingService;
        this.seatLockProvider = seatLockProvider;
    }

    public List<Seat> getAvailableSeats(final Show show) {
        final List<Seat> allSeats = show.getScreen().getSeats();
        final List<Seat> unavailableSeats = getUnAvailableSeats(show);

        final List<Seat> availableSeats = new ArrayList<>(allSeats);
        availableSeats.removeAll(unavailableSeats);
        return availableSeats;
    }

    private List<Seat> getUnAvailableSeats(final Show show) {
        List<Seat> unavailableSeats = bookingService.getBookedSeats(show);
        unavailableSeats.removeAll(seatLockProvider.getLockedSeats(show));
        return unavailableSeats;
    }
}
