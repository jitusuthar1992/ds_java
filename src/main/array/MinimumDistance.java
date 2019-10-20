package main.array;

// Java Program to Find the minimum
// distance between two numbers
public class MinimumDistance {
    static int minDistance(int x , int y , int[] arr){
        int minDist = Integer.MAX_VALUE;
        int i , prev=0;
        for ( i = 0; i <arr.length ; i++) {
            if(arr[i] == x || arr[i] ==y){
                prev =i;
                break;
            }
        }

        for ( ; i <arr.length ; i++) {
            if(arr[i] == x || arr[i] ==y){
                if(arr[i] != arr[prev] && i-prev < minDist){
                    minDist =i-prev;
                }
                prev =i;
            }
            
        }
        return  minDist;
    }
    public static void main(String[] args) {
        MinimumDistance min = new MinimumDistance();
        int arr[] = {3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3};
        int n = arr.length;
        int x = 3;
        int y = 6;

        System.out.println("Minimum distance between " + x + " and " + y
                                   + " is " + minDistance( x, y,arr));
    }
}
