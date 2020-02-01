package main.backtracking;

public class NQueenProblem {
    private int boardSize;
    private int board[][] ;

    public NQueenProblem(int boardSize) {
        this.boardSize = boardSize;
        board = new int[boardSize][boardSize];
        initialize();

    }

    void initialize(){
        for (int i = 0; i <boardSize ; i++) {
            for (int j = 0; j <boardSize ; j++) {
                board[i][j] =0;
            }
        }
    }


    private boolean validMove(int row , int col){
        for (int i = 0; i <col ; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (int i=row,j=col;i>=0 && j>=0;j--,i--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i=row,j=col;i<boardSize && j>=0;j--,i++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private boolean boardSolver(int col){
        if(col>=boardSize)
            return true;
        for (int i = 0; i <boardSize ; i++) {
            if(validMove(i,col)){
                board[i][col]=1;

                if(boardSolver(col+1)){
                    return true;
                }
                board[i][col]=0;
            }
        }
        return false;
    }

    private void printSolution(){
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[i].length ; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        NQueenProblem queenProblem = new NQueenProblem(4);
        if(queenProblem.boardSolver(0))
            queenProblem.printSolution();
        else
            System.out.println("No Feasible Solution Found");
    }
}
