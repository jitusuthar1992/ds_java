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

    public static void main(String[] args) {
        int a = 10,b =25,c=15;
        int res =0;
        while (b >0){
            res += (a%c)+(c%a);
            b-= (a%c);
            int t = a ;
            a=c;
            c =t;

        }
        System.out.println(res);
    }
}
