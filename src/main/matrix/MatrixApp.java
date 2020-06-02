package main.matrix;

public class MatrixApp {
    public static int noOFElementsLessThanGivenValue(int mat[][], int val){
        if(mat.length ==0){
            System.out.println("Matrix is blank");
            return -1;
        }
        int totalRows = mat.length;
        int totalColumns = mat[0].length;
        int row = 0 , column = totalColumns-1;

        int count =0;

        while (row < totalColumns && column >=0){
            if (val >= mat[row][column]){
                count = count +column +1;
                row++;
            }else{
                column--;
            }
        }
        return count;
    }

    public static void searchElementInRowColumnSortedMatrix(int[][] mat, int val) {
        if(mat.length == 0) {
            System.out.println("Matrix is Blank");
            return;
        }

        int totalRows = mat.length;
        int totalColumns = mat[0].length;

        int row, column;
        row = 0;
        column = totalColumns - 1;

        while(row < totalRows && column >= 0) {
            if(mat[row][column] == val) {
                System.out.println("Value is present at: "+ row +" " + column);
                return;
            }

            if(val > mat[row][column]) {
                row++;
            } else {
                column--;
            }
        }

        System.out.println("Value is not present in Matrix");
    }

    public static void main(String[] args) {

        int[][] mat = {{2, 7, 15},
                {4, 9, 19},
                {6, 10, 24}};

        System.out.println(MatrixApp.noOFElementsLessThanGivenValue(mat, 8));
        MatrixApp.searchElementInRowColumnSortedMatrix(mat, 4);
    }
}
