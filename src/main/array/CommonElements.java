package main.array;

public class CommonElements {
    private static void printCommonElements(int arr1[], int arr2[],int arr3[]){
        int n1 = arr1.length , n2 = arr2.length, n3 = arr3.length;
        int i=0,j=0 ,k=0;
        while (i < n1 && j <n2 && k < n3){
            if(arr1[i] == arr2[j] && arr2[j] == arr3[k]){
                System.out.println(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]){
                    j++;
            }else {
                k++;
            }
            int xx = arr1[i-1];
            while (arr1[i] == xx)
                i++;
            int yy = arr1[j-1];
            while (arr1[j] == yy)
                j++;
            int zz = arr1[k-1];
            while (arr1[k] == zz)
                k++;
        }
    }
}
