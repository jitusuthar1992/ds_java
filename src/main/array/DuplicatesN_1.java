package main.array;

public class DuplicatesN_1 {
    private static void findDuplicates(int arr[]){
        int n = arr.length;
        for (int i = 0; i <n ; i++) {
            arr[arr[i] % n] = arr[arr[i] % n] +n ;
        }
        System.out.println("Duplicate Elements are ");
        for (int i = 0; i <n ; i++) {
            if((arr[i] /n) > 1 ){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        DuplicatesN_1.findDuplicates(new int[] {1,2,3,3,2,3});
    }
}
