package main.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinDistanceSourceDestination {
    List<List<Integer>> graph;
    boolean visited[];

    public MinDistanceSourceDestination(int nodes) {
        visited = new boolean[nodes];
        graph = new ArrayList<>();
        for (int i = 0; i <nodes ; i++) {
            graph.add(i,new ArrayList<>());
        }
    }

    public void addEdge(int a , int b){
        graph.get(a).add(b);
    }

    public int minDistance(int sourceIndex , int desIndex){
        if(sourceIndex == desIndex)
            return 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(sourceIndex);
        visited[sourceIndex] = true;

        int minDistance = 0;
        while (!queue.isEmpty()){
            int size = queue.size();

            while (size > 0){
                Integer node = queue.poll();

                List<Integer> children = graph.get(node);

                for (Integer child: children) {
                    if(child == desIndex){
                        return ++minDistance;
                    }

                    if(!visited[child]){
                        queue.add(child);
                        visited[child]= true;
                    }
                }
                size --;
            }
            minDistance++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int nodes = 6;

        MinDistanceSourceDestination a = new MinDistanceSourceDestination(nodes);

        a.addEdge(0, 1);
        a.addEdge(0, 3);
        a.addEdge(1, 2);
        a.addEdge(3, 4);
        a.addEdge(2, 4);
        a.addEdge(4, 5);

        System.out.println(a.minDistance(0, 5));
    }
}
