// The Ford-Fulkerson algorithm computes the maximum flow in a flow network.
// It identifies possible paths from the source to the sink while incrementally increasing the flow along these paths.
// The algorithm continues until no more augmenting paths from the source to the sink are are available.
// The "augmenting path" is a path where the flow can be increased.

// Consider a network of water pipes connecting a reservoir to a village.
// Each pipe has a capacity limit, and you want to determine the maximum amount of water that can be transported from the reservoir to the village through this network of pipes.
// This is a classic example of a Maximum Flow Problem.
