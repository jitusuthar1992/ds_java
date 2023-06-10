package main.array.codelibrary;

import java.util.HashMap;
import java.util.Map;

public class PairWithGivenDiff {
    
    public static int isPresentPairSol1(int arr[],int x){
        
        int f =-1;

        for (int i = 0; i <arr.length ; i++) {
            int y = arr[i]+x;
            for (int j = 0; j < arr.length ; j++) {
                if(arr[j] == y){
                    f =1;
                    break;
                }
            }
        }
        return f;
    }

    public static int isPresentPairSol2(int arr[],int x){

        int f =-1;

        Map<Integer,Integer> countMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            countMap.put(arr[i],1);
        }

        for (int i = 0; i <arr.length ; i++) {
            int y  = arr[i] +x;
            if(countMap.get(y) ==1){
                f =1;
                break;
            }
        }
        return f;
    }
}
