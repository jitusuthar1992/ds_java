package main.array;

public class MinInSortedRotatedArray {

    public static int  findMin(int arr[],int low , int high){
        int mid = (low+high)/2;
        if(arr[high]> arr[low]){
            return arr[low];
        }

        if(high== low){
            return arr[low];
        }

        if(mid < high && arr[mid] > arr[mid+1]){
            return arr[mid+1];
        }

        if(mid > low && arr[mid] < arr[mid-1]){
            return arr[mid];
        }

        if(arr[high] > arr[low])
            return findMin(arr,low,mid-1);
        return findMin(arr,mid+1,high);

    }

    public static void main(String[] args) {
        int arr[]= {5,6,7,8,2,3,4};
        System.out.println(findMin(arr,0,arr.length-1));
    }
}
