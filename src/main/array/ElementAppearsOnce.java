package main.array;

public class ElementAppearsOnce {

    static int findElement(int arr[]) {

        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res ^ arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int ar[] = {2, 3, 5, 4, 5, 3, 4};
        System.out.println(findElement(ar));
    }
}
