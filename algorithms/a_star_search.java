// The A* algorithm combines elements of Dijkstra's algorithm and greedy best-first search.
// It uses a heuristic function to estimate the cost of reaching the target from any given node.
// A priority queue (min-heap) is employed to explore the most promising paths first based on a combined cost function.

// Steps for A* Search Algorithm:
// 1. Initialize the start node with a cost of 0 and add it to the priority queue.
// 2. While the priority queue is not empty:
// - Dequeue the node with the lowest combined cost (`f = g + h`), where `g` is the known cost from the start node to the current node,
// and `h` is the estimated cost from the current node to the target.
// - If the dequeued node is the target node, reconstruct the path.
// - Otherwise, expand the node by considering its neighbors and update their costs if a cheaper path is found.
// 3. Use a heuristic function (e.g., Euclidean distance, Manhattan distance) to estiamte `h` (the cost from the current node to the target).

// Imagine you're developing a navigation system for a delivery service.
// The A* algorithm can be used to find the shortest route between two locations on a map, considering factors like distance, traffic conditions, and travel time.

import java.util.*;

class Node implements Comparable<Node> {
    int id;
    double f; // Combined cost f = g + h
    double g; // Cost from start node to current node
    double h; // Heuristic estimate to target node
    List<Edge> neighbors;

    Node(int id) {
        this.id = id;
        this.f = Double.POSITIVE_INFINITY;
        this.g = Double.POSITIVE_INFINITY;
        this.h = 0.0;
        this.neighbors = new ArrayList<>();
    }

    @Override
    public int compareTo(Node other) {
        return Double.compare(this.f, other.f);
    }
}

class Edge {
    Node target;
    double weight;

    Edge(Node target, double weight) {
        this.target = target;
        this.weight = weight;
    }
}
