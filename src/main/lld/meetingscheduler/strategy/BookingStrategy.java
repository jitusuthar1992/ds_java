package main.lld.meetingscheduler.strategy;

import main.lld.meetingscheduler.model.Meeting;
import main.lld.meetingscheduler.model.Room;

import java.util.List;

public interface BookingStrategy {
    Meeting book(int startTime, int endTime, Room room, List<Meeting> meetings);
}
