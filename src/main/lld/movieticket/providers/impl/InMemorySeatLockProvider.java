package main.lld.movieticket.providers.impl;

import main.lld.movieticket.exceptions.SeatTemporaryUnavailableException;
import main.lld.movieticket.model.Seat;
import main.lld.movieticket.model.Show;
import main.lld.movieticket.providers.SeatLock;
import main.lld.movieticket.providers.SeatLockProvider;

import java.util.*;

public class InMemorySeatLockProvider implements SeatLockProvider {

    private final Integer lockTimeout; // Bonus feature.

    private final Map<Show, Map<Seat, SeatLock>> seatLocks;

    public InMemorySeatLockProvider(Integer lockTimeout) {
        this.lockTimeout = lockTimeout;
        this.seatLocks = new HashMap<>();
    }

    @Override
    public synchronized void lockSeats(final Show show, final List<Seat> seats, final String user) {
        for (Seat seat : seats) {
            if (isSeatLocked(show, seat)) {
                throw new SeatTemporaryUnavailableException();
            }
        }
        for (Seat seat : seats) {
            lockSeat(show, seat, user, lockTimeout);
        }
    }

    private void lockSeat(final Show show, final Seat seat, final String user, final Integer lockTimeout) {
        if (!seatLocks.containsKey(show)) {
            seatLocks.put(show, new HashMap<>());
        }
        final SeatLock lock = new SeatLock(seat, show, lockTimeout, new Date(), user);
        seatLocks.get(show).put(seat, lock);
    }

    private boolean isSeatLocked(final Show show, final Seat seat) {
        return seatLocks.containsKey(show) && seatLocks.get(show).containsKey(seat) &&
                !seatLocks.get(show).get(seat).isLockExpired();
    }

    @Override
    public void unlockSeats(final Show show, final List<Seat> seats, final String user) {
        for (Seat seat : seats) {
            if (validateLock(show, seat, user)) {
                unlockSeat(show, seat);
            }
        }
    }

    private void unlockSeat(final Show show, final Seat seat) {
        if (!seatLocks.containsKey(show)) {
            return;
        }
        seatLocks.get(show).remove(seat);
    }

    @Override
    public boolean validateLock(final Show show, final Seat seat, final String user) {
        return isSeatLocked(show, seat) && seatLocks.get(show).get(seat).getLockedBy().equals(user);
    }

    @Override
    public List<Seat> getLockedSeats(final Show show) {
        final List<Seat> lockedSeats = new ArrayList<>();
        if (!seatLocks.containsKey(show)) {
            return lockedSeats;
        }
        for (Seat seat : seatLocks.get(show).keySet()) {
            if (isSeatLocked(show, seat)) {
                lockedSeats.add(seat);
            }
        }
        return lockedSeats;
    }
}
