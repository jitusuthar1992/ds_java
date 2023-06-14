package main.array.codelibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinSetCovInterval {
    public static int compare(List<Integer> a,
                              List<Integer> b)
    {
        if (a.get(1).equals(b.get(1))) {
            return b.get(0).compareTo(a.get(0));
        }
        else {
            return a.get(1).compareTo(b.get(1));
        }
    }

    public static int intersectionSizeTwo(List<List<Integer>> intervals)
    {
        int n = intervals.size();

        // Sort the array
        Collections.sort(intervals, MinSetCovInterval::compare);
        List<Integer> res = new ArrayList<>();

        // Known two rightmost point
        // in the set/res
        res.add(intervals.get(0).get(1) - 1);
        res.add(intervals.get(0).get(1));

        for (int i = 1; i < n; i++) {

            int start = intervals.get(i).get(0);
            int end = intervals.get(i).get(1);

            // Means there is no common between
            // curr interval and intervals
            // before this
            if (start > res.get(res.size() - 1)) {
                res.add(end - 1);
                res.add(end);
            }

            // Atleast 1 value from current
            // interval matches with previous
            // sets just add 1 max value
            else if (start > res.get(res.size() - 2)) {
                res.add(end);
            }
        }
        return res.size();
    }

    // Driver Code
    public static void main(String[] args)
    {
        // ranges
        List<List<Integer> > range = Arrays.asList(
                Arrays.asList(3, 6), Arrays.asList(2, 4),
                Arrays.asList(0, 2), Arrays.asList(4, 7));

        // Function Call
        System.out.println(intersectionSizeTwo(range));
    }
}
