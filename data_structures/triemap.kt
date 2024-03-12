// TrieMap is a data structure which is a hybrid of a trie and a hash map.
// It combines the efficient prefix search capability of a trie with the quick key-value lookup of a hash map.

// 1. Concept:
// TrieMap is a data structure that combines the properties of a trie and a hash map.
// It organizes keys in a trie-like structure, where each node represents a prefix of the stored keys.
// At the leaf nodes, key-value paris are stored like in a hash map.

// 2. Structure:
// - TrieMap consists of nodes, where each node contains a map of child nodes (character to node mapping) and an optinal value associated with the node.
// - Keys are stored by traversing down the trie, with each character in the key corresponding to a level in the trie.
// - At leaf nodes, key-value pairs are stored.
