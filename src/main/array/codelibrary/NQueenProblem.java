package main.array.codelibrary;

public class NQueenProblem {

    void solve(int board[][],int ans[][],int col,int n){
        if(col == n){
            addSolution(board,ans);
        }

        for (int row = 0; row < n; row++) {
            if(isSafe(board,row,col,n)){
                board[row][col] =1;
                solve(board,ans,col+1,n);
                board[row][col] =0;
            }
        }
    }

    private boolean isSafe(int[][] board, int row, int col, int n) {
        int x = row;
        int y = col;

        while (y>=0){
            if(board[x][y]==1)
                return false;
            y--;
        }

        while (y>=0 & x>=0){
            if(board[x][y]==1)
                return false;
            y--;
            x--;
        }

        while (y>=0 & x < n){
            if(board[x][y]==1)
                return false;
            y--;
            x++;
        }
        return true;
    }

    private void addSolution(int[][] board, int[][] ans) {
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[i].length; j++) {
                ans[i][j] = board[i][j];
            }
        }
    }
}
