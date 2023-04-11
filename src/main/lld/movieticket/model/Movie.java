package main.lld.movieticket.model;

public class Movie {
    private final String id;
    private final String name;

    public Movie(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
