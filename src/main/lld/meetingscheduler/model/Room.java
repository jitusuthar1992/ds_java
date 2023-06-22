package main.lld.meetingscheduler.model;

import java.util.UUID;

public class Room {
    private final  String id;
    private final String name ;

    public Room(final String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
