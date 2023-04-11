package main.lld.movieticket.services;

import main.lld.movieticket.exceptions.BadRequestException;
import main.lld.movieticket.exceptions.NotFoundException;
import main.lld.movieticket.exceptions.SeatPermanentlyUnavailableException;
import main.lld.movieticket.model.Booking;
import main.lld.movieticket.model.Seat;
import main.lld.movieticket.model.Show;
import main.lld.movieticket.providers.SeatLockProvider;

import java.util.*;
import java.util.stream.Collectors;

public class BookingService {

    private final Map<String, Booking> showBookings;
    private final SeatLockProvider seatLockProvider;

    public BookingService(SeatLockProvider seatLockProvider) {
        this.seatLockProvider = seatLockProvider;
        this.showBookings = new HashMap<>();
    }

    public Booking getBooking(final String bookingId) {
        if (!showBookings.containsKey(bookingId)) {
            throw new NotFoundException("Booking not found with Id " + bookingId);
        }
        return showBookings.get(bookingId);
    }

    public List<Booking> getAllBookings(final Show show) {
        List<Booking> bookings = new ArrayList<>();
        for (Booking booking : showBookings.values()) {
            if (booking.getShow().equals(show)) {
                bookings.add(booking);
            }
        }
        return bookings;
    }

    public List<Seat> getBookedSeats(final Show show) {
        return getAllBookings(show).stream()
                .filter(Booking::isConfirmed)
                .map(Booking::getSeatsBooked)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

    }

    private boolean isAnySeatAlreadyBooked(final Show show, final List<Seat> seats) {
        final List<Seat> bookedSeats = getBookedSeats(show);
        for (Seat seat : seats) {
            if (bookedSeats.contains(seat)) {
                return true;
            }
        }
        return false;
    }

    public Booking createBooking(final String userId, final Show show, final List<Seat> seats) {
        if (isAnySeatAlreadyBooked(show, seats)) {
            throw new SeatPermanentlyUnavailableException();
        }
        seatLockProvider.lockSeats(show, seats, userId);
        final String bookedId = UUID.randomUUID().toString();
        final Booking booking = new Booking(bookedId, show, seats, userId);
        showBookings.put(bookedId, booking);
        return booking;
    }

    public void confirmBooking(final Booking booking, final String user) {
        if (!booking.getUser().equals(user)) {
            throw new BadRequestException();
        }
        for (Seat seat : booking.getSeatsBooked()) {
            if (!seatLockProvider.validateLock(booking.getShow(), seat, user)) {
                throw new BadRequestException();
            }
        }
        booking.confirmBooking();
    }
}
