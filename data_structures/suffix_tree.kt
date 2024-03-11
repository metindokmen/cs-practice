// Suffix Tree is a powerful data structure used in string processing tasks such as pattern matching, substring search, and various bioinformatics applications.

// 1. Concept: A suffix tree is a compressed trie-like data structure specifically designed for storing all the suffixes of a string in a way that allows for efficient pattern matching and substring search operations.

// 2. Structure:
// - Each edge in the tree represents a substring of the original string.
// - Suffixes are stored as paths from the root to the leaf nodes.
// - The tree is constructed such that each internal node (except the root) has at least two children.
// - The lebals on the edges are non-empty substrings of the original string.

// 3. Operations:
// - Construction: Build the suffix tree from a given string. Various algorithms like Ukkonen's algorithm are available for constructing suffix trees efficiently.
// - Pattern Matching: Find occurences of a pattern within the original string by traversing the suffix tree.
// - Longest Common Substring: Determine the longest common substring shared by two or more strings by finding the deepest internal node with leaf nodes from all input strings.

// Consider a text editor that needs to provide functionalities like searching for occurrences of a particular word or finding the longest repeated substring.
// Suffix trees can efficiently handle these tasks by representing all suffixes of a given string.

class SuffixTreeNode(var start: Int, var end: Int)

class SuffixTree {
    private val root: SuffixTreeNode = SuffixTreeNode(-1, -1)

    fun buildSuffixTree(text: String) {
        for (i in text.indices) {
            insertSuffix(text.substring(i), i)
        }
    }

    private fun insertSuffix(suffix: String, index: Int) {
        var currentNode = root
        for (char in suffix) {
            if (!currentNode.children.containsKey(char)) {
                currentNode.children[char] = SuffixTreeNode(index, text.length - 1)
                return
            }
            currentNode = currentNode.children[char]!!
        }
    }

    fun searchPattern(pattern: String): Boolean {
        var currentNode = root
        for (char in pattern) {
            if (!currentNode.children.containsKey(char)) {
                return false
            }
            currentNode = currentNode.children[char]!!
        }
        return true
    }
}
