package main.array.codelibrary;

public class MajorityElement {

    private static int findMajorityElement(int arr[]){

        int ma = arr[0];
        int count =1 ;

        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]== ma){
                count++;
            }else {
                count--;
            }

            if(count == 0){
                ma = arr[i];
                count = 1;
            }
        }

        int c=0;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]== ma){
                c++;
            }
        }

        if(c > arr.length/2)
            return ma;
        return -1;
    }
}
