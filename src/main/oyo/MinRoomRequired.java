package main.oyo;

import java.util.*;

public class MinRoomRequired {
    // Returns minimum number of platforms reqquired
    static int findRooms(int arr[], int dep[], int n) {
        // Sort arrival and departure arrays
        Arrays.sort(arr);

        Arrays.sort(dep);

        // plat_needed indicates number of platforms
        // needed at a time
        int plat_needed = 0, result = 0;
        int i = 0, j = 0;

        // Similar to merge in merge sort to process
        // all events in sorted order
        while (i < n && j < n) {
            // If next event in sorted order is arrival,
            // increment count of platforms needed
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;

                // Update result if needed
                if (plat_needed > result)
                    result = plat_needed;
            }

            // Else decrement count of platforms needed
            else {
                plat_needed--;
                j++;
            }
        }

        return result;
    }

/*    static int findRoomsSol2(int arr[], int dep[], int n) {

        Map<Integer, Integer> events = new HashMap<>();

        // Number of rooms

        for (int i = 0; i < n; i++) {
            int arrival = arr[i];
            int departure = dep[i];

            // Add one during an arrival
            Integer current = events.get(arrival);
            events.put(arrival, current == null ? 1 : current + 1);

            // Remove one during a departure
            current = events.get(departure);
            events.put(departure, current == null ? -1 : current - 1);
        }

        // Sort the map
        Map<Integer, Integer> sortedEvents = new TreeMap<>(events);

        int count = 0;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : sortedEvents.entrySet()) {
            count += entry.getValue();

            // If the current count exceeds the maximum number of rooms
            if (count > max) {
                max = count;
            }
        }
        return max;
    }*/

    // Driver program to test methods of graph class
    public static void main(String[] args) {
        //int arr[] = { 1, 2, 3, 4, 5, };
        //int dep[] = { 2, 3, 4, 6, 7 };
        int arr[] = {1, 3, 5};
        int dep[] = {2, 6, 10};
        int n = arr.length;
        System.out.println("Minimum Number of Rooms Required = " + findRooms(arr, dep, n));
    }

}

