package main.recusrsion.array;

public class BinarySearch {
    static boolean binarySearch(int arr[], int s , int e , int key){
        if(s>e)
            return false;
        int mid =   s + (e-s)/2;
        if(arr[mid] == key)
            return true;
        else if (arr[mid] < key) {
            return binarySearch(arr,mid+1,e,key);
        }else {
            return binarySearch(arr,s,mid-1,key);
        }
    }
}
