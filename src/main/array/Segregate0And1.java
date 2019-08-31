package main.array;

public class Segregate0And1 {
    public static void sol1(int arr[],int n){
        int count =0;
        for (int i = 0; i <n ; i++) {
                if(arr[i]==0)
                    count++;
        }
        for (int i = 0; i <count ; i++) {
            arr[i]=0;
        }
        for (int i = count; i <n ; i++) {
            arr[i]=1;
        }
    }
    public static void print(int arr[], int n)
    {
        System.out.print("Array after segregation is ");
        for (int i = 0; i < n; i++)
            System.out.println(arr[i] + " ");
    }

    public static void main(String[] args) {
        int arr[] = new int[]{ 0, 1, 0, 1, 1, 1 };
        int n = arr.length;

        sol1(arr, n);
        print(arr, n);
        sol2(arr, n);
        print(arr, n);
    }

    public static void sol2(int arr[],int n){
        int left =0,right = n-1;
        while (left<right){
            /* Increment left index while we see 0 at left */
            while (arr[left] == 0 && left < right)
                left++;
            /* Decrement right index while we see 1 at right */
            while (arr[right] == 1 && left < right)
                right--;
            /* If left is smaller than right then there is a 1 at left
               and a 0 at right.  Exchange arr[left] and arr[right]*/
            if (left < right)
            {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
    }

}
