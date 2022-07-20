package main.array;

public class KthMinSumCombinations {

    private static void minSumCombinations(int k, int arr1[], int arr2[]) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        int index2[] = new int[n1];

        while (k > 0) {
            int minIndex = 0;
            int minValue = Integer.MAX_VALUE;


            for (int i = 0; i < n1; i++) {
                if (i < n2 && minValue > (arr1[i] + arr2[index2[i]])) {
                    minIndex = i;
                    minValue = arr1[i] + arr2[index2[i]];
                }
            }

            System.out.println("Min Sum = " + minValue + " , combination (" + arr1[minIndex] + "," + arr2[index2[minIndex]] + ")");

            index2[minIndex]++;
            k--;
        }
    }

    public static void main(String[] args) {
        int originPrices[] = {3000, 2000, 1000, 5000};
        int returnPrices[] = {1000, 6000, 2000, 8000};

        minSumCombinations(4, originPrices, returnPrices);
    }
}
