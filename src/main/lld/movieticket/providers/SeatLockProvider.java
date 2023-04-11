package main.lld.movieticket.providers;

import main.lld.movieticket.model.Seat;
import main.lld.movieticket.model.Show;

import java.util.List;


public interface SeatLockProvider {

    void lockSeats(Show show, List<Seat> seats, String user);

    void unlockSeats(Show show, List<Seat> seats, String user);

    boolean validateLock(Show show, Seat seat, String user);

    List<Seat> getLockedSeats(final Show show);
}
