package main.array;

/**
 * @author jitendra.kumar01
 * 14/11/19
 */
public class EquilibriumIndex {

    static int findIndex(int arr[]) {

        int n = arr.length;
        int sum = 0, leftSum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        for (int i = 0; i < n; i++) {

            //store right sum
            sum = sum - arr[i];
            if (leftSum == sum) {
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        EquilibriumIndex equi = new EquilibriumIndex();
        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println("First equilibrium index is " +
                findIndex(arr));
    }
}
