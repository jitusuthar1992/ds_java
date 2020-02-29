package main.array;

public class CommonFromThreeArray {

    static void findCommon(int arr1[], int arr2[], int arr3[]){
        int l = arr1.length , m = arr2.length , n = arr3.length;
        int i = 0, j=0, k =0;
        while (i < l && j < m && k <n){
            if(arr1[i] == arr2[j] && arr2[j] == arr3[k]){
                System.out.println(arr1[i++]+ " ");
                j++;
                k++;
            }else if (arr1[i] < arr2[j]){
                i++;
            }else if(arr2[j] < arr3[k]){
                j++;
            }else{
                k++;
            }
        }
    }

    public static void main(String args[])
    {

        int ar1[] = {1, 5, 10, 20, 40, 80};
        int ar2[] = {6, 7, 20, 80, 100};
        int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};

        System.out.println("Common elements are ");
        CommonFromThreeArray.findCommon(ar1, ar2, ar3);
    }
}
