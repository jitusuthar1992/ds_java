package main.array;

public class RowWithMaxOne {

    static void findMax(int arr[][]) {
        int row = 0, i, j;
        for (i = 0, j = arr.length - 1; i < arr.length; i++) {
            while (j >= 0 && arr[i][j] == 1) {
                row = i;
                j--;
            }
        }
        System.out.print("Row number = "
                + (row + 1));
        System.out.print(", MaxCount = "
                + (arr.length - 1 - j));
    }

    public static void main(String[] args) {
        int arr[][] = {{0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 1, 1, 1}};
        findMax(arr);
    }
}
