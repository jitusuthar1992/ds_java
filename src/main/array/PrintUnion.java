package main.array;

public class PrintUnion {
    static void printUnion(int[] arr1 , int arr2[]){

        int i =0, j=0;

        while (i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                System.out.println(arr1[i++] + " ");
            }else if(arr1[i] > arr2[j]){
                System.out.println(arr2[j++] + " ");
            }else{
                System.out.println(arr1[i++] +" ");
                j++;
            }
        }
        while(i < arr1.length)
            System.out.print(arr1[i++]+" ");
        while(j < arr2.length)
            System.out.print(arr2[j++]+" ");
    }

    public static void main(String args[])
    {
        int arr1[] = {1, 2, 4, 5, 6};
        int arr2[] = {2, 3, 5, 7};
        int m = arr1.length;
        int n = arr2.length;
        printUnion(arr1, arr2 );
    }
}
