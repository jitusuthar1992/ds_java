package main.array;

public class CountOnes {
    int countOnes(int arr[], int l , int h ){
        if(l > h)
            return -1 ;
        int mid = l + (h-l)/2;

        if((arr[mid] ==1) && ((h == mid)) || arr[mid+1] ==0 )
            return mid+1;
        if(arr[mid] ==1)
            return countOnes(arr,mid+1,h);
        return countOnes(arr,l,mid-1);
    }
    public static void main(String args[])
    {
        CountOnes ob = new CountOnes();
        int arr[] = { 1, 1, 1, 1, 0, 0, 0 };
        int n = arr.length;
        System.out.println("Count of 1's in given array is "
                + ob.countOnes(arr, 0, n - 1));
    }
}
