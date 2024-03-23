// The Breadth-First Search (BFS) algorithm is used for traversing or searching tree or graph data structures.
// BFS starts at a specific node of a graph, visits all of its neighbors at the present depth, and then moves on to the nodes at the next depth level.

// BFS can be applied to find the shortest path in a network, such as the shortest route to travel from one city to another in a transportation network.

import java.util.LinkedList;
import java.util.Iterator;

public class BFS {
    static class Graph {
        private int V;
        private LinkedList<Integer>[] adj;

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void BFS(int s) {
            boolean[] visited = new boolean[V];
            LinkedList<Integer> queue = new LinkedList<>();

            visited[s] = true;
            queue.add(s);

            while (queue.size() != 0) {
                s = queue.poll();
                System.out.print(s + " ");

                Iterator<Integer> i = adj[s].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }
    }


}