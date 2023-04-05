package main.lld.tictactoe;

public class TicTacToe {
    int[][] board ;

    private final int n;

    private int rowSum[] , colSum[] , diagSum , revDiagSum;
    int winner;

    public TicTacToe(int n) {
        this.board = new int[n][n];
        this.rowSum = new int[n];
        this.colSum = new int[n];
        this.n = n;
    }

    //Complexity O(n)
    public int moveSol1(int player, int row, int col) throws IllegalArgumentException {
        if(row < 0 || row >= n || col < 0 || col  >= n){
            throw new IllegalArgumentException("Move out of boundary");
        }
        if(board[row][col] != 0){
            throw new IllegalArgumentException("Square is already occupied");
        }

        if(player != 0 && player != 1){
            throw  new IllegalArgumentException("Invalid Player");
        }

        player = player ==0 ? -1 :1;
        board[row][col] =player;

        boolean win = true;

        for (int i = 0; i < n; i++) {
            if(board[row][i] != player){
                win = false;
                break;
            }
        }
        if(win)
            return player;

        win = true;
        for (int i = 0; i < n; i++) {
            if(board[i][col] != player){
                win = false;
                break;
            }
        }
        if(win)
            return player;

        if(row == col){
            win = true;
            for (int i = 0; i < n; i++) {
                if(board[i][i] != player){
                    win = false;
                    break;
                }
            }
            if(win)
                return player;
        }

        if(row == n -1 -col){
            win = true;
            for (int i = 0; i < n; i++) {
                if(board[i][n-1-i] != player){
                    win = false;
                    break;
                }
            }
            if(win)
                return player;
        }
        return 0;

    }

    //Complexity O(n)
    public int moveSol2(int player, int row, int col) throws IllegalArgumentException {
        if(row < 0 || row >= n || col < 0 || col  >= n){
            throw new IllegalArgumentException("Move out of boundary");
        }
        if(board[row][col] != 0){
            throw new IllegalArgumentException("Square is already occupied");
        }

        if(player != 0 && player != 1){
            throw  new IllegalArgumentException("Invalid Player");
        }

        if(getWinner() != 0){
            return winner;
        }

        player = player ==0 ? -1 :1;
        board[row][col] =player;
        rowSum[row] += player;
        colSum[col] += player;

        if(row == col){
            diagSum += player;
        }
        if(row == n-1-col){
            revDiagSum += player;
        }

        if(rowSum[row] == Math.abs(n) || colSum[col] ==Math.abs(n) || diagSum == Math.abs(n) || revDiagSum == Math.abs(n) ){
            winner = player;
        }
        return getWinner();
    }

    //Complexity O(n)
    public int moveSol3(int player, int row, int col) throws IllegalArgumentException {
        if(row < 0 || row >= n || col < 0 || col  >= n){
            throw new IllegalArgumentException("Move out of boundary");
        }
        if(board[row][col] != 0){
            throw new IllegalArgumentException("Square is already occupied");
        }

        if(player != 0 && player != 1){
            throw  new IllegalArgumentException("Invalid Player");
        }

        player = player ==0 ? -1 :1;
        board[row][col] =player;

        boolean winRow = true , winCol = true, winDiag = true , winRevDiag = true;

        for (int i = 0; i < n; i++) {
            if(board[row][i] != player){
                winRow = false;
            }
            if(board[i][col] != player){
                winCol = false;
            }
            if(board[i][i] != player){
                winDiag = false;
            }
            if(board[i][n-1-i] != player){
                winRevDiag = false;
            }
        }

        if(winRow || winCol || winDiag || winRevDiag){
            return player;
        }
        return 0;

    }

    public int getWinner() {
        return winner;
    }

}
