package main.lld.movieticket.model;

import main.lld.movieticket.exceptions.InvalidStateException;

import java.util.List;

public class Booking {
    private final String id;
    private final Show show;
    private final List<Seat> seatsBooked;
    private final String user;
    private BookingStatus bookingStatus;

    public Booking(final String id, final Show show, final List<Seat> seatsBooked, final String user) {
        this.id = id;
        this.show = show;
        this.seatsBooked = seatsBooked;
        this.user = user;
        this.bookingStatus = BookingStatus.CREATED;
    }

    public String getId() {
        return id;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getSeatsBooked() {
        return seatsBooked;
    }

    public String getUser() {
        return user;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public boolean isConfirmed() {
        return this.bookingStatus == BookingStatus.CONFIRMED;
    }

    public void confirmBooking() {
        if (this.bookingStatus != BookingStatus.CREATED) {
            throw new InvalidStateException();
        }
        this.bookingStatus = BookingStatus.CONFIRMED;
    }

    public void expireBooking() {
        if (this.bookingStatus != BookingStatus.CREATED) {
            throw new InvalidStateException();
        }
        this.bookingStatus = BookingStatus.EXPIRED;
    }

}
