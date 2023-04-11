package main.lld.movieticket.services;

import main.lld.movieticket.exceptions.BadRequestException;
import main.lld.movieticket.model.Booking;
import main.lld.movieticket.providers.SeatLockProvider;

import java.util.HashMap;
import java.util.Map;

public class PaymentsService {

    Map<Booking, Integer> bookingFailures;
    private final Integer allowedRetries;

    private final SeatLockProvider seatLockProvider;


    public PaymentsService(Integer allowedRetries,SeatLockProvider seatLockProvider) {
        this.allowedRetries = allowedRetries;
        this.bookingFailures = new HashMap<>();
        this.seatLockProvider = seatLockProvider;
    }

    public void processPaymentFailed(final Booking booking, final String user) {
        if(!booking.getUser().equals(user)){
            throw new BadRequestException();
        }
        if(!bookingFailures.containsKey(booking)){
            bookingFailures.put(booking,0);
        }
        final Integer currentFailuresCount = bookingFailures.get(booking);
        final Integer newFailuresCount = currentFailuresCount + 1;
        bookingFailures.put(booking, newFailuresCount);
        if (newFailuresCount > allowedRetries) {
            seatLockProvider.unlockSeats(booking.getShow(), booking.getSeatsBooked(), booking.getUser());
        }
    }
}
