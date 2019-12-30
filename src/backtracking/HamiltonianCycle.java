package backtracking;

public class HamiltonianCycle {
    private int vertexSize;
    private int path[];
    private int matrix[][];

    public HamiltonianCycle(int vertexSize, int[][] matrix) {
        this.vertexSize = vertexSize;
        this.path = new int[vertexSize];
        this.matrix = matrix;
    }


    public static void main(String args[])
    {
        int graph1[][] = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };

        HamiltonianCycle hamiltonian =
                new HamiltonianCycle(graph1.length,graph1);
        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)-------(4)    */


        // Print the solution
        hamiltonian.hamCycle();
    }

    private int hamCycle() {
        for (int i = 0; i < vertexSize; i++)
            path[i] = -1;

        path[0] =0;
        if (!hamCycleUtil( 1) )
        {
            System.out.println("\nSolution does not exist");
            return 0;
        }
        printSolution();
        return 1;

    }

    private void printSolution() {
        for (int i = 0; i <vertexSize ; i++) {
            System.out.print(path[i]+" ");
        }
        System.out.println(path[0]);
    }

    private boolean hamCycleUtil(int pos) {
        if (vertexSize == pos)
        {
            // And if there is an edge from the last included
            // vertex to the first vertex
            if (matrix[path[pos - 1]][path[0]] == 1)
                return true;
            else
                return false;
        }
        for (int v = 1; v <vertexSize ; v++) {
            if(isSafe(v,pos)){
                path[pos] = v;

                if(hamCycleUtil(pos+1))
                    return true;
                path[pos]=-1;
        }
    }
    return false;
}

    private boolean isSafe(int v, int pos) {
        /* Check if this vertex is an adjacent vertex of
        the previously added vertex. */
        if(matrix[path[pos-1]][v]==0){
            return false;
        }
        for (int i = 0; i <pos ; i++) {
            if(path[i]==v){
                return false;
            }
        }
        return true;
    }

}
