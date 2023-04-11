package main.lld.movieticket.model;

import java.util.Date;
import java.util.Objects;

public class Show {
    private final String id;
    private final Movie movie;
    private final Screen screen;
    private final Date startTime;
    private final Integer durationInSeconds;

    public Show(final String id, final Movie movie, final Screen screen, final Date startTime, final Integer durationInSeconds) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.durationInSeconds = durationInSeconds;
    }

    public String getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Integer getDurationInSeconds() {
        return durationInSeconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Show show = (Show) o;
        return Objects.equals(id, show.id) && Objects.equals(movie, show.movie) && Objects.equals(screen, show.screen) && Objects.equals(startTime, show.startTime) && Objects.equals(durationInSeconds, show.durationInSeconds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movie, screen, startTime, durationInSeconds);
    }
}
