package main.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jitendra.kumar01
 * 03/02/20
 */
public class Graph {

    int                 V;
    LinkedList<Integer> adj[];

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }


    void addEdge(int v,int w) {
        adj[v].add(w);
    }

    void bfs(int s){
        boolean visited[] = new boolean[V];

        Queue<Integer> queue = new  LinkedList();

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()){
            s = queue.poll();
            System.out.println(s+" ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }

        }
    }
    public static void main(String args[])
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                                   "(starting from vertex 2)");

        g.bfs(2);

        System.out.println("Following is Depth First Traversal "+
                                   "(starting from vertex 2)");

        g.dfs(2);
    }


    public void dfs(int v){
        boolean visited[] = new boolean[V];
        dfsUtil(visited,v);
    }

    public void dfsUtil(boolean[] visited, int v) {
        visited[v]= true;
        System.out.println(v);
        Iterator itr = adj[v].listIterator();

        while (itr.hasNext()){
            int s = (int) itr.next();
            if(!visited[s]){
                dfsUtil(visited,s);
            }

        }
    }

}
