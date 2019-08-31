package backtracking;


public class RateInMaze {
    private  int boardSize;
    private int[][] solution;
    private int[][] maze;

    public RateInMaze(int boardSize,int[][] maze) {
        this.boardSize = boardSize;
        solution = new int[boardSize][boardSize];
        this.maze = maze;
    }



    private void printSolution(){
        for (int i = 0; i <solution.length ; i++) {
            for (int j = 0; j <solution[i].length ; j++) {
                System.out.print(solution[i][j]+" ");
            }
            System.out.println();
        }
    }

    private void solveMaze(){
        if(solveMazeUtil(0,0)){
            printSolution();
        }else{
            System.out.println("No Feasible Solution Found");
        }
    }

    private boolean validMove(int x , int y){
        return (x >= 0 && x < boardSize && y >= 0 && y < boardSize && maze[x][y] == 1);
    }
    private boolean solveMazeUtil(int x , int y){
        if(x == boardSize-1 && y== boardSize-1){
            solution[x][y]=1;
            return true;
        }
        if(validMove(x,y)){
            solution[x][y] =1;

            if(solveMazeUtil(x+1,y)){
                return true;
            }
            if(solveMazeUtil(x,y+1)){
                return true;
            }
            solution[x][y]=0;
            return false;
        }
        return false;
    }

    public static void main(String args[])
    {
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

        RateInMaze rat = new RateInMaze(4,maze);

        rat.solveMaze();
    }
}
