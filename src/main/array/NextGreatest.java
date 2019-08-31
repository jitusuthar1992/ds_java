package main.array;
/*
Replace every element with the greatest element on right side
 */
public class NextGreatest {
    static  void greatestRight(int a[]){
        int size = a.length;

        int maxFromRight = a[size-1];
        a[size-1] =-1;

        for(int i = size-2;i>=0;i--){
            int temp = a[i];
            a[i] = maxFromRight;
            if(maxFromRight < temp){
                maxFromRight = temp;
            }
        }
    }

    static void printArray(int arr[])
    {
        for (int i=0; i < arr.length; i++)
            System.out.print(arr[i]+" ");
    }

    public static void main(String[] args) {
        int a[]={5,1,7,3,8,9,4};
        greatestRight(a);
        printArray(a);
    }
}
