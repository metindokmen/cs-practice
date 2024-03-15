// The Red-Black Tree is a self-balancing binary search tree that maintains balance during insertions and deletions.

// 1. Concept: A red-black tree is a binary search tree with the following properties:
// - Each node is colored either red or black.
// - The root is always black.
// - No two red nodes can appear consecutively along any path.
// - Every path from a node to its descendant NIL nodes (external nodes) has the same number of black nodes.

// 2. Balancing:
// - During insertion or deletion, the tree is adjusted to maintain its balance and satisfy the red-black properties.
// - Rotations and color changes are performed to ensure the tree remains balanced.

// 3. Operations:
// - Insertion: Add a new node while preserving the red-black properties. This may involve rotations and recoloring to maintain balance.
// - Deletion: Remove a node from the tree while ensuring the red-black properties are maintained. Similar to insertion, rotations and recoloring may necessary.
// - Search: Find a node with a given key in the tree, similar to binary search tree operations.
