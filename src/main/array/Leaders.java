package main.array;

public class Leaders {

    static void printLeaders(int arr[]) {
        int n = arr.length;

        int maxFromRight = arr[n-1];

        System.out.println(maxFromRight);

        for (int i = n-2; i >=0 ; i--) {
            if (maxFromRight < arr[i]){
                maxFromRight = arr[i];
                System.out.println(maxFromRight);
            }
        }
    }

    public static void main(String[] args)
    {
        int arr[] = new int[]{16, 17, 4, 3, 5, 2};
        printLeaders(arr);
    }
}
