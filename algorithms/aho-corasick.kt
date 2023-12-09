// The Aho-Corasick algorithm is a string-searching algorithm that constructs a finite-state matching from a set of strings (like a trie with additional links between the various internal nodes).
// It can match all strings simultaneously in a text, making it efficient for searching multiple patterns.
// This is particularly useful in applications like search engines, text analysis, and digital content filtering.

// Imagine you're developing a content moderation system for a social media platform.
// You have a list of prohibited words and phrases, and you need to scan through user posts to identify any occurrences of these terms.
// The Aho-Corasick algorithm can efficiently search for multiple patterns (prohibited words) in a text (user post) simultaneously.

class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    var isEndOfWord = false
}

class AhoCorasick {
    private val root = TrieNode()

    fun insert(word: String) {
        var currentNode = root
        for (ch in word) {
            currentNode = currentNode.children.computeIfAbsent(ch) { TrieNode() }
        }
        currentNode.isEndOfWord = true
    }

    fun search(text: String): Boolean {
        var currentNode = root
        for (ch in text) {
            while (currentNode != root && ch !in currentNode.children) {
                currentNode = currentNode.children['#'] ?: root // Backtrack using failure link
            }
            currentNode = currentNode.children[ch] ?: root
            if (currentNode.isEndOfWord) {
                return true
            }
        }
        return false
    }

    // Additional methods to build failure links would be implemented inside this class.
}

fun main() {
    val ac = AhoCorasick()
    ac.insert("word1")
    ac.insert("word2")
    ac.insert("word3")

    val text = "Sample text containing word2"
    println("Does the text contain any words? ${ac.search(text)}")
}
