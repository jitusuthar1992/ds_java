package main.array.hackerrank;


import java.util.*;


public class NoOfSocksPair {
    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        Map<Integer,Integer> countMap = new HashMap<>();
        int totalMatch =0 ;
        for(int i =0;i<n ;i++){
            Integer eachCount =  countMap.get(ar[i]);
            if ((null == eachCount)) {
                eachCount =1 ;
                countMap.put(ar[i],eachCount);
            }else{
                countMap.put(ar[i],++eachCount);
            }
            if(eachCount %2 ==0){
                totalMatch++;
            }
        }
        return  totalMatch;
    }

    //private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {
        int ar[]= {10 ,20 ,20, 10, 10 ,30 ,50, 10 ,20};
        int result = sockMerchant(9, ar);
        System.out.println(result);
    }
}

