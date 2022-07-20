package main.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DijkastraToMinDistance {

    List<List<Edge>> graph;
    boolean visited[];
    int distances[];


    public DijkastraToMinDistance(int nodes) {
        visited = new boolean[nodes];
        graph = new ArrayList<>();
        distances = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            graph.add(i, new ArrayList<>());
            distances[i] = Integer.MAX_VALUE;
        }
    }

    public void addEdge(int source, int dest, int distance) {
        graph.get(source).add(new Edge(distance, dest));
    }

    class Edge {
        int distance;
        int targetIndex;

        public Edge(int distance, int targetIndex) {
            this.distance = distance;
            this.targetIndex = targetIndex;
        }
    }

    public int minDistance(int source, int destination) {
        if (source == destination)
            return 0;
        PriorityQueue<Edge> minHeap = new PriorityQueue<>((e1, e2) -> e1.distance - e2.distance);

        distances[source] = 0;
        minHeap.add(new Edge(0, 0));

        while (!minHeap.isEmpty()) {
            int v = minHeap.poll().targetIndex;

            if (visited[v])
                continue;

            visited[v] = true;

            List<Edge> childList = graph.get(v);

            for (Edge edge : childList) {

                int distance = edge.distance;
                int childNode = edge.targetIndex;

                if (!visited[childNode] && (distances[v] + distance < distances[childNode])) {
                    distances[childNode] = distances[v] + distance;
                    edge.distance = distances[v] + distance;
                    minHeap.add(edge);
                }

            }
        }
        return distances[destination];
    }

    public static void main(String[] args) {
        int nodes = 5;

        DijkastraToMinDistance a = new DijkastraToMinDistance(nodes);

        a.addEdge(0, 1, 1);
        a.addEdge(0, 2, 7);
        a.addEdge(1, 2, 5);
        a.addEdge(1, 4, 4);
        a.addEdge(4, 3, 2);
        a.addEdge(2, 3, 6);

        System.out.println(a.minDistance(0, 3));
    }
}
