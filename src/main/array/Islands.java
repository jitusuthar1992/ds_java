package main.array;

/**
 * @author jitendra.kumar01
 * 03/02/20
 */
public class Islands {

    private int ROW ,COL;
    private char[][] adj;

    public Islands(int ROW, int COL, char[][] adj) {
        this.ROW = ROW;
        this.COL = COL;
        this.adj = adj;
    }

    public Islands() {
    }

    public  int  numIslands(char[][] grid) {

        int noOfIslands = 0;

        for(int i=0;i<grid.length;i++) {

            for(int j=0;j<grid[i].length;j++) {

                if(grid[i][j] == 'l') {

                    noOfIslands++;
                    bfs(grid, i, j);

                }

            }

        }

        return noOfIslands;
    }

    private  void bfs(char[][] grid, int i, int j) {

        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]=='w') {
            return;
        }

        grid[i][j] = 'w';

        bfs(grid, i+1, j);//down
        bfs(grid, i-1, j);//up
        bfs(grid, i, j+1);//right
        bfs(grid, i, j-1);//left

    }

    public static void main(String[] args) {
        // Size of given matrix is m X n
        int m = 5;
        int n = 4;


        char mat[][] = { { 'l', 'w', 'l','w' },
                        { 'l', 'l', 'l','w' },
                        { 'w', 'w', 'w','w' },
                        { 'w', 'w', 'w','w' },
                        { 'w', 'w', 'w','l' } };

        Islands islands = new Islands(5,4,mat);

        System.out.println("Number of rectangular islands is: " + islands.numIslands(mat));

        char mat1[][] = { { 'l', 'w', 'l','w' },
            { 'l', 'l', 'l','w' },
            { 'w', 'w', 'w','w' },
            { 'w', 'w', 'w','w' },
            { 'w', 'w', 'w','l' } };


        System.out.println("Number of rectangular islands is: " + islands.countIslands(mat1));
    }


    boolean isSafe(char M[][], int row, int col,
                   boolean visited[][])
    {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] =='l' && !visited[row][col]);
    }

    // A utility function to do DFS for a 2D boolean matrix.
    // It only considers the 8 neighbors as adjacent vertices
    void DFS(char M[][], int row, int col, boolean visited[][])
    {
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
        int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
        int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k){
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited)){
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
            }
        }

    }

    // The main function that returns count of islands in a given
    // boolean 2D matrix
    int countIslands(char M[][])
    {
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        boolean visited[][] = new boolean[ROW][COL];

        // Initialize count as 0 and travese through the all cells
        // of given matrix
        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (M[i][j] == 'l' && !visited[i][j]) // If a cell with
                { // value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    DFS(M, i, j, visited);
                    ++count;
                }

        return count;
    }
}
