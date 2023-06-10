package main.array.codelibrary;

import java.util.HashMap;
import java.util.Map;

public class SubsetArray {
    public static boolean subsetArray(int orig[], int subset[]){

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < orig.length ; i++) {
            if(map.containsKey(orig[i])){
                map.put(orig[i],map.get(orig[i])+1 );
            }else {
                map.put(orig[i],1 );
            }
        }
        int c = 0;
        for (int i = 0; i < subset.length ; i++) {
            if(map.containsKey(subset[i])){
                c++;
            }
        }
        if(c != subset.length)
            return false;
        return true;
    }
}
