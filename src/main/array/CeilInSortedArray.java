package main.array;

public class CeilInSortedArray {

    static int ceilIndexLinearSearch(int key , int low , int high , int arr[]){
        int i ;

        if(key <= arr[low]){
            return low;
        }

        if(key > arr[high]){
            return -1;
        }

        for ( i = 0; i < arr.length; i++) {
            if(arr[i]== key){
                return i;
            }

            if(arr[i] < key && arr[i+1] >= key){
                return i+1;
            }
        }
        return -1;
    }

    static int ceilIndexBinarySearch(int key , int low , int high , int arr[]){
        int mid ;
        if(key <= arr[low])
            return low;

      /* If x is greater than the last
         element, then return -1 */
        if(key > arr[high])
            return -1;

        mid = low + (low+high)/2;

        if(arr[mid]== key){
            return mid;
        }

        if(arr[mid] < key){
            if(mid+1 <= high && key <= arr[mid+1]){
                return mid+1;
            }else{
                return ceilIndexBinarySearch(key,mid+1,high,arr);
            }
        }else{
            if(mid-1 >=low && arr[mid-1] < key ){
                return mid;
            }else{
                return ceilIndexBinarySearch(key,low,mid-1,arr);
            }
        }

    }

    public static void main (String[] args)
    {
        int arr[] = {1, 2, 8, 10, 10, 12, 19};
        int n = arr.length;
        int x = 9;
        int index = ceilIndexBinarySearch(x ,0, n-1, arr);
        if(index == -1)
            System.out.println("Ceiling of "+x+" doesn't exist in array");
        else
            System.out.println("ceiling of "+x+" is "+arr[index]);
    }


}
