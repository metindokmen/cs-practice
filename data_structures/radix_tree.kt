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

// Consider an autocomplete feature in a search engine or text editor.
// As users type, the system needs to quickly suggest potential completions based on the entered prefix.
// A radix tree efficiently organizes a large dictionary of words, enabling fast prefix searches.

class RadixTreeNode {
    val children: MutableMap<Char, RadixTreeNode> = mutableMapOf()
    var isEndOfWord: Boolean = false
}

class RadixTree {
    private val root: RadixTreeNode = RadixTreeNode()

    fun insert(key: String) {
        var currentNode = root
        for (char in key) {
            if (!currentNode.children.containsKey(char)) {
                currentNode.children[char] = RadixTreeNode()
            }
            currentNode = currentNode.children[char]!!
        }
        currentNode.isEndOfWord = true
    }

    fun search(key: String): Boolean {
        var currentNode = root
        for (char in key) {
            if (!currentNode.children.containsKey(char)) {
                return false
            }
            currentNode = currentNode.children[char]!!
        }
        return currentNode.isEndOfWord
    }

    fun startsWith(prefix: String): Boolean {
        var currentNode = root
        for (char in prefix) {
            if (!currentNode.children.containsKey(char)) {
                return false
            }
            currentNode = currentNode.children[char]!!
        }
        return true
    }
}

fun main() {
    val radixTree = RadixTree()
    radixTree.insert("apple")
    radixTree.insert("application")
    radixTree.insert("banana")

    println("Search for 'apple": ${radixTree.search("apple")}) // Output: Search for 'apple': true
    println("Search for 'app": ${radixTree.startsWith("app")}) // Output: Search for 'app': true
    println("Search for 'orange": ${radixTree.search("orange")}) // Output: Search for 'orange': false
}
