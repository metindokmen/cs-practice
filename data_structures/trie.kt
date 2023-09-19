// A trie is a tree-like data structure that stores a dynamic set of strings.
// It's useful for implementing dictionaries with efficient search, insert and delete operations.

// Think of a contact list on your phone with thousands of names.
// Every time you start typing a name in the search bar, the phone suggests possible matches.
// This can be implemented using a trie.
// Each node of a trie represents a character, and a path from the root to a node represents a string or a prefix of a string.
// The end of a way is usually marked with a special end-of-word marker.

// With tries:
// Lookup operations are faster than with other data structures like hash tables.
// They can be used for auto-suggestions.
// They can efficiently retrieve all keys with a common prefix.

class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    val isEndOfWord = false
}

class Trie {
    private val root = TrieNode()

    fun insert(word: String) {
        val currentNode = root
        for (ch in word) {
            currentNode = currentNode.children.computeIfAbsent(ch) { TrieNode() }
        }
        currentNode.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        var currentNode = root
        for (ch in word) {
            currentNode = currentNode.children[ch] ?: return false
        }
        return currentNode.isEndOfWord
    }

    fun startsWith(prefix: String): Boolean {
        var currentNode = root
        for (ch in prefix) {
            currentNode = currentNode.children[ch] ?: return false
        }
        return true
    }
}

fun main() {
    val trie = Trie()
    trie.insert("apple")
    trie.insert("app")

    println(trie.search("apple")) // true
    println(trie.search("app")) // true
    println(trie.search("appl")) // false
    println(trie.startsWith("app")) // true
    println(trie.startsWith("apl")) // false
}