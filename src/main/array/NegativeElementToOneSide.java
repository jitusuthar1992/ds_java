package main.array;

public class NegativeElementToOneSide {
    private static void moveNegElements(int arr[]){
        int i =-1;
        for (int j = 0; j <arr.length ; j++) {
            if(arr[j] < 0){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        System.out.println("elements are : ");
        for (int j = 0; j <arr.length ; j++) {
            System.out.println(arr[j]);
        }
    }

    public static void main(String[] args) {
        NegativeElementToOneSide.moveNegElements(new int[]{2,-1,3,5,-4,-6,8,-9});
    }
}
