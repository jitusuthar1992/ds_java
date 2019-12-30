package main.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jitendra.kumar01
 * 14/11/19
 */
public class PrintTriplets {

    static void sol1(int arr[], int sum){
        int n = arr.length;

        for (int i = 0; i <n-2 ; i++) {
            for (int j = i+1; j <n-1 ; j++) {
                for (int k = j+1; k <n ; k++) {
                    if(arr[i]+arr[j]+arr[k] == sum){
                        System.out.println(arr[i] +" "+arr[j]+ " "+arr[k]);
                    }
                }
            }
        }
    }
    
    static void sol2(int arr[], int sum){
        int n = arr.length;

        for (int i = 0; i <n-1 ; i++) {
            Set<Integer> hashSet = new HashSet<>();

            for (int j = i+1; j <n ; j++) {
                int  x = sum -(arr[i]+arr[j]);

                if(hashSet.contains(x)){
                    System.out.println( x+" " +arr[i]+" " +arr[j]);
                }else {
                    hashSet.add(arr[j]);
                }
            }
        }
    }

    static void sol3(int arr[], int sum) {
        int n = arr.length;
        Arrays.sort(arr);

        for (int i = 0; i <n-1 ; i++) {
            int l = i+1;
            int r = n-1;
            int x = arr[i];
            while (l<r){
                if (x + arr[l] + arr[r] == sum)
                {
                    // print elements if it's
                    // sum is given sum.
                    System.out.println(x + " " + arr[l] +
                                               " " + arr[r]);
                    l++;
                    r--;
                }

                // If sum of three elements
                // is less than 'sum' then
                // increment in left
                else if (x + arr[l] +
                        arr[r] < sum)
                    l++;

                    // if sum is greater than
                    // given sum, then decrement
                    // in right side
                else
                    r--;
            }
        }

    }
    public static void main (String[] args)
    {
        int arr[] = {0, -1, 2, -3, 1};
        int n = arr.length;
        System.out.println("Sol 1");
        sol1(arr, 0);
        System.out.println("Sol 2");
        sol2(arr, 0);
        System.out.println("Sol 3");

        sol3(arr, 0);


    }

}
