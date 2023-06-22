package main.lld.meetingscheduler.manager;

import main.lld.meetingscheduler.exception.InvalidTimeException;
import main.lld.meetingscheduler.exception.NoRoomAvailableException;
import main.lld.meetingscheduler.model.Meeting;
import main.lld.meetingscheduler.model.Room;
import main.lld.meetingscheduler.strategy.BookingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingManager {
    private RoomManager roomManager;
    private BookingStrategy bookingStrategy;

    private Map<String, List<Meeting>> bookings;

    public BookingManager(RoomManager roomManager, BookingStrategy bookingStrategy, Map<String, List<Meeting>> bookings) {
        this.roomManager = roomManager;
        this.bookingStrategy = bookingStrategy;
        this.bookings = new HashMap<>();
    }

    public Meeting bookRoom(int startTime , int endTime){
        Meeting meeting = null;

        if (startTime >= endTime) {
            throw new InvalidTimeException("Start time should be less than endTime.");
        }

        List<Room> rooms = roomManager.getRooms();

        for (Room room: rooms) {
            List<Meeting> meetings = this.bookings.getOrDefault(room.getId(),new ArrayList<>());
            meeting = bookingStrategy.book(startTime,endTime,room,meetings);
            if(meeting != null)
                break;
        }

        if(meeting == null){
            throw new NoRoomAvailableException("No room is available for the given time.");
        }
        this.bookings.get(meeting.getRoom().getId()).add(meeting);
        return meeting;
    }

    public List<Meeting> getMeetingForRoom(final Room room) {
        return this.bookings.getOrDefault(room.getId(), new ArrayList<>());
    }
}
