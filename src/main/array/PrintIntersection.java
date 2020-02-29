package main.array;

public class PrintIntersection {

    static void printIntersection(int[] arr1 , int arr2[]){

        int i =0, j=0;

        while (i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                i++;
            }else if(arr1[i] > arr2[j]){
                j++;
            }else{
                System.out.println(arr1[i++] +" ");
                j++;
            }
        }

    }

    public static void main(String args[])
    {
        int arr1[] = {1, 2, 4, 5, 6};
        int arr2[] = {2, 3, 5, 7};
        int m = arr1.length;
        int n = arr2.length;
        printIntersection(arr1, arr2);
    }
}
