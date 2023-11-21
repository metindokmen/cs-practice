// Tarjan's algorithm is used to find all SCCs in a directed graph. A SCC in a directed graph is a set of vertices where every vertex is reachable from every other vertex in the set.
// The algorithm uses depth-first search (DFS) and has a linear time complexity relative to the number of vertices and edges.

// Imagine a social network where each person is a node and friendships are directed edges (i.e., just because person A considers B a friend doesn't mean B considers A a friend).
// In this network, a group of people who are all mutually connected (directly or indirectly) forms a strongly connected component.
// Understanding these components can be crucial for features like group recommendations or targeted advertising.
