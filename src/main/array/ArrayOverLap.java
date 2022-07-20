package main.array;

/*
import sun.jvm.hotspot.utilities.Interval;
*/

import java.util.*;

/**
 * @author jitendra.kumar01
 * 26/11/19
 */


//ussolved
/*
L - [(2,6), (11,16), (23, 45), (67, 78) …. N intervals]  --disjoint and sorted

        G = (5, 8)
        R - [(2,8), (11,16), (23, 45), (67, 78) …. N intervals]

        G = (10, 35)
        R -  [(2,6), (10, 45), (67, 78) …. N intervals]

        G - (7, 9)
        R - [(2,6), (7, 9), (11,16), (23, 45), (67, 78) …. N intervals]
 */
public class ArrayOverLap {

    public static void mergeIntervals(IntervalTest arr[]) {
        // Test if the given set has at least one interval
        if (arr.length <= 0)
            return;

        // Create an empty stack of intervals
        Stack<IntervalTest> stack = new Stack<>();

        // sort the intervals in increasing order of start time
        Arrays.sort(arr, (i1, i2) -> i1.start - i2.start);

        // push the first interval to stack
        stack.push(arr[0]);

        // Start from the next interval and merge if necessary
        for (int i = 1; i < arr.length; i++) {
            // get interval from stack top
            IntervalTest top = stack.peek();

            // if current interval is not overlapping with stack top,
            // push it to the stack
            if (top.end < arr[i].start)
                stack.push(arr[i]);

                // Otherwise update the ending time of top if ending of current
                // interval is more
            else if (top.end < arr[i].end) {
                top.end = arr[i].end;
                stack.pop();
                stack.push(top);
            }
        }

        // Print contents of stack
        System.out.print("The Merged Intervals are: ");
        while (!stack.isEmpty()) {
            IntervalTest t = stack.pop();
            System.out.print("[" + t.start + "," + t.end + "] ");
        }
    }

    public static void main(String args[]) {
        IntervalTest arr[] = new IntervalTest[5];
        arr[0] = new IntervalTest(2, 6);
        arr[1] = new IntervalTest(11, 16);
        arr[2] = new IntervalTest(23, 45);
        arr[3] = new IntervalTest(67, 78);
        arr[4] = new IntervalTest(10, 35);
        mergeIntervals(arr);


    }
}

class IntervalTest {
    int start, end;

    IntervalTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

   /* static class IntervalTest{
        int start ;
        int end ;
        boolean overLap;

        public IntervalTest(int start, int end, boolean overLap) {
            this.start = start;
            this.end = end;
            this.overLap = overLap;
        }
    }

    static Interval[] checkOverLap(Interval g , Interval[] intervals) {
        int[] overlapIntervals = new int[intervals.length];

        for (int i = 0; i <overlapIntervals.length ; i++) {
            overlapIntervals[i] =-1;
        }
        int j =0;
        Interval[]  resultant = new Interval[intervals.length];

        int firstIndex =0;
        int l =0;
        for (int i = 0; i <intervals.length ; i++) {

            int x1 = (Integer)intervals[i].getLowEndpoint() ;
            int y1 = (Integer)intervals[i].getHighEndpoint();
            int x2 = (Integer)g.getLowEndpoint() ;
            int y2 = (Integer)g.getHighEndpoint();



            if(i==1 || i==2){
                overlapIntervals[j++] = i;
            }
           *//* if(checkOverlap(x1,y1,x2,y2)){
                overlapIntervals[j++] = i;
            }*//*
        }

        if(overlapIntervals.length ==1){
            int x1 = (int) intervals[overlapIntervals[0]].getLowEndpoint();
            int y1 = (int) intervals[overlapIntervals[0]].getHighEndpoint();
            int x2 = (Integer)g.getLowEndpoint() ;
            int y2 = (Integer)g.getHighEndpoint();
            int arr[] ={x1,y1,x2,y2};
            intervals[overlapIntervals[0]] = new Interval(getMinValue(arr),getMaxValue(arr));
        }else {
            int arr[] = new int[overlapIntervals.length*2+2];
            Arrays.fill(arr,Integer.MAX_VALUE);
            int k =0;
            for (int i = 0; i <overlapIntervals.length ; i++) {
                if(overlapIntervals[i] != -1){
                    int x1 = (int) intervals[overlapIntervals[i]].getLowEndpoint();
                    int y1 = (int) intervals[overlapIntervals[i]].getHighEndpoint();
                    arr[k++] =  x1;
                    arr[k++] =  y1;
                    firstIndex = i;
                }
            }
            int x2 = (Integer)g.getLowEndpoint() ;
            int y2 = (Integer)g.getHighEndpoint();
            arr[k++] =  x2;
            arr[k++] =  y2;

            intervals[overlapIntervals[firstIndex]] = new Interval(getMinValue(arr),getMaxValue(arr));
        }


        for (int i = firstIndex; i <intervals.length ; i++) {
            System.out.println("("+intervals[i].getLowEndpoint()+", "+intervals[i].getHighEndpoint()+")");
        }
        return  resultant;

    }

    public static int getMaxValue(int[] numbers){
        int maxValue = numbers[0];
        for(int i=1;i < numbers.length;i++){
            if(numbers[i] > maxValue){
                maxValue = numbers[i];
            }
        }
        return maxValue;
    }
    public static int getMinValue(int[] numbers){
        int minValue = numbers[0];
        for(int i=1;i<numbers.length;i++){
            if(numbers[i] < minValue){
                minValue = numbers[i];
            }
        }
        return minValue;
    }


    public static boolean checkOverlap(int x1 , int y1, int x2 , int y2){


        int xmin = Math.min(x1,x2);
        int xmax = Math.max(x1,x2);
        int ymin = Math.min(y1,y2);
        int ymax = Math.max(y1,y2);

        for (int i = xmin; i < xmax; ++i)
            if (ymin < i && i < ymax)
                return true;

        return false;
    }

    public static void main(String[] args) {

        Interval arr[]=new Interval[4];
        *//*arr[0]=new Interval(2,6);
        arr[1]=new Interval(11,16);
        arr[2]=new Interval(23,45);
        arr[3]=new Interval(67,78);*//*


        arr[0]=new Interval(2,6);
        arr[1]=new Interval(11,16);
        arr[2]=new Interval(23,45);
        arr[3]=new Interval(67,78);

        checkOverLap(new Interval(10,35),arr);

        //(2,6), (11,16), (23, 45), (67, 78)
    }*/


}
