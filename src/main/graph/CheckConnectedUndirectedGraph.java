package main.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CheckConnectedUndirectedGraph {
    List<List<Integer>> graph;
    int nodes;
    boolean visited[];

    public CheckConnectedUndirectedGraph(int nodes) {
        this.nodes = nodes;
        visited = new boolean[nodes];

        for (int i = 0; i <nodes ; i++) {
            graph.add(i, new ArrayList<>());
        }
    }

    public void addEdge(int a , int b){
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    public boolean isUnDirectedGraphConnected(){
        dfs(0);
        for (int i = 0; i <nodes ; i++) {
            if(!visited[i])
                return false;
        }
        return true;
    }
    public void dfs(int start){
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start]= true;

        while (!stack.isEmpty()){
            Integer node = stack.pop();
            List<Integer> neighbours = graph.get(node);

            for (Integer neighbour: neighbours) {
                if(!visited[neighbour]){
                    stack.push(neighbour);
                    visited[neighbour]= true;
                }
            }

        }
    }

    public static void main(String[] args) {
        int nodes = 7;

        CheckConnectedUndirectedGraph a = new CheckConnectedUndirectedGraph(nodes);

        a.addEdge(0, 1);
        a.addEdge(0, 2);
        a.addEdge(1, 3);
        a.addEdge(2, 4);
        a.addEdge(3, 5);
        a.addEdge(4, 5);
        //a.addEdge(4, 6);

        System.out.println(a.isUnDirectedGraphConnected());
    }


    public boolean isDirectedGraphConnected(){
        for (int i = 0; i <nodes ; i++) {
            dfs(i);

            for (int j = 0; j <nodes ; j++) {
                if(!visited[j]){
                    return false;
                }
            }

            Arrays.fill(visited,false);
        }
        return true;

    }

    public boolean ifSourceConnectedToDestination(int source, int destination) {

        dfs(source);

        return visited[destination];
    }


    public int connectedComponents(){
        int noOfComponents =0;

        for (int i = 0; i <nodes ; i++) {

            if(!visited[i]){
                dfs(i);
                noOfComponents++;
            }

        }

        return noOfComponents;
    }
}
