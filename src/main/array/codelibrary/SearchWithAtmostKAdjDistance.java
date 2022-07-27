package main.array.codelibrary;

public class SearchWithAtmostKAdjDistance {

    private static int getIndex(int arr[],int key , int diff){
        int ans= -1;
        int i =0;
        while(i < arr.length){
            if(arr[i] == key){
                return i;
            }
            i = i+ Math.max(1,Math.abs(arr[i]-key/diff));
        }
        return ans;
    }
}
