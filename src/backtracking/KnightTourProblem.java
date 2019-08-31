package backtracking;

public class KnightTourProblem {

    private  int boardSize;
    private int[][] visited;

    int xMove[] = {  2, 1, -1, -2, -2, -1,  1,  2 };
    int yMove[] = {  1, 2,  2,  1, -1, -2, -2, -1 };

    public KnightTourProblem(int boardSize) {
        this.boardSize = boardSize;
        this.visited = new int[boardSize][boardSize];
        initialize();
    }

    void printSolution(){
        for (int i = 0; i <visited.length ; i++) {
            for (int j = 0; j <visited[i].length ; j++) {
                System.out.print(visited[i][j]+" ");
            }
            System.out.println();
        }
    }

    void initialize(){
        for (int i = 0; i <boardSize ; i++) {
            for (int j = 0; j <boardSize ; j++) {
                visited[i][j] = Integer.MIN_VALUE;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        KnightTourProblem tourProblem = new KnightTourProblem(8);
        tourProblem.solveNightTourProblem();

    }

    public void solveNightTourProblem(){
        visited[0][0] = 0;
        if(solveProblem(1,0,0)){
            printSolution();
        }else{
            System.out.println("No Feasible Solution Found");
        }
    }

    public  boolean solveProblem(int moveCount ,int x , int y){

        if(moveCount == boardSize*boardSize){
            return true;
        }
        for (int i = 0; i <xMove.length ; i++) {
            int nextX = x +xMove[i];
            int nextY = y+yMove[i];
            if(isValidMove(nextX,nextY)){
                visited[nextX][nextY] =moveCount;
                if(solveProblem(moveCount+1,nextX,nextY)){
                    return true;
                }
                visited[nextX][nextY] = Integer.MIN_VALUE;
            }
        }
        return false;
    }

    public boolean isValidMove(int x , int y ){
        return (x >= 0 && x < boardSize && y >= 0 &&
                y < boardSize && visited[x][y] == Integer.MIN_VALUE);
    }


}
