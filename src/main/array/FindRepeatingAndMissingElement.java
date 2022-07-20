package main.array;

public class FindRepeatingAndMissingElement {

    private static void findTwoElement(int arr[]) {
        int repeated = -1, missing = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[Math.abs(arr[i]) - 1] < 0) {
                repeated = Math.abs(arr[i]);
            } else {
                arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        System.out.println("Repeated Element : " + repeated);
        System.out.println("Missing Element : " + missing);
    }

    public static void main(String[] args) {
        findTwoElement(new int[]{2, 4, 1, 4, 5, 6});
    }
}
