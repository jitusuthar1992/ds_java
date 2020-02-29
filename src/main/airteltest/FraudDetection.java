package main.airteltest;

import java.util.HashMap;
import java.util.Map;

public class FraudDetection {
   /* input 1 = time frame ;
    input 2 = max no of calls
    input 3 = incoming calls */

    private static Map<Integer, Map<Integer, Integer>> map = new HashMap();

    private static final int MAX_CALLS = 3;

    private static final int TIME_FRAME = 1; // Hour

    public static void fraudDetection(int callID, int hour) {

        int count =0 ;
        Map<Integer, Integer> hourToCountMap = map.get(callID);
        if (null ==  hourToCountMap) {
            hourToCountMap = new HashMap<>();
            count =1;
            hourToCountMap.put(hour,count);
            map.put(callID,hourToCountMap);
        } else {
            count = hourToCountMap.get(hour);
            count++;
            hourToCountMap.put(hour,count);
        }


        if (count == MAX_CALLS) {
            throw new RuntimeException("FRAUD ID :" + callID);
        }

    }

    public static void main(String[] args) {
        fraudDetection(2,1);
        fraudDetection(1,1);
        fraudDetection(2,1);
        fraudDetection(2,1);

    }
}
