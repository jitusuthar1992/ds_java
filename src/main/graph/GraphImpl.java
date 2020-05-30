package main.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphImpl {


    private int MAX_VERTEX = 20;
    private Vertex[] vertices;
    private int[][] adjacencyMat ;
    private int nVerices;
    private Stack<Integer> stack;

    private Queue<Integer> queue;

    public GraphImpl() {
        this.vertices = new Vertex[MAX_VERTEX];
        this.adjacencyMat = new int[MAX_VERTEX][MAX_VERTEX];
        this.nVerices = 0;
        this.stack = new Stack<>();
        this.queue = new LinkedList<>();
    }

    public void addVertex(char label){
      vertices[nVerices++] = new Vertex(label);
    }

    public void addEdge(int start, int end){
        adjacencyMat[start][end]=1;
        adjacencyMat[end][start]=1;
    }


    public void displayvertex(int v){
        System.out.println("Vertex :"+vertices[v].label);
    }
    public int getUnvisitedVertex(int v){
        for (int i = 0; i < nVerices; i++) {
            if(adjacencyMat[v][i] ==1 && vertices[i].wasVisited== false){
                return i;
            }
        }
        return -1;
    }

    class Vertex {
        char label;
        boolean wasVisited;

        public Vertex(char label) {
            this.label = label;
            this.wasVisited = false;
        }
    }


    public static void main(String[] args) {
        GraphImpl graph = new GraphImpl();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');

        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(0,3);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(1,3);

        //graph.minSpanTree();

//        System.out.println("DFS Visites :");
//        graph.dfs();
//        System.out.println();

        System.out.println("BFS Visites :");
        graph.bfs();
        System.out.println();





    }


    public void bfs(){
        vertices[0].wasVisited =true;
        displayvertex(0);
        queue.offer(0);

        int v2;
        while (!queue.isEmpty()){
            int v1 = queue.poll();

            while ((v2= getUnvisitedVertex(v1))!=-1){
                vertices[v2].wasVisited = true;
                displayvertex(v2);
                queue.add(v2);
            }
        }
    }

    public void minSpanTree(){
        vertices[0].wasVisited = true;
        stack.push(0);

        while (!stack.isEmpty()){
            int current = stack.peek();

            int v = getUnvisitedVertex(current);

            if(v==-1)
                stack.pop();
            else{
                vertices[v].wasVisited= true;
                displayvertex(current);
                displayvertex(v);
                System.out.println();
                stack.push(v);
            }
        }
    }
    public void dfs() {
        vertices[0].wasVisited = true;
        displayvertex(0);
        stack.push(0);

        while (!stack.isEmpty()){
            int v = getUnvisitedVertex(stack.peek());
            if(v == -1)
                stack.pop();
            else {
                vertices[v].wasVisited = true;
                displayvertex(v);
                stack.push(v);
            }
        }
    }
}
