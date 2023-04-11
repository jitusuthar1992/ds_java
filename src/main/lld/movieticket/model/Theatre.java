package main.lld.movieticket.model;


import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private final String id;
    private final String name;
    private final List<Screen> screens;

    public Theatre(final String id, final String name) {
        this.id = id;
        this.name = name;
        this.screens = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void addScreen(final Screen screen) {
        this.screens.add(screen);
    }

}
