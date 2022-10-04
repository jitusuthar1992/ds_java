package main.array;

public class MinAndMaxElement {
    private static void printMinAndMaxElementSol1(int arr[]){
        int n = arr.length;
        int min,max;
        if(n ==1){
            min = arr[0];
            max = arr[0];
        }else {
            if (arr[0] > arr[1]){
                min = arr[1];
                max = arr[0];
            }else {
                min = arr[0];
                max = arr[1];
            }
        }

        for (int i = 2; i <n ; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println("Min Element " + min);
        System.out.println("Max Element " + max);
    }

    private static void printMinAndMaxElementSol2(int arr[]){
        int n = arr.length;
        int min,max;
        int i=0;
        if(n %2 == 0){
            if (arr[0] > arr[1]){
                min = arr[1];
                max = arr[0];
            }else {
                min = arr[0];
                max = arr[1];
            }
            i=2;
        }else {
            min = arr[0];
            max = arr[0];
            i=1;
        }
       while (i < n-1){
           if(arr[i] > arr[i+1]){
               if(arr[i] > max){
                   max = arr[i];
               }
               if(arr[i+1] < min){
                   min = arr[i+1];
               }
           }else {
               if(arr[i+1] > max){
                   max = arr[i+1];
               }
               if(arr[i] < min){
                   min = arr[i];
               }
           }

           i+=2;
       }
        System.out.println("Min Element " + min);
        System.out.println("Max Element " + max);
    }
}
