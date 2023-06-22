package main.lld.meetingscheduler.model;

import java.util.UUID;

public class Meeting {
    private final String id;
    private int startTime ;
    private int endTime;
    private Room room;


    public Meeting(int startTime, int endTime, Room room) {
        this.id = UUID.randomUUID().toString();
        this.startTime = startTime;
        this.endTime = endTime;
        this.room = room;
    }

    public String getId() {
        return id;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public Room getRoom() {
        return room;
    }
}
