package main.recusrsion.array;

public class MatrixPath {
    public static int  findPath(int row, int col){
            if(row ==1)
                return 1;
            if(col==1)
                return 1;
            return findPath(row-1,col)+findPath(row,col-1);
    }

    public static void main(String[] args) {
        System.out.println(findPath(3,3));
    }
}
