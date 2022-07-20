package main.array;

public class PositionalElements {
    static int countPositionalElements(int arr[][], int rowCount, int columnCount) {

        int rowMax[] = new int[rowCount];
        int rowMin[] = new int[rowCount];

        int colMax[] = new int[columnCount];
        int colMin[] = new int[columnCount];

        for (int i = 0; i < rowCount; i++) {
            int rMax = Integer.MIN_VALUE;
            int rMin = Integer.MAX_VALUE;

            for (int j = 0; j < columnCount; j++) {
                if (arr[i][j] > rMax) {
                    rMax = arr[i][j];
                }
                if (arr[i][j] < rMin) {
                    rMin = arr[i][j];
                }

            }
            rowMax[i] = rMax;
            rowMin[i] = rMin;
        }

        for (int i = 0; i < columnCount; i++) {
            int cMax = Integer.MIN_VALUE;
            int cMin = Integer.MAX_VALUE;

            for (int j = 0; j < rowCount; j++) {
                if (arr[j][i] > cMax) {
                    cMax = arr[j][i];
                }
                if (arr[j][i] < cMin) {
                    cMin = arr[j][i];
                }

            }
            colMax[i] = cMax;
            colMin[i] = cMin;
        }

        int count = 0;
        for (int i = 0; i < rowCount; i++) {

            for (int j = 0; j < columnCount; j++) {
                if (arr[i][j] == rowMax[i] || arr[i][j] == rowMin[i] || arr[i][j] == colMax[j] || arr[i][j] == colMin[j]) {
                    count++;
                }
            }

        }
        return count;

    }

    public static void main(String[] args) {
        int a[][] = new int[][]{{1, 3, 4}, {5, 2, 9}, {8, 7, 6}};
        int m = 3, n = 3;
        System.out.println(countPositionalElements(a, m, n));
    }
}
