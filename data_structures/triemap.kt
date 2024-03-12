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

// 3. Operations:
// - Insertion: Insert a key-value pair into the TrieMap. Traverse down the trie, creating new nodes as needed, and store the value at the leaf node.
// - Lookup: Search for a key in the TrieMap. Traverse down the trie following the characters in the key and check if the key exists at the leaf node.
// - Prefix Search: Find all keys with a given prefix efficiently by traversing down the trie to the node representing the prefix and then performing a depth-first search to collect keys from the subtree rooted at that node.
// - Deletion: Remove a key-value pair from the TrieMap. Traverse down the trie to find the key and delete it from the leaf node.

class TrieMapNode(var value: Int? = null) {
    val children: MutableMap<Char, TrieMapNode> = mutableMapOf()
}

class TrieMap {
    private val root: TrieMapNode = TrieMapNode()

    fun insert(key: String, value: Int) {
        var currentNode = root
        for (char in key) {
            if (!currentNode.children.containsKey(char)) {
                currentNode.children[char] = TrieMapNode()
            }
            currentNode = currentNode.children[char]!!
        }
        currentNode.value = value
    }
}