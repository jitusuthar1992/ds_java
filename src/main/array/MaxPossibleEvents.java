package main.array;

import java.util.*;

class MaxPossibleEvents {

    /*
     * Complete the 'maxEvents' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arrival
     *  2. INTEGER_ARRAY duration
     */

    public static int maxEvents(int[] arrival, int[]  duration) {

        int n = arrival.length;
        int[]  departure = new int[n];

        for (int i = 0; i <n ; i++) {
            departure[i] = arrival[i]+duration[i];
        }

        Arrays.sort(arrival);
        Arrays.sort(departure);

        int events = 0, maxEvents = 0;
        int i = 0, j = 0;

        // Similar to merge in merge sort to process
        // all events in sorted order
        while (i < n && j < n) {
            // If next event in sorted order is arrival,
            // increment count of platforms needed
            if (arrival[i] <= departure[j] ){
                events++;
                i++;

                // Update result if needed
                if (events > maxEvents)
                    maxEvents = events;
            }

            else {
                events--;
                j++;
            }
        }
        return maxEvents;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 5};
        int dur[] = { 2,6,10 };

        System.out.println(maxEvents(arr,dur));

    }
}

