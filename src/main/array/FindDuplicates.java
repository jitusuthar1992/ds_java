package main.array;

/**
 * @author jitendra.kumar01
 * 06/02/20
 */
public class FindDuplicates {
    public static void  FindDuplicates(int arr[], int size){
        System.out.println("The repeating elements are : ");

        for (int i = 0; i <size ; i++) {
            if(arr[Math.abs(arr[i])]>=0){
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            }else {
                System.out.print(Math.abs(arr[i]) + " ");
            }
        }
    }

    public static void main(String[] args)
    {
        int arr[] = {1, 2, 3, 1, 3, 6, 6};
        int arr_size = arr.length;

        FindDuplicates(arr, arr_size);
    }
}
