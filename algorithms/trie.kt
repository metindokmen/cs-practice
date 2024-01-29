// A Trie is a tree-like data structure where each node represents a single character of a key.
// The root node represents an empty string, and each subsequent node represents a character in the key.
// The path from the root to a particular node forms the key associated with that node.
// Trie nodes typically have pointers to child nodes, representing the characters that can follow the current character in the key.
// Trie nodes may also contain additional information such as whether the node represents the end of a word.

// Consider a dictionary application where users can search for words quickly.
// Implementing autocomplete functionality allows users to see suggestions as they type.
// A Trie data structure enables this feature by efficiently storing and retrieving words, making it suitable for such applications.

class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    var isEndOfWord = false
}

class Trie {
    private val root = TrieNode()

    fun insert(word: String) {
        var currentNode = root
        for (char in word) {
            currentNode = currentNode.children.getOrPut(char) { TrieNode() }
        }
        currentNode.isEndOfWord = true
    }

}