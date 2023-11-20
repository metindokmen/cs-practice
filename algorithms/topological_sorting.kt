// Topological Sorting of a directed graph is a linear ordering of its vertices such that for every directed edge UV from vertex U to vertex V, U comes before V in the ordering.
// This algorithm is used in scenarios where there is a dependency between tasks or components.
// It's important to note that topoplogical sorting is possible only if the graph has no directed cycles, i.e., if it's a Directed Acyclic Graph (DAG).

// Imagine you're a project manager handling a complex project with many interdependent tasks.
// Some tasks cannot begin until others are completed.
// For instance, you can't start painting a house until the construction is finished.
// In such scenarios, determining an order in which undertake tasks while respecting their dependencies is crucial.
// This is where topoplogical sorting comes in handy.
