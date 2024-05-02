// Topological Sorting is used to order the vertices in a directed graph such that for every directed edge `u -> v`, vertex `u` comex before vertex `v` in the ordering.
// This ordering is possible if the graph is a Directed Acyclic Graph (DAG).

// Consider the course prerequisites in a university.
// Each course has dependencies (prerequisites) that must be completed before taking the course.
// Topological sorting can be used to determine the order of courses to be taken, ensuring that all prerequisites are fulfilled.

import java.util.*;

class Graph {
    private int vertices;
    private List<List<Integer>> adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
    }

    public List<Integer> topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }

        List<Integer> topologicalOrder = new ArrayList<>();
        while (!stack.isEmpty()) {
            topologicalOrder.add(stack.pop());
        }

        return topologicalOrder;
    }

    private void dfs(int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;
        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack);
            }
        }
        stack.push(vertex);
    }
}
