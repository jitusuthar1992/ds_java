package main.lld.movieticket.providers;

import main.lld.movieticket.model.Seat;
import main.lld.movieticket.model.Show;

import java.time.Instant;
import java.util.Date;

public class SeatLock {
    private Seat seat;
    private Show show;
    private Integer timeoutInSeconds;
    private Date lockTime;
    private String lockedBy;

    public SeatLock(Seat seat, Show show, Integer timeoutInSeconds, Date lockTime, String lockedBy) {
        this.seat = seat;
        this.show = show;
        this.timeoutInSeconds = timeoutInSeconds;
        this.lockTime = lockTime;
        this.lockedBy = lockedBy;
    }

    public Seat getSeat() {
        return seat;
    }

    public Show getShow() {
        return show;
    }

    public Integer getTimeoutInSeconds() {
        return timeoutInSeconds;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public String getLockedBy() {
        return lockedBy;
    }

    public boolean isLockExpired() {
        final Instant lockInstant = lockTime.toInstant().plusSeconds(timeoutInSeconds);
        final Instant currentInstant = new Date().toInstant();
        return lockInstant.isBefore(currentInstant);
    }
}
