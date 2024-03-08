// Radix Tree (also known as radix trie or compact prefix tree) is a data structure used for storing a set of keys in a memory-efficient manner, particularly in scenarios where keys are strings.

// 1. Concept:
// A radix tree is a space-optimized trie where each node represents a common prefix shared by its children.
// It is particularly efficient for storing and searching keys with a large common prefix.

// 2. Structure
// - Each node in the tree represents a character.
// - Nodes are arranged in a hierarchical manner, with the root node at the top.
// - Leaf nodes typically indicate the end of a key and may contain additional information associated with the key.

// 3. Operations:
// - Insertion: Insert a key into the radix tree by traversing the tree and creating nodes as necessary.
// - Search: Search for a key by traversing the tree from the root, following edges corresponding to characters in the key.
// - Prefix Search: Find all keys with a given prefix by traversing the tree up to the node representing the prefix and performing a depth-first search from that node.
