package main.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivitySelection {

    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static int getNoOfMeetings(List<Meeting> meetings){
        Collections.sort(meetings, (first, second) -> {
            if(first.end == second.end)
                return first.start - second.start;
            return first.end - second.end;
        });

        int i =0,j=1,c=1;
        while (j<meetings.size()){
            Meeting first = meetings.get(i);
            Meeting second = meetings.get(j);
            if(first.end < second.start){
                i=j;
                j++;
                c++;
            }else {
                j++;
            }
        }
        return c;
    }

    public static void main(String[] args) {
            Meeting meeting = new  Meeting(1,2);
            Meeting meeting1 = new  Meeting(3,4);
            Meeting meeting2 = new  Meeting(0,6);
            Meeting meeting3 = new  Meeting(5,7);
            Meeting meeting4 = new  Meeting(8,9);
            Meeting meeting5 = new  Meeting(5,9);
            List<Meeting> meetings = new ArrayList<>();
            meetings.add(meeting);
            meetings.add(meeting1);
            meetings.add(meeting2);
            meetings.add(meeting3);
            meetings.add(meeting4);
            meetings.add(meeting5);

        System.out.println("Max Meetings : "+ActivitySelection.getNoOfMeetings(meetings));




    }
}
