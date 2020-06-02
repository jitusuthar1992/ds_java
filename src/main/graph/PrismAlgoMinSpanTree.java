package main.graph;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrismAlgoMinSpanTree {

    List<List<Edge>> graph;
    int nodes ;
    boolean visited[];

    public PrismAlgoMinSpanTree(int nodes) {
        this.nodes = nodes;
        visited = new boolean[nodes];
        graph = new ArrayList<>();

        for (int i = 0; i <nodes ; i++) {
            graph.add(i,new ArrayList<>());
        }
    }

    class Edge {
        int distance ;
        int targetIndex;

        public Edge(int distance, int targetIndex) {
            this.distance = distance;
            this.targetIndex = targetIndex;
        }
    }

    public void addEdge(int source , int dest , int distance){
        graph.get(source).add(new Edge(distance,dest));
        graph.get(dest).add(new Edge(distance,source));

    }
    public int minDistanceSpanTree(int source){
        int minCost = 0;
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.distance));
        visited[source] = true;
        List<Edge> childOfSource = graph.get(source);

        for (Edge edge: childOfSource) {
            minHeap.add(edge);
        }

        while (!minHeap.isEmpty()){
            Edge edge = minHeap.poll()  ;
            if(visited[edge.targetIndex])
                continue;

            visited[edge.targetIndex] = true;
            minCost = minCost + edge.distance;

            List<Edge> childList = graph.get(edge.targetIndex);

            for(Edge child: childList) {
                minHeap.add(child);
            }
        }
        return minCost;
    }

    public int minCost(){
        int minCost =0 ;

        for (int i = 0; i <nodes ; i++) {
            if(!visited[i]){
                minCost = minCost = minDistanceSpanTree(i);
            }
        }
        return minCost;
    }
    public static void main(String[] args) {
        int nodes = 5;

        PrismAlgoMinSpanTree a = new PrismAlgoMinSpanTree(nodes);

        a.addEdge(0, 1, 6);
        a.addEdge(0, 3, 4);
        a.addEdge(1, 2, 10);
        a.addEdge(1, 3, 7);
        a.addEdge(1, 4, 7);
        a.addEdge(2, 3, 8);
        a.addEdge(2, 4, 5);
        a.addEdge(3, 4, 12);

        System.out.println(a.minCost());
    }

}
