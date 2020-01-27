package main.array;

/**
 * @author jitendra.kumar01
 * 24/10/19
 */
public class SubArraySum {

    static int sumSubArray(int[] arr){

        int n = arr.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j <n ; j++) {
                for (int k = i; k <=j ; k++) {
                    System.out.println(arr[k]);
                    sum+= arr[k];
                }
            }
        }

        return sum;
    }
    public static void main(String[] args)
    {
        int arr[] = {1, 2, 3,4} ;
        System.out.println("Sum of SubArray : " +
                                   sumSubArray(arr));
        System.out.println("Sum of SubArray : " +
                                   SubArraySum(arr,arr.length));
    }

    public static long SubArraySum( int arr[] , int n )
    {
        long result = 0;

        // computing sum of subarray using formula
        for (int i=0; i<n; i++)
            result += (arr[i] * (i+1) * (n-i));

        // return all subarray sum
        return result ;
    }
}
